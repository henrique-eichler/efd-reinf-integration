package br.gov.receita.reinf.util;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class XMLSignatureUtilTest {

    @BeforeAll
    static void setUp() {
        // Register BouncyCastle as a security provider
        Security.addProvider(new BouncyCastleProvider());
    }

    private KeyStore createTestKeystore(String alias, String password) throws Exception {
        // Generate RSA Key Pair
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();

        // Generate self-signed certificate using BouncyCastle
        long now = System.currentTimeMillis();
        Date startDate = new Date(now);
        Date endDate = new Date(now + (365L * 86400000L)); // 1 year validity

        X500Name dnName = new X500Name("CN=Test Certificate");
        BigInteger certSerialNumber = new BigInteger(64, new SecureRandom());

        // Create certificate builder
        X509v3CertificateBuilder certBuilder = new JcaX509v3CertificateBuilder(
                dnName,
                certSerialNumber,
                startDate,
                endDate,
                dnName,
                keyPair.getPublic());

        // Create certificate signer
        ContentSigner contentSigner = new JcaContentSignerBuilder("SHA256withRSA")
                .setProvider(BouncyCastleProvider.PROVIDER_NAME)
                .build(privateKey);

        // Generate certificate
        X509Certificate certificate = new JcaX509CertificateConverter()
                .setProvider(BouncyCastleProvider.PROVIDER_NAME)
                .getCertificate(certBuilder.build(contentSigner));

        // Create keystore and set entry
        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(null, password.toCharArray());
        ks.setKeyEntry(alias, privateKey, password.toCharArray(), new Certificate[]{certificate});

        return ks;
    }

    @Test
    void testXmlSignatureGeneration() throws Exception {
        String xmlPayload = "<Reinf><example>Test Data</example></Reinf>";
        String keystorePassword = "test123";
        String alias = "test-alias";

        KeyStore keystore = createTestKeystore(alias, keystorePassword);

        // Print debug information
        System.out.println("[DEBUG_LOG] XML Payload: " + xmlPayload);
        System.out.println("[DEBUG_LOG] Keystore Type: " + keystore.getType());
        System.out.println("[DEBUG_LOG] Keystore contains alias: " + keystore.containsAlias(alias));
        System.out.println("[DEBUG_LOG] Certificate: " + keystore.getCertificate(alias));

        // Use the new overloaded method that accepts a KeyStore directly
        String signedXml = XMLSignatureUtil.signXml(
                xmlPayload,
                keystore,
                keystorePassword,
                alias
        );

        System.out.println("[DEBUG_LOG] Signed XML:\n" + signedXml);

        assertNotNull(signedXml, "Signed XML should not be null");
        assertTrue(signedXml.contains("<ds:Signature"), "XML should contain Signature element with namespace");
    }
}
