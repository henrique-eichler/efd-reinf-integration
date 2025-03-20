package br.gov.receita.reinf.r4040.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NaturezaRendimentoTest {

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
        
        // Create a natureza rendimento using the builder
        NaturezaRendimento naturezaRendimento = NaturezaRendimento.builder()
                .id(20L)
                .natRend("1234")
                .pagamentos(pagamentos)
                .build();
        
        // Verify getters
        assertEquals(20L, naturezaRendimento.getId());
        assertEquals("1234", naturezaRendimento.getNatRend());
        
        assertNotNull(naturezaRendimento.getPagamentos());
        assertEquals(1, naturezaRendimento.getPagamentos().size());
        assertEquals(40L, naturezaRendimento.getPagamentos().get(0).getId());
        assertEquals(LocalDate.of(2023, 1, 15), naturezaRendimento.getPagamentos().get(0).getDtFG());
        assertEquals(new BigDecimal("5000.00"), naturezaRendimento.getPagamentos().get(0).getVlrLiq());
        assertEquals(new BigDecimal("4500.00"), naturezaRendimento.getPagamentos().get(0).getVlrBaseIR());
        assertEquals(new BigDecimal("900.00"), naturezaRendimento.getPagamentos().get(0).getVlrIR());
        assertEquals(LocalDate.of(2023, 1, 20), naturezaRendimento.getPagamentos().get(0).getDtEscrCont());
        assertEquals("Pagamento não identificado", naturezaRendimento.getPagamentos().get(0).getDescr());
        
        assertNotNull(naturezaRendimento.getPagamentos().get(0).getProcessosRetencao());
        assertEquals(1, naturezaRendimento.getPagamentos().get(0).getProcessosRetencao().size());
        assertEquals(30L, naturezaRendimento.getPagamentos().get(0).getProcessosRetencao().get(0).getId());
        assertEquals(1, naturezaRendimento.getPagamentos().get(0).getProcessosRetencao().get(0).getTpProcRet());
        assertEquals("12345678901234567890", naturezaRendimento.getPagamentos().get(0).getProcessosRetencao().get(0).getNrProcRet());
        assertEquals("12345", naturezaRendimento.getPagamentos().get(0).getProcessosRetencao().get(0).getCodSusp());
        assertEquals(new BigDecimal("1000.00"), naturezaRendimento.getPagamentos().get(0).getProcessosRetencao().get(0).getVlrBaseSuspIR());
        assertEquals(new BigDecimal("200.00"), naturezaRendimento.getPagamentos().get(0).getProcessosRetencao().get(0).getVlrNIR());
        assertEquals(new BigDecimal("50.00"), naturezaRendimento.getPagamentos().get(0).getProcessosRetencao().get(0).getVlrDepIR());
        
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
        
        naturezaRendimento.setId(60L);
        naturezaRendimento.setNatRend("4321");
        naturezaRendimento.setPagamentos(newPagamentos);
        
        // Verify updated values
        assertEquals(60L, naturezaRendimento.getId());
        assertEquals("4321", naturezaRendimento.getNatRend());
        
        assertNotNull(naturezaRendimento.getPagamentos());
        assertEquals(1, naturezaRendimento.getPagamentos().size());
        assertEquals(80L, naturezaRendimento.getPagamentos().get(0).getId());
        assertEquals(LocalDate.of(2023, 2, 15), naturezaRendimento.getPagamentos().get(0).getDtFG());
        assertEquals(new BigDecimal("10000.00"), naturezaRendimento.getPagamentos().get(0).getVlrLiq());
        assertEquals(new BigDecimal("9000.00"), naturezaRendimento.getPagamentos().get(0).getVlrBaseIR());
        assertEquals(new BigDecimal("1800.00"), naturezaRendimento.getPagamentos().get(0).getVlrIR());
        assertEquals(LocalDate.of(2023, 2, 20), naturezaRendimento.getPagamentos().get(0).getDtEscrCont());
        assertEquals("Novo pagamento não identificado", naturezaRendimento.getPagamentos().get(0).getDescr());
    }
    
    @Test
    void testEqualsAndHashCode() {
        // Create two naturezas rendimento with the same ID
        NaturezaRendimento naturezaRendimento1 = NaturezaRendimento.builder().id(1L).build();
        NaturezaRendimento naturezaRendimento2 = NaturezaRendimento.builder().id(1L).build();
        
        // Create a natureza rendimento with a different ID
        NaturezaRendimento naturezaRendimento3 = NaturezaRendimento.builder().id(2L).build();
        
        // Test equals
        assertEquals(naturezaRendimento1, naturezaRendimento2);
        assertNotEquals(naturezaRendimento1, naturezaRendimento3);
        
        // Test hashCode
        assertEquals(naturezaRendimento1.hashCode(), naturezaRendimento2.hashCode());
        assertNotEquals(naturezaRendimento1.hashCode(), naturezaRendimento3.hashCode());
        
        // Test equals with null and different class
        assertNotEquals(naturezaRendimento1, null);
        assertNotEquals(naturezaRendimento1, "not a natureza rendimento");
    }
}