package br.gov.receita.reinf.r4040.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EstabelecimentoTest {

    @Test
    void testBuilderAndGettersSetters() {
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
        
        // Create an estabelecimento using the builder
        Estabelecimento estabelecimento = Estabelecimento.builder()
                .id(10L)
                .tpInscEstab(1) // 1 - CNPJ
                .nrInscEstab("12345678901234")
                .ideEvtAdic("ID-ADICIONAL")
                .naturezasRendimento(naturezasRendimento)
                .build();
        
        // Verify getters
        assertEquals(10L, estabelecimento.getId());
        assertEquals(1, estabelecimento.getTpInscEstab());
        assertEquals("12345678901234", estabelecimento.getNrInscEstab());
        assertEquals("ID-ADICIONAL", estabelecimento.getIdeEvtAdic());
        
        assertNotNull(estabelecimento.getNaturezasRendimento());
        assertEquals(1, estabelecimento.getNaturezasRendimento().size());
        assertEquals(20L, estabelecimento.getNaturezasRendimento().get(0).getId());
        assertEquals("1234", estabelecimento.getNaturezasRendimento().get(0).getNatRend());
        
        assertNotNull(estabelecimento.getNaturezasRendimento().get(0).getPagamentos());
        assertEquals(1, estabelecimento.getNaturezasRendimento().get(0).getPagamentos().size());
        assertEquals(40L, estabelecimento.getNaturezasRendimento().get(0).getPagamentos().get(0).getId());
        assertEquals(LocalDate.of(2023, 1, 15), estabelecimento.getNaturezasRendimento().get(0).getPagamentos().get(0).getDtFG());
        assertEquals(new BigDecimal("5000.00"), estabelecimento.getNaturezasRendimento().get(0).getPagamentos().get(0).getVlrLiq());
        assertEquals(new BigDecimal("4500.00"), estabelecimento.getNaturezasRendimento().get(0).getPagamentos().get(0).getVlrBaseIR());
        assertEquals(new BigDecimal("900.00"), estabelecimento.getNaturezasRendimento().get(0).getPagamentos().get(0).getVlrIR());
        assertEquals(LocalDate.of(2023, 1, 20), estabelecimento.getNaturezasRendimento().get(0).getPagamentos().get(0).getDtEscrCont());
        assertEquals("Pagamento não identificado", estabelecimento.getNaturezasRendimento().get(0).getPagamentos().get(0).getDescr());
        
        assertNotNull(estabelecimento.getNaturezasRendimento().get(0).getPagamentos().get(0).getProcessosRetencao());
        assertEquals(1, estabelecimento.getNaturezasRendimento().get(0).getPagamentos().get(0).getProcessosRetencao().size());
        assertEquals(30L, estabelecimento.getNaturezasRendimento().get(0).getPagamentos().get(0).getProcessosRetencao().get(0).getId());
        assertEquals(1, estabelecimento.getNaturezasRendimento().get(0).getPagamentos().get(0).getProcessosRetencao().get(0).getTpProcRet());
        assertEquals("12345678901234567890", estabelecimento.getNaturezasRendimento().get(0).getPagamentos().get(0).getProcessosRetencao().get(0).getNrProcRet());
        assertEquals("12345", estabelecimento.getNaturezasRendimento().get(0).getPagamentos().get(0).getProcessosRetencao().get(0).getCodSusp());
        assertEquals(new BigDecimal("1000.00"), estabelecimento.getNaturezasRendimento().get(0).getPagamentos().get(0).getProcessosRetencao().get(0).getVlrBaseSuspIR());
        assertEquals(new BigDecimal("200.00"), estabelecimento.getNaturezasRendimento().get(0).getPagamentos().get(0).getProcessosRetencao().get(0).getVlrNIR());
        assertEquals(new BigDecimal("50.00"), estabelecimento.getNaturezasRendimento().get(0).getPagamentos().get(0).getProcessosRetencao().get(0).getVlrDepIR());
        
        // Test setters with new values
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
        
        estabelecimento.setId(50L);
        estabelecimento.setTpInscEstab(2); // 2 - CPF
        estabelecimento.setNrInscEstab("98765432109");
        estabelecimento.setIdeEvtAdic("NEW-ID-ADICIONAL");
        estabelecimento.setNaturezasRendimento(newNaturezasRendimento);
        
        // Verify updated values
        assertEquals(50L, estabelecimento.getId());
        assertEquals(2, estabelecimento.getTpInscEstab());
        assertEquals("98765432109", estabelecimento.getNrInscEstab());
        assertEquals("NEW-ID-ADICIONAL", estabelecimento.getIdeEvtAdic());
        
        assertNotNull(estabelecimento.getNaturezasRendimento());
        assertEquals(1, estabelecimento.getNaturezasRendimento().size());
        assertEquals(60L, estabelecimento.getNaturezasRendimento().get(0).getId());
        assertEquals("4321", estabelecimento.getNaturezasRendimento().get(0).getNatRend());
    }
    
    @Test
    void testEqualsAndHashCode() {
        // Create two estabelecimentos with the same ID
        Estabelecimento estabelecimento1 = Estabelecimento.builder().id(1L).build();
        Estabelecimento estabelecimento2 = Estabelecimento.builder().id(1L).build();
        
        // Create an estabelecimento with a different ID
        Estabelecimento estabelecimento3 = Estabelecimento.builder().id(2L).build();
        
        // Test equals
        assertEquals(estabelecimento1, estabelecimento2);
        assertNotEquals(estabelecimento1, estabelecimento3);
        
        // Test hashCode
        assertEquals(estabelecimento1.hashCode(), estabelecimento2.hashCode());
        assertNotEquals(estabelecimento1.hashCode(), estabelecimento3.hashCode());
        
        // Test equals with null and different class
        assertNotEquals(estabelecimento1, null);
        assertNotEquals(estabelecimento1, "not an estabelecimento");
    }
}