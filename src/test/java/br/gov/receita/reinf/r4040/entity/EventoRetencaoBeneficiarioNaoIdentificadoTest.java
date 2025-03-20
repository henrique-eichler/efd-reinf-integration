package br.gov.receita.reinf.r4040.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventoRetencaoBeneficiarioNaoIdentificadoTest {

    @Test
    void testBuilderAndGettersSetters() {
        // Create a contribuinte for the evento
        Contribuinte contribuinte = Contribuinte.builder()
                .tpInsc(1) // 1 - CNPJ
                .nrInsc("12345678901234")
                .build();
        
        // Create a processo retencao for the pagamento
        ProcessoRetencao processoRetencao = ProcessoRetencao.builder()
                .id(30L)
                .tpProcRet(1)
                .nrProcRet("12345678901234567890")
                .codSusp("12345")
                .vlrBaseSuspIR(new BigDecimal("1000.00"))
                .vlrNIR(new BigDecimal("200.00"))
                .vlrDepIR(new BigDecimal("50.00"))
                .build();
        
        List<ProcessoRetencao> processosRetencao = new ArrayList<>();
        processosRetencao.add(processoRetencao);
        
        // Create a pagamento for the natureza rendimento
        Pagamento pagamento = Pagamento.builder()
                .id(40L)
                .dtFG(LocalDate.of(2023, 1, 15))
                .vlrLiq(new BigDecimal("5000.00"))
                .vlrBaseIR(new BigDecimal("4500.00"))
                .vlrIR(new BigDecimal("900.00"))
                .dtEscrCont(LocalDate.of(2023, 1, 20))
                .descr("Pagamento não identificado")
                .processosRetencao(processosRetencao)
                .build();
        
        List<Pagamento> pagamentos = new ArrayList<>();
        pagamentos.add(pagamento);
        
        // Create a natureza rendimento for the estabelecimento
        NaturezaRendimento naturezaRendimento = NaturezaRendimento.builder()
                .id(20L)
                .natRend("1234")
                .pagamentos(pagamentos)
                .build();
        
        List<NaturezaRendimento> naturezasRendimento = new ArrayList<>();
        naturezasRendimento.add(naturezaRendimento);
        
        // Create an estabelecimento for the evento
        Estabelecimento estabelecimento = Estabelecimento.builder()
                .id(10L)
                .tpInscEstab(1) // 1 - CNPJ
                .nrInscEstab("12345678901234")
                .ideEvtAdic("ID-ADICIONAL")
                .naturezasRendimento(naturezasRendimento)
                .build();
        
        // Create an evento using the builder
        YearMonth perApur = YearMonth.of(2023, 1);
        EventoRetencaoBeneficiarioNaoIdentificado evento = EventoRetencaoBeneficiarioNaoIdentificado.builder()
                .id(1L)
                .idEvento("ID1234567890")
                .indRetif(1)
                .nrRecibo("1.2.3456789")
                .perApur(perApur)
                .tpAmb(1)
                .procEmi(1)
                .verProc("1.0")
                .contribuinte(contribuinte)
                .estabelecimento(estabelecimento)
                .build();

        // Verify getters
        assertEquals(1L, evento.getId());
        assertEquals("ID1234567890", evento.getIdEvento());
        assertEquals(1, evento.getIndRetif());
        assertEquals("1.2.3456789", evento.getNrRecibo());
        assertEquals(perApur, evento.getPerApur());
        assertEquals(1, evento.getTpAmb());
        assertEquals(1, evento.getProcEmi());
        assertEquals("1.0", evento.getVerProc());
        
        assertNotNull(evento.getContribuinte());
        assertEquals(1, evento.getContribuinte().getTpInsc());
        assertEquals("12345678901234", evento.getContribuinte().getNrInsc());
        
        assertNotNull(evento.getEstabelecimento());
        assertEquals(10L, evento.getEstabelecimento().getId());
        assertEquals(1, evento.getEstabelecimento().getTpInscEstab());
        assertEquals("12345678901234", evento.getEstabelecimento().getNrInscEstab());
        assertEquals("ID-ADICIONAL", evento.getEstabelecimento().getIdeEvtAdic());
        
        assertNotNull(evento.getEstabelecimento().getNaturezasRendimento());
        assertEquals(1, evento.getEstabelecimento().getNaturezasRendimento().size());
        assertEquals(20L, evento.getEstabelecimento().getNaturezasRendimento().get(0).getId());
        assertEquals("1234", evento.getEstabelecimento().getNaturezasRendimento().get(0).getNatRend());
        
        assertNotNull(evento.getEstabelecimento().getNaturezasRendimento().get(0).getPagamentos());
        assertEquals(1, evento.getEstabelecimento().getNaturezasRendimento().get(0).getPagamentos().size());
        assertEquals(40L, evento.getEstabelecimento().getNaturezasRendimento().get(0).getPagamentos().get(0).getId());
        assertEquals(LocalDate.of(2023, 1, 15), evento.getEstabelecimento().getNaturezasRendimento().get(0).getPagamentos().get(0).getDtFG());
        assertEquals(new BigDecimal("5000.00"), evento.getEstabelecimento().getNaturezasRendimento().get(0).getPagamentos().get(0).getVlrLiq());
        assertEquals(new BigDecimal("4500.00"), evento.getEstabelecimento().getNaturezasRendimento().get(0).getPagamentos().get(0).getVlrBaseIR());
        assertEquals(new BigDecimal("900.00"), evento.getEstabelecimento().getNaturezasRendimento().get(0).getPagamentos().get(0).getVlrIR());
        assertEquals(LocalDate.of(2023, 1, 20), evento.getEstabelecimento().getNaturezasRendimento().get(0).getPagamentos().get(0).getDtEscrCont());
        assertEquals("Pagamento não identificado", evento.getEstabelecimento().getNaturezasRendimento().get(0).getPagamentos().get(0).getDescr());
        
        assertNotNull(evento.getEstabelecimento().getNaturezasRendimento().get(0).getPagamentos().get(0).getProcessosRetencao());
        assertEquals(1, evento.getEstabelecimento().getNaturezasRendimento().get(0).getPagamentos().get(0).getProcessosRetencao().size());
        assertEquals(30L, evento.getEstabelecimento().getNaturezasRendimento().get(0).getPagamentos().get(0).getProcessosRetencao().get(0).getId());
        assertEquals(1, evento.getEstabelecimento().getNaturezasRendimento().get(0).getPagamentos().get(0).getProcessosRetencao().get(0).getTpProcRet());
        assertEquals("12345678901234567890", evento.getEstabelecimento().getNaturezasRendimento().get(0).getPagamentos().get(0).getProcessosRetencao().get(0).getNrProcRet());
        assertEquals("12345", evento.getEstabelecimento().getNaturezasRendimento().get(0).getPagamentos().get(0).getProcessosRetencao().get(0).getCodSusp());
        assertEquals(new BigDecimal("1000.00"), evento.getEstabelecimento().getNaturezasRendimento().get(0).getPagamentos().get(0).getProcessosRetencao().get(0).getVlrBaseSuspIR());
        assertEquals(new BigDecimal("200.00"), evento.getEstabelecimento().getNaturezasRendimento().get(0).getPagamentos().get(0).getProcessosRetencao().get(0).getVlrNIR());
        assertEquals(new BigDecimal("50.00"), evento.getEstabelecimento().getNaturezasRendimento().get(0).getPagamentos().get(0).getProcessosRetencao().get(0).getVlrDepIR());

        // Test setters with new values
        Contribuinte newContribuinte = Contribuinte.builder()
                .tpInsc(2) // 2 - CPF
                .nrInsc("98765432109")
                .build();
        
        ProcessoRetencao newProcessoRetencao = ProcessoRetencao.builder()
                .id(70L)
                .tpProcRet(2)
                .nrProcRet("09876543210987654321")
                .codSusp("54321")
                .vlrBaseSuspIR(new BigDecimal("2000.00"))
                .vlrNIR(new BigDecimal("400.00"))
                .vlrDepIR(new BigDecimal("100.00"))
                .build();
        
        List<ProcessoRetencao> newProcessosRetencao = new ArrayList<>();
        newProcessosRetencao.add(newProcessoRetencao);
        
        Pagamento newPagamento = Pagamento.builder()
                .id(80L)
                .dtFG(LocalDate.of(2023, 2, 15))
                .vlrLiq(new BigDecimal("10000.00"))
                .vlrBaseIR(new BigDecimal("9000.00"))
                .vlrIR(new BigDecimal("1800.00"))
                .dtEscrCont(LocalDate.of(2023, 2, 20))
                .descr("Novo pagamento não identificado")
                .processosRetencao(newProcessosRetencao)
                .build();
        
        List<Pagamento> newPagamentos = new ArrayList<>();
        newPagamentos.add(newPagamento);
        
        NaturezaRendimento newNaturezaRendimento = NaturezaRendimento.builder()
                .id(60L)
                .natRend("4321")
                .pagamentos(newPagamentos)
                .build();
        
        List<NaturezaRendimento> newNaturezasRendimento = new ArrayList<>();
        newNaturezasRendimento.add(newNaturezaRendimento);
        
        Estabelecimento newEstabelecimento = Estabelecimento.builder()
                .id(50L)
                .tpInscEstab(2) // 2 - CPF
                .nrInscEstab("98765432109")
                .ideEvtAdic("NEW-ID-ADICIONAL")
                .naturezasRendimento(newNaturezasRendimento)
                .build();
        
        YearMonth newPerApur = YearMonth.of(2023, 2);
        evento.setId(2L);
        evento.setIdEvento("ID0987654321");
        evento.setIndRetif(2);
        evento.setNrRecibo("9.8.7654321");
        evento.setPerApur(newPerApur);
        evento.setTpAmb(2);
        evento.setProcEmi(2);
        evento.setVerProc("2.0");
        evento.setContribuinte(newContribuinte);
        evento.setEstabelecimento(newEstabelecimento);

        // Verify updated values
        assertEquals(2L, evento.getId());
        assertEquals("ID0987654321", evento.getIdEvento());
        assertEquals(2, evento.getIndRetif());
        assertEquals("9.8.7654321", evento.getNrRecibo());
        assertEquals(newPerApur, evento.getPerApur());
        assertEquals(2, evento.getTpAmb());
        assertEquals(2, evento.getProcEmi());
        assertEquals("2.0", evento.getVerProc());
        
        assertNotNull(evento.getContribuinte());
        assertEquals(2, evento.getContribuinte().getTpInsc());
        assertEquals("98765432109", evento.getContribuinte().getNrInsc());
        
        assertNotNull(evento.getEstabelecimento());
        assertEquals(50L, evento.getEstabelecimento().getId());
        assertEquals(2, evento.getEstabelecimento().getTpInscEstab());
        assertEquals("98765432109", evento.getEstabelecimento().getNrInscEstab());
        assertEquals("NEW-ID-ADICIONAL", evento.getEstabelecimento().getIdeEvtAdic());
    }

    @Test
    void testEqualsAndHashCode() {
        // Create two eventos with the same ID
        EventoRetencaoBeneficiarioNaoIdentificado evento1 = EventoRetencaoBeneficiarioNaoIdentificado.builder().id(1L).build();
        EventoRetencaoBeneficiarioNaoIdentificado evento2 = EventoRetencaoBeneficiarioNaoIdentificado.builder().id(1L).build();
        
        // Create an evento with a different ID
        EventoRetencaoBeneficiarioNaoIdentificado evento3 = EventoRetencaoBeneficiarioNaoIdentificado.builder().id(2L).build();

        // Test equals
        assertEquals(evento1, evento2);
        assertNotEquals(evento1, evento3);
        
        // Test hashCode
        assertEquals(evento1.hashCode(), evento2.hashCode());
        assertNotEquals(evento1.hashCode(), evento3.hashCode());
        
        // Test equals with null and different class
        assertNotEquals(evento1, null);
        assertNotEquals(evento1, "not an evento");
    }
}