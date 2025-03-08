package br.gov.receita.reinf.util;

import org.apache.xml.security.Init;
import org.apache.xml.security.algorithms.MessageDigestAlgorithm;
import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.transforms.Transforms;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public class XMLSignatureUtil {

    static {
        Init.init();
    }

    public static String signXml(InputStream xmlInputStream, InputStream keystoreInputStream, String keystorePassword, String alias) throws Exception {
        // Load keystore (PKCS12)
        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(keystoreInputStream, keystorePassword.toCharArray());

        // Parse the XML into Document
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.parse(xmlInputStream);

        PrivateKey privateKey = (PrivateKey) ks.getKey(alias, keystorePassword.toCharArray());
        X509Certificate certificate = (X509Certificate) ks.getCertificate(alias);

        return signDocument(doc, privateKey, certificate);
    }

    // Overload for convenience (String input)
    public static String signXml(String xmlPayload, InputStream keystoreInputStream, String keystorePassword, String alias) throws Exception {
        try (InputStream xmlStream = new ByteArrayInputStream(xmlPayload.getBytes(StandardCharsets.UTF_8))) {
            return signXml(xmlStream, keystoreInputStream, keystorePassword, alias);
        }
    }

    // Overload for convenience (KeyStore input)
    public static String signXml(InputStream xmlInputStream, KeyStore keystore, String keystorePassword, String alias) throws Exception {
        // Parse the XML into Document
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.parse(xmlInputStream);

        PrivateKey privateKey = (PrivateKey) keystore.getKey(alias, keystorePassword.toCharArray());
        X509Certificate certificate = (X509Certificate) keystore.getCertificate(alias);

        return signDocument(doc, privateKey, certificate);
    }

    // Overload for convenience (String input and KeyStore)
    public static String signXml(String xmlPayload, KeyStore keystore, String keystorePassword, String alias) throws Exception {
        try (InputStream xmlStream = new ByteArrayInputStream(xmlPayload.getBytes(StandardCharsets.UTF_8))) {
            return signXml(xmlStream, keystore, keystorePassword, alias);
        }
    }

    /**
     * Helper method that performs the actual XML signing process
     * 
     * @param doc XML document to sign
     * @param privateKey Private key used for signing
     * @param certificate Certificate to include in the signature
     * @return Signed XML as a string
     * @throws Exception If any error occurs during signing
     */
    private static String signDocument(Document doc, PrivateKey privateKey, X509Certificate certificate) throws Exception {
        // Create XML Signature object
        XMLSignature xmlSignature = new XMLSignature(doc, "", XMLSignature.ALGO_ID_SIGNATURE_RSA_SHA256);
        doc.getDocumentElement().appendChild(xmlSignature.getElement());

        // Define XML Signature transforms (Canonicalization and Enveloped)
        Transforms transforms = new Transforms(doc);
        transforms.addTransform(Transforms.TRANSFORM_ENVELOPED_SIGNATURE);
        transforms.addTransform(Transforms.TRANSFORM_C14N_WITH_COMMENTS);

        // Add the whole document as reference
        xmlSignature.addDocument("", transforms, MessageDigestAlgorithm.ALGO_ID_DIGEST_SHA256);

        // Add certificate (KeyInfo)
        xmlSignature.addKeyInfo(certificate);
        xmlSignature.addKeyInfo(certificate.getPublicKey());

        // Perform XML Signature
        xmlSignature.sign(privateKey);

        // Transform Document back to String
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        ByteArrayOutputStream signedXmlOutputStream = new ByteArrayOutputStream();
        transformer.transform(new DOMSource(doc), new StreamResult(signedXmlOutputStream));

        return signedXmlOutputStream.toString("UTF-8");
    }
}
