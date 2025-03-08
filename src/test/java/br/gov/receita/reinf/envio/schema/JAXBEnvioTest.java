package br.gov.receita.reinf.envio.schema;

import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JAXBEnvioTest {

    @Test
    public void testMarshallEnvioReinf() throws Exception {
        JAXBContext context = JAXBContext.newInstance(Reinf.class);

        ObjectFactory factory = new ObjectFactory();
        Reinf reinf = factory.createReinf();

        // Set fields according to your schema here
        // reinf.setSomeField("Example Value");

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter writer = new StringWriter();
        marshaller.marshal(reinf, writer);

        String xmlOutput = writer.toString();
        System.out.println("Envio XML:\n" + xmlOutput);

        assertNotNull(xmlOutput);
        assertTrue(xmlOutput.contains("<Reinf"));
    }
}