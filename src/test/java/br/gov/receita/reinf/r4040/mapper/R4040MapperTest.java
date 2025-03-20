package br.gov.receita.reinf.r4040.mapper;

import br.gov.receita.reinf.r4040.entity.*;
import br.gov.receita.reinf.r4040.schema.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

class R4040MapperTest {

    private R4040Mapper mapper;
    private ObjectFactory objectFactory;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(R4040Mapper.class);
        objectFactory = new ObjectFactory();
    }

    @Test
    void testToEntity() {
        // Create a Reinf XML object with all necessary data
        Reinf reinf = createReinfXml();

        // Map to entity
        EventoRetencaoBeneficiarioNaoIdentificado entity = mapper.toEntity(reinf);

        // Verify the mapping
        assertNotNull(entity);
        assertEquals("ID1234567890", entity.getIdEvento());
        assertEquals(1, entity.getIndRetif());
        assertEquals("1.2.3456789", entity.getNrRecibo());
        assertEquals(YearMonth.of(2023, 1), entity.getPerApur());
        assertEquals(1, entity.getTpAmb());
        assertEquals(1, entity.getProcEmi());
        assertEquals("1.0", entity.getVerProc());

        // Verify contribuinte
        assertNotNull(entity.getContribuinte());
        assertEquals(1, entity.getContribuinte().getTpInsc());
        assertEquals("12345678901234", entity.getContribuinte().getNrInsc());

        // Verify estabelecimento
        assertNotNull(entity.getEstabelecimento());
        assertEquals(1, entity.getEstabelecimento().getTpInscEstab());
        assertEquals("12345678901234", entity.getEstabelecimento().getNrInscEstab());
        assertEquals("ID-ADICIONAL", entity.getEstabelecimento().getIdeEvtAdic());

        // Verify naturezasRendimento
        assertNotNull(entity.getEstabelecimento().getNaturezasRendimento());
        assertEquals(1, entity.getEstabelecimento().getNaturezasRendimento().size());
        NaturezaRendimento naturezaRendimento = entity.getEstabelecimento().getNaturezasRendimento().get(0);
        assertEquals("1234", naturezaRendimento.getNatRend());

        // Verify pagamentos
        assertNotNull(naturezaRendimento.getPagamentos());
        assertEquals(1, naturezaRendimento.getPagamentos().size());
        Pagamento pagamento = naturezaRendimento.getPagamentos().get(0);
        assertEquals(LocalDate.of(2023, 1, 15), pagamento.getDtFG());
        assertEquals(new BigDecimal("5000.00"), pagamento.getVlrLiq());
        assertEquals(new BigDecimal("4500.00"), pagamento.getVlrBaseIR());
        assertEquals(new BigDecimal("900.00"), pagamento.getVlrIR());
        assertEquals(LocalDate.of(2023, 1, 20), pagamento.getDtEscrCont());
        assertEquals("Pagamento não identificado", pagamento.getDescr());

        // Verify processosRetencao
        assertNotNull(pagamento.getProcessosRetencao());
        assertEquals(1, pagamento.getProcessosRetencao().size());
        ProcessoRetencao processoRetencao = pagamento.getProcessosRetencao().get(0);
        assertEquals(1, processoRetencao.getTpProcRet());
        assertEquals("12345678901234567890", processoRetencao.getNrProcRet());
        assertEquals("12345", processoRetencao.getCodSusp());
        assertEquals(new BigDecimal("1000.00"), processoRetencao.getVlrBaseSuspIR());
        assertEquals(new BigDecimal("200.00"), processoRetencao.getVlrNIR());
        assertEquals(new BigDecimal("50.00"), processoRetencao.getVlrDepIR());
    }

    @Test
    void testXmlGregorianCalendarToYearMonth() {
        // Test with valid XMLGregorianCalendar
        try {
            GregorianCalendar cal = new GregorianCalendar(2023, 0, 1); // January is 0
            XMLGregorianCalendar xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
            YearMonth result = mapper.xmlGregorianCalendarToYearMonth(xmlCal);
            assertEquals(YearMonth.of(2023, 1), result);
        } catch (Exception e) {
            fail("Failed to create XMLGregorianCalendar: " + e.getMessage());
        }

        // Test with null
        YearMonth result = mapper.xmlGregorianCalendarToYearMonth(null);
        assertNull(result);
    }

    @Test
    void testXmlGregorianCalendarToLocalDate() {
        // Test with valid XMLGregorianCalendar
        try {
            GregorianCalendar cal = new GregorianCalendar(2023, 0, 15); // January is 0
            XMLGregorianCalendar xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
            LocalDate result = mapper.xmlGregorianCalendarToLocalDate(xmlCal);
            assertEquals(LocalDate.of(2023, 1, 15), result);
        } catch (Exception e) {
            fail("Failed to create XMLGregorianCalendar: " + e.getMessage());
        }

        // Test with null
        LocalDate result = mapper.xmlGregorianCalendarToLocalDate(null);
        assertNull(result);
    }

    @Test
    void testStringToBigDecimal() {
        // Test with valid string
        BigDecimal result = mapper.stringToBigDecimal("1234.56");
        assertEquals(new BigDecimal("1234.56"), result);

        // Test with comma as decimal separator
        result = mapper.stringToBigDecimal("1234,56");
        assertEquals(new BigDecimal("1234.56"), result);

        // Test with null
        result = mapper.stringToBigDecimal(null);
        assertNull(result);
    }

    @Test
    void testToContribuinte() {
        // Create IdeContri
        Reinf.EvtBenefNId.IdeContri ideContri = objectFactory.createReinfEvtBenefNIdIdeContri();
        ideContri.setTpInsc((short) 1);
        ideContri.setNrInsc("12345678901234");

        // Map to entity
        Contribuinte contribuinte = mapper.toContribuinte(ideContri);

        // Verify the mapping
        assertNotNull(contribuinte);
        assertEquals(1, contribuinte.getTpInsc());
        assertEquals("12345678901234", contribuinte.getNrInsc());

        // Test with null
        assertNull(mapper.toContribuinte(null));
    }

    @Test
    void testToEstabelecimento() {
        // Create IdeEstab
        Reinf.EvtBenefNId.IdeEstab ideEstab = objectFactory.createReinfEvtBenefNIdIdeEstab();
        ideEstab.setTpInscEstab((short) 1);
        ideEstab.setNrInscEstab("12345678901234");
        ideEstab.setIdeEvtAdic("ID-ADICIONAL");

        // Create IdeNat
        Reinf.EvtBenefNId.IdeEstab.IdeNat ideNat = objectFactory.createReinfEvtBenefNIdIdeEstabIdeNat();
        ideEstab.getIdeNat().add(ideNat);
        ideNat.setNatRend("1234");

        // Map to entity
        Estabelecimento estabelecimento = mapper.toEstabelecimento(ideEstab);

        // Verify the mapping
        assertNotNull(estabelecimento);
        assertEquals(1, estabelecimento.getTpInscEstab());
        assertEquals("12345678901234", estabelecimento.getNrInscEstab());
        assertEquals("ID-ADICIONAL", estabelecimento.getIdeEvtAdic());
        assertNotNull(estabelecimento.getNaturezasRendimento());
        assertEquals(1, estabelecimento.getNaturezasRendimento().size());

        // Test with null
        assertNull(mapper.toEstabelecimento(null));
    }

    @Test
    void testToNaturezaRendimento() {
        // Create IdeNat
        Reinf.EvtBenefNId.IdeEstab.IdeNat ideNat = objectFactory.createReinfEvtBenefNIdIdeEstabIdeNat();
        ideNat.setNatRend("1234");

        // Create InfoPgto
        Reinf.EvtBenefNId.IdeEstab.IdeNat.InfoPgto infoPgto = objectFactory.createReinfEvtBenefNIdIdeEstabIdeNatInfoPgto();
        ideNat.getInfoPgto().add(infoPgto);

        // Map to entity
        NaturezaRendimento naturezaRendimento = mapper.toNaturezaRendimento(ideNat);

        // Verify the mapping
        assertNotNull(naturezaRendimento);
        assertEquals("1234", naturezaRendimento.getNatRend());
        assertNotNull(naturezaRendimento.getPagamentos());
        assertEquals(1, naturezaRendimento.getPagamentos().size());

        // Test with null
        assertNull(mapper.toNaturezaRendimento(null));
    }

    @Test
    void testToPagamento() {
        try {
            // Create InfoPgto
            Reinf.EvtBenefNId.IdeEstab.IdeNat.InfoPgto infoPgto = objectFactory.createReinfEvtBenefNIdIdeEstabIdeNatInfoPgto();

            // Set dtFG
            GregorianCalendar cal = new GregorianCalendar(2023, 0, 15); // January is 0
            XMLGregorianCalendar xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
            infoPgto.setDtFG(xmlCal);

            infoPgto.setVlrLiq("5000.00");
            infoPgto.setVlrBaseIR("4500.00");
            infoPgto.setVlrIR("900.00");

            // Set dtEscrCont
            cal = new GregorianCalendar(2023, 0, 20); // January is 0
            xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
            infoPgto.setDtEscrCont(xmlCal);

            infoPgto.setDescr("Pagamento não identificado");

            // Create InfoProcRet
            Reinf.EvtBenefNId.IdeEstab.IdeNat.InfoPgto.InfoProcRet infoProcRet = objectFactory.createReinfEvtBenefNIdIdeEstabIdeNatInfoPgtoInfoProcRet();
            infoPgto.getInfoProcRet().add(infoProcRet);

            // Map to entity
            Pagamento pagamento = mapper.toPagamento(infoPgto);

            // Verify the mapping
            assertNotNull(pagamento);
            assertEquals(LocalDate.of(2023, 1, 15), pagamento.getDtFG());
            assertEquals(new BigDecimal("5000.00"), pagamento.getVlrLiq());
            assertEquals(new BigDecimal("4500.00"), pagamento.getVlrBaseIR());
            assertEquals(new BigDecimal("900.00"), pagamento.getVlrIR());
            assertEquals(LocalDate.of(2023, 1, 20), pagamento.getDtEscrCont());
            assertEquals("Pagamento não identificado", pagamento.getDescr());
            assertNotNull(pagamento.getProcessosRetencao());
            assertEquals(1, pagamento.getProcessosRetencao().size());

            // Test with null
            assertNull(mapper.toPagamento(null));
        } catch (Exception e) {
            fail("Failed to create XMLGregorianCalendar: " + e.getMessage());
        }
    }

    @Test
    void testToProcessoRetencao() {
        // Create InfoProcRet
        Reinf.EvtBenefNId.IdeEstab.IdeNat.InfoPgto.InfoProcRet infoProcRet = objectFactory.createReinfEvtBenefNIdIdeEstabIdeNatInfoPgtoInfoProcRet();
        infoProcRet.setTpProcRet((short) 1);
        infoProcRet.setNrProcRet("12345678901234567890");
        infoProcRet.setCodSusp("12345");
        infoProcRet.setVlrBaseSuspIR("1000.00");
        infoProcRet.setVlrNIR("200.00");
        infoProcRet.setVlrDepIR("50.00");

        // Map to entity
        ProcessoRetencao processoRetencao = mapper.toProcessoRetencao(infoProcRet);

        // Verify the mapping
        assertNotNull(processoRetencao);
        assertEquals(1, processoRetencao.getTpProcRet());
        assertEquals("12345678901234567890", processoRetencao.getNrProcRet());
        assertEquals("12345", processoRetencao.getCodSusp());
        assertEquals(new BigDecimal("1000.00"), processoRetencao.getVlrBaseSuspIR());
        assertEquals(new BigDecimal("200.00"), processoRetencao.getVlrNIR());
        assertEquals(new BigDecimal("50.00"), processoRetencao.getVlrDepIR());

        // Test with null
        assertNull(mapper.toProcessoRetencao(null));
    }

    @Test
    void testListMappings() {
        // Create list of IdeNat
        List<Reinf.EvtBenefNId.IdeEstab.IdeNat> ideNatList = new ArrayList<>();
        Reinf.EvtBenefNId.IdeEstab.IdeNat ideNat1 = objectFactory.createReinfEvtBenefNIdIdeEstabIdeNat();
        ideNat1.setNatRend("1234");
        ideNatList.add(ideNat1);

        Reinf.EvtBenefNId.IdeEstab.IdeNat ideNat2 = objectFactory.createReinfEvtBenefNIdIdeEstabIdeNat();
        ideNat2.setNatRend("5678");
        ideNatList.add(ideNat2);

        // Map to entity list
        List<NaturezaRendimento> naturezaRendimentoList = mapper.toNaturezaRendimentoList(ideNatList);

        // Verify the mapping
        assertNotNull(naturezaRendimentoList);
        assertEquals(2, naturezaRendimentoList.size());
        assertEquals("1234", naturezaRendimentoList.get(0).getNatRend());
        assertEquals("5678", naturezaRendimentoList.get(1).getNatRend());

        // Test with empty list
        List<NaturezaRendimento> emptyList = mapper.toNaturezaRendimentoList(new ArrayList<>());
        assertNotNull(emptyList);
        assertTrue(emptyList.isEmpty());

        // Test with null
        assertNull(mapper.toNaturezaRendimentoList(null));
    }

    private Reinf createReinfXml() {
        try {
            Reinf reinf = objectFactory.createReinf();
            Reinf.EvtBenefNId evtBenefNId = objectFactory.createReinfEvtBenefNId();
            reinf.setEvtBenefNId(evtBenefNId);
            evtBenefNId.setId("ID1234567890");

            // Create ideEvento
            Reinf.EvtBenefNId.IdeEvento ideEvento = objectFactory.createReinfEvtBenefNIdIdeEvento();
            evtBenefNId.setIdeEvento(ideEvento);
            ideEvento.setIndRetif((short) 1);
            ideEvento.setNrRecibo("1.2.3456789");

            // Create XMLGregorianCalendar for perApur
            GregorianCalendar cal = new GregorianCalendar(2023, 0, 1); // January is 0
            XMLGregorianCalendar xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
            ideEvento.setPerApur(xmlCal);

            ideEvento.setTpAmb((short) 1);
            ideEvento.setProcEmi((short) 1);
            ideEvento.setVerProc("1.0");

            // Create ideContri
            Reinf.EvtBenefNId.IdeContri ideContri = objectFactory.createReinfEvtBenefNIdIdeContri();
            evtBenefNId.setIdeContri(ideContri);
            ideContri.setTpInsc((short) 1);
            ideContri.setNrInsc("12345678901234");

            // Create ideEstab
            Reinf.EvtBenefNId.IdeEstab ideEstab = objectFactory.createReinfEvtBenefNIdIdeEstab();
            evtBenefNId.setIdeEstab(ideEstab);
            ideEstab.setTpInscEstab((short) 1);
            ideEstab.setNrInscEstab("12345678901234");
            ideEstab.setIdeEvtAdic("ID-ADICIONAL");

            // Create ideNat
            Reinf.EvtBenefNId.IdeEstab.IdeNat ideNat = objectFactory.createReinfEvtBenefNIdIdeEstabIdeNat();
            ideEstab.getIdeNat().add(ideNat);
            ideNat.setNatRend("1234");

            // Create infoPgto
            Reinf.EvtBenefNId.IdeEstab.IdeNat.InfoPgto infoPgto = objectFactory.createReinfEvtBenefNIdIdeEstabIdeNatInfoPgto();
            ideNat.getInfoPgto().add(infoPgto);

            // Create XMLGregorianCalendar for dtFG
            cal = new GregorianCalendar(2023, 0, 15); // January is 0
            xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
            infoPgto.setDtFG(xmlCal);

            infoPgto.setVlrLiq("5000.00");
            infoPgto.setVlrBaseIR("4500.00");
            infoPgto.setVlrIR("900.00");

            // Create XMLGregorianCalendar for dtEscrCont
            cal = new GregorianCalendar(2023, 0, 20); // January is 0
            xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
            infoPgto.setDtEscrCont(xmlCal);

            infoPgto.setDescr("Pagamento não identificado");

            // Create infoProcRet
            Reinf.EvtBenefNId.IdeEstab.IdeNat.InfoPgto.InfoProcRet infoProcRet = objectFactory.createReinfEvtBenefNIdIdeEstabIdeNatInfoPgtoInfoProcRet();
            infoPgto.getInfoProcRet().add(infoProcRet);
            infoProcRet.setTpProcRet((short) 1);
            infoProcRet.setNrProcRet("12345678901234567890");
            infoProcRet.setCodSusp("12345");
            infoProcRet.setVlrBaseSuspIR("1000.00");
            infoProcRet.setVlrNIR("200.00");
            infoProcRet.setVlrDepIR("50.00");

            return reinf;
        } catch (Exception e) {
            fail("Failed to create Reinf XML: " + e.getMessage());
            return null;
        }
    }
}
