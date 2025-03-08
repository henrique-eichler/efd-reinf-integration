package br.gov.receita.reinf.r4010.mapper;

import br.gov.receita.reinf.r4010.entity.*;
import br.gov.receita.reinf.r4010.schema.*;
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

class R4010MapperTest {

    private R4010Mapper mapper;
    private ObjectFactory objectFactory;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(R4010Mapper.class);
        objectFactory = new ObjectFactory();
    }

    @Test
    void testToEntity() {
        // Create a Reinf XML object with all necessary data
        Reinf reinf = createReinfXml();

        // Map to entity
        EventoRetencaoPessoaFisica entity = mapper.toEntity(reinf);

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
        assertEquals("12345678901", entity.getEstabelecimento().getBeneficiario().getCpfBenef());
        assertEquals("John Doe", entity.getEstabelecimento().getBeneficiario().getNmBenef());

        // Verify dependentes
        assertNotNull(entity.getEstabelecimento().getBeneficiario().getDependentes());
        assertEquals(1, entity.getEstabelecimento().getBeneficiario().getDependentes().size());
        Dependente dependente = entity.getEstabelecimento().getBeneficiario().getDependentes().get(0);
        assertEquals("98765432109", dependente.getCpfDep());
        assertEquals(3, dependente.getRelDep());
        assertEquals("Filho", dependente.getDescrDep());

        // Verify pagamentos
        assertNotNull(entity.getEstabelecimento().getBeneficiario().getPagamentos());
        assertEquals(1, entity.getEstabelecimento().getBeneficiario().getPagamentos().size());
        Pagamento pagamento = entity.getEstabelecimento().getBeneficiario().getPagamentos().get(0);
        assertEquals(1000, pagamento.getNatRend());
        assertEquals("Observação de teste", pagamento.getObserv());
        assertEquals(LocalDate.of(2023, 1, 15), pagamento.getDtFG());
        assertEquals("202301", pagamento.getCompFP());
        assertEquals("S", pagamento.getIndDecTerc());
        assertEquals(new BigDecimal("5000.00"), pagamento.getVlrRendBruto());
        assertEquals(new BigDecimal("4500.00"), pagamento.getVlrRendTrib());
        assertEquals(new BigDecimal("900.00"), pagamento.getVlrIR());
        assertEquals("N", pagamento.getIndRRA());
        assertEquals(0, pagamento.getIndFciScp());
        assertEquals("12345678901234", pagamento.getNrInscFciScp());
        assertEquals(new BigDecimal("10.00"), pagamento.getPercSCP());
        assertEquals("N", pagamento.getIndJud());
        assertEquals("BR", pagamento.getPaisResidExt());

        // Verify deducoes
        assertNotNull(pagamento.getDeducoes());
        assertEquals(1, pagamento.getDeducoes().size());
        Deducao deducao = pagamento.getDeducoes().get(0);
        assertEquals(1, deducao.getIndTpDeducao());
        assertEquals(new BigDecimal("100.50"), deducao.getVlrDeducao());
        assertEquals("12345678901234", deducao.getNrInscPrevComp());
        assertEquals(new BigDecimal("50.25"), deducao.getVlrPatrocFunp());

        // Verify beneficiariosPensao
        assertNotNull(deducao.getBeneficiariosPensao());
        assertEquals(1, deducao.getBeneficiariosPensao().size());
        BeneficiarioPensao beneficiarioPensao = deducao.getBeneficiariosPensao().get(0);
        assertEquals("98765432109", beneficiarioPensao.getCpfDep());
        assertEquals(new BigDecimal("75.25"), beneficiarioPensao.getVlrDepen());
    }

    private Reinf createReinfXml() {
        try {
            DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
            Reinf reinf = objectFactory.createReinf();

            // Create EvtRetPF
            Reinf.EvtRetPF evtRetPF = objectFactory.createReinfEvtRetPF();
            evtRetPF.setId("ID1234567890");
            reinf.setEvtRetPF(evtRetPF);

            // Create IdeEvento
            Reinf.EvtRetPF.IdeEvento ideEvento = objectFactory.createReinfEvtRetPFIdeEvento();
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
            evtRetPF.setIdeEvento(ideEvento);

            // Create IdeContri
            Reinf.EvtRetPF.IdeContri ideContri = objectFactory.createReinfEvtRetPFIdeContri();
            ideContri.setTpInsc((short) 1);
            ideContri.setNrInsc("12345678901234");
            evtRetPF.setIdeContri(ideContri);

            // Create IdeEstab
            Reinf.EvtRetPF.IdeEstab ideEstab = objectFactory.createReinfEvtRetPFIdeEstab();
            ideEstab.setTpInscEstab((short) 1);
            ideEstab.setNrInscEstab("12345678901234");
            evtRetPF.setIdeEstab(ideEstab);

            // Create IdeBenef
            Reinf.EvtRetPF.IdeEstab.IdeBenef ideBenef = objectFactory.createReinfEvtRetPFIdeEstabIdeBenef();
            ideBenef.setCpfBenef("12345678901");
            ideBenef.setNmBenef("John Doe");
            ideEstab.setIdeBenef(ideBenef);

            // Create IdeDep
            Reinf.EvtRetPF.IdeEstab.IdeBenef.IdeDep ideDep = objectFactory.createReinfEvtRetPFIdeEstabIdeBenefIdeDep();
            ideDep.setCpfDep("98765432109");
            ideDep.setRelDep((short) 3);
            ideDep.setDescrDep("Filho");
            ideBenef.getIdeDep().add(ideDep);

            // Create IdePgto
            Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto idePgto = objectFactory.createReinfEvtRetPFIdeEstabIdeBenefIdePgto();
            idePgto.setNatRend("1000");
            idePgto.setObserv("Observação de teste");
            ideBenef.getIdePgto().add(idePgto);

            // Create InfoPgto
            Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto.InfoPgto infoPgto = objectFactory.createReinfEvtRetPFIdeEstabIdeBenefIdePgtoInfoPgto();

            // Create XMLGregorianCalendar for dtFG
            GregorianCalendar dtFGCal = new GregorianCalendar(2023, 0, 15); // Month is 0-based
            XMLGregorianCalendar dtFGXml = datatypeFactory.newXMLGregorianCalendar(dtFGCal);
            infoPgto.setDtFG(dtFGXml);

            infoPgto.setCompFP("202301");
            infoPgto.setIndDecTerc("S");
            infoPgto.setVlrRendBruto("5000.00");
            infoPgto.setVlrRendTrib("4500.00");
            infoPgto.setVlrIR("900.00");
            infoPgto.setIndRRA("N");
            infoPgto.setIndFciScp((short) 0);
            infoPgto.setNrInscFciScp("12345678901234");
            infoPgto.setPercSCP("10.00");
            infoPgto.setIndJud("N");
            infoPgto.setPaisResidExt("BR");
            idePgto.getInfoPgto().add(infoPgto);

            // Create DetDed
            Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto.InfoPgto.DetDed detDed = objectFactory.createReinfEvtRetPFIdeEstabIdeBenefIdePgtoInfoPgtoDetDed();
            detDed.setIndTpDeducao((short) 1);
            detDed.setVlrDeducao("100.50");
            detDed.setNrInscPrevComp("12345678901234");
            detDed.setVlrPatrocFunp("50.25");
            infoPgto.getDetDed().add(detDed);

            // Create BenefPen
            Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto.InfoPgto.DetDed.BenefPen benefPen = objectFactory.createReinfEvtRetPFIdeEstabIdeBenefIdePgtoInfoPgtoDetDedBenefPen();
            benefPen.setCpfDep("98765432109");
            benefPen.setVlrDepen("75.25");
            detDed.getBenefPen().add(benefPen);

            return reinf;
        } catch (Exception e) {
            throw new RuntimeException("Error creating Reinf XML", e);
        }
    }
}