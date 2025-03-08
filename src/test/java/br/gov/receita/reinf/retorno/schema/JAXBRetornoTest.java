package br.gov.receita.reinf.retorno.schema;

import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JAXBRetornoTest {

    @Test
    public void testUnmarshallRetornoReinf() throws Exception {
        JAXBContext context = JAXBContext.newInstance(Reinf.class);

        String exampleXml = "<Reinf xmlns=\"http://www.reinf.esocial.gov.br/schemas/retornoLoteEventosAssincrono/v1_00_00\"/>";

        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(exampleXml);
        Reinf reinf = (Reinf) unmarshaller.unmarshal(reader);

        assertNotNull(reinf);

        // Validate specific fields
        // assertEquals("expected value", reinf.getDadosRecepcao().getNumeroProtocolo());

        System.out.println("Successfully unmarshalled RetornoReinf object");
    }
}
