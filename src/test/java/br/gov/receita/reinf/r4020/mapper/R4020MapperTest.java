package br.gov.receita.reinf.r4020.mapper;

import br.gov.receita.reinf.r4020.entity.*;
import br.gov.receita.reinf.r4020.schema.*;
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

class R4020MapperTest {

    private R4020Mapper mapper;
    private ObjectFactory objectFactory;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(R4020Mapper.class);
        objectFactory = new ObjectFactory();
    }

    @Test
    void testToEntity() {
        // Create a Reinf XML object with all necessary data
        Reinf reinf = createReinfXml();

        // Map to entity
        EventoRetencaoPessoaJuridica entity = mapper.toEntity(reinf);

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

        // Verify beneficiario
        assertNotNull(entity.getEstabelecimento().getBeneficiario());
        assertEquals("12345678901234", entity.getEstabelecimento().getBeneficiario().getCnpjBenef());
        assertEquals("Empresa XYZ", entity.getEstabelecimento().getBeneficiario().getNmBenef());
        assertEquals(1, entity.getEstabelecimento().getBeneficiario().getIsenImun());
        assertEquals("ID123456", entity.getEstabelecimento().getBeneficiario().getIdeEvtAdic());

        // Verify pagamentos
        assertNotNull(entity.getEstabelecimento().getBeneficiario().getPagamentos());
        assertEquals(1, entity.getEstabelecimento().getBeneficiario().getPagamentos().size());
        Pagamento pagamento = entity.getEstabelecimento().getBeneficiario().getPagamentos().get(0);
        assertEquals("1000", pagamento.getNatRend());
        assertEquals("Observação de teste", pagamento.getObserv());
        assertEquals(LocalDate.of(2023, 1, 15), pagamento.getDtFG());
        assertEquals(new BigDecimal("5000.00"), pagamento.getVlrBruto());
        assertEquals(0, pagamento.getIndFciScp());
        assertEquals("12345678901234", pagamento.getNrInscFciScp());
        assertEquals(new BigDecimal("10.00"), pagamento.getPercSCP());
        assertEquals("N", pagamento.getIndJud());
        assertEquals("BR", pagamento.getPaisResidExt());
        assertEquals(LocalDate.of(2023, 1, 20), pagamento.getDtEscrCont());
        assertEquals("Observação de pagamento", pagamento.getObservPgto());

        // Verify retencoes
        assertNotNull(pagamento.getRetencoes());
        Retencoes retencoes = pagamento.getRetencoes();
        assertEquals(new BigDecimal("1000.00"), retencoes.getVlrBaseIR());
        assertEquals(new BigDecimal("150.00"), retencoes.getVlrIR());
        assertEquals(new BigDecimal("200.00"), retencoes.getVlrBaseAgreg());
        assertEquals(new BigDecimal("30.00"), retencoes.getVlrAgreg());
        assertEquals(new BigDecimal("300.00"), retencoes.getVlrBaseCSLL());
        assertEquals(new BigDecimal("45.00"), retencoes.getVlrCSLL());
        assertEquals(new BigDecimal("400.00"), retencoes.getVlrBaseCofins());
        assertEquals(new BigDecimal("60.00"), retencoes.getVlrCofins());
        assertEquals(new BigDecimal("500.00"), retencoes.getVlrBasePP());
        assertEquals(new BigDecimal("75.00"), retencoes.getVlrPP());
    }

    private Reinf createReinfXml() {
        try {
            DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
            Reinf reinf = objectFactory.createReinf();

            // Create EvtRetPJ
            Reinf.EvtRetPJ evtRetPJ = objectFactory.createReinfEvtRetPJ();
            evtRetPJ.setId("ID1234567890");
            reinf.setEvtRetPJ(evtRetPJ);

            // Create IdeEvento
            Reinf.EvtRetPJ.IdeEvento ideEvento = objectFactory.createReinfEvtRetPJIdeEvento();
            ideEvento.setIndRetif((short) 1);
            ideEvento.setNrRecibo("1.2.3456789");

            // Create XMLGregorianCalendar for perApur
            XMLGregorianCalendar perApurXml = datatypeFactory.newXMLGregorianCalendar();
            perApurXml.setYear(2023);
            perApurXml.setMonth(1);
            ideEvento.setPerApur(perApurXml);

            ideEvento.setTpAmb((short) 1);
            ideEvento.setProcEmi((short) 1);
            ideEvento.setVerProc("1.0");
            evtRetPJ.setIdeEvento(ideEvento);

            // Create IdeContri
            Reinf.EvtRetPJ.IdeContri ideContri = objectFactory.createReinfEvtRetPJIdeContri();
            ideContri.setTpInsc((short) 1);
            ideContri.setNrInsc("12345678901234");
            evtRetPJ.setIdeContri(ideContri);

            // Create IdeEstab
            Reinf.EvtRetPJ.IdeEstab ideEstab = objectFactory.createReinfEvtRetPJIdeEstab();
            ideEstab.setTpInscEstab((short) 1);
            ideEstab.setNrInscEstab("12345678901234");
            evtRetPJ.setIdeEstab(ideEstab);

            // Create IdeBenef
            Reinf.EvtRetPJ.IdeEstab.IdeBenef ideBenef = objectFactory.createReinfEvtRetPJIdeEstabIdeBenef();
            ideBenef.setCnpjBenef("12345678901234");
            ideBenef.setNmBenef("Empresa XYZ");
            ideBenef.setIsenImun((short) 1);
            ideBenef.setIdeEvtAdic("ID123456");
            ideEstab.setIdeBenef(ideBenef);

            // Create IdePgto
            Reinf.EvtRetPJ.IdeEstab.IdeBenef.IdePgto idePgto = objectFactory.createReinfEvtRetPJIdeEstabIdeBenefIdePgto();
            idePgto.setNatRend("1000");
            idePgto.setObserv("Observação de teste");
            ideBenef.getIdePgto().add(idePgto);

            // Create InfoPgto
            Reinf.EvtRetPJ.IdeEstab.IdeBenef.IdePgto.InfoPgto infoPgto = objectFactory.createReinfEvtRetPJIdeEstabIdeBenefIdePgtoInfoPgto();

            // Create XMLGregorianCalendar for dtFG
            GregorianCalendar dtFGCal = new GregorianCalendar(2023, 0, 15); // Month is 0-based
            XMLGregorianCalendar dtFGXml = datatypeFactory.newXMLGregorianCalendar(dtFGCal);
            infoPgto.setDtFG(dtFGXml);

            infoPgto.setVlrBruto("5000.00");
            infoPgto.setIndFciScp((short) 0);
            infoPgto.setNrInscFciScp("12345678901234");
            infoPgto.setPercSCP("10.00");
            infoPgto.setIndJud("N");
            infoPgto.setPaisResidExt("BR");

            // Create XMLGregorianCalendar for dtEscrCont
            GregorianCalendar dtEscrContCal = new GregorianCalendar(2023, 0, 20); // Month is 0-based
            XMLGregorianCalendar dtEscrContXml = datatypeFactory.newXMLGregorianCalendar(dtEscrContCal);
            infoPgto.setDtEscrCont(dtEscrContXml);

            infoPgto.setObserv("Observação de pagamento");
            idePgto.getInfoPgto().add(infoPgto);

            // Create Retencoes
            Reinf.EvtRetPJ.IdeEstab.IdeBenef.IdePgto.InfoPgto.Retencoes retencoes = objectFactory.createReinfEvtRetPJIdeEstabIdeBenefIdePgtoInfoPgtoRetencoes();
            retencoes.setVlrBaseIR("1000.00");
            retencoes.setVlrIR("150.00");
            retencoes.setVlrBaseAgreg("200.00");
            retencoes.setVlrAgreg("30.00");
            retencoes.setVlrBaseCSLL("300.00");
            retencoes.setVlrCSLL("45.00");
            retencoes.setVlrBaseCofins("400.00");
            retencoes.setVlrCofins("60.00");
            retencoes.setVlrBasePP("500.00");
            retencoes.setVlrPP("75.00");
            infoPgto.setRetencoes(retencoes);

            return reinf;
        } catch (Exception e) {
            throw new RuntimeException("Error creating Reinf XML", e);
        }
    }
}
