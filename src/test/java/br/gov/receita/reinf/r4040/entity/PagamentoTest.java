package br.gov.receita.reinf.r4040.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoTest {

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
        
        // Create a pagamento using the builder
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
        
        // Verify getters
        assertEquals(40L, pagamento.getId());
        assertEquals(LocalDate.of(2023, 1, 15), pagamento.getDtFG());
        assertEquals(new BigDecimal("5000.00"), pagamento.getVlrLiq());
        assertEquals(new BigDecimal("4500.00"), pagamento.getVlrBaseIR());
        assertEquals(new BigDecimal("900.00"), pagamento.getVlrIR());
        assertEquals(LocalDate.of(2023, 1, 20), pagamento.getDtEscrCont());
        assertEquals("Pagamento não identificado", pagamento.getDescr());
        
        assertNotNull(pagamento.getProcessosRetencao());
        assertEquals(1, pagamento.getProcessosRetencao().size());
        assertEquals(30L, pagamento.getProcessosRetencao().get(0).getId());
        assertEquals(1, pagamento.getProcessosRetencao().get(0).getTpProcRet());
        assertEquals("12345678901234567890", pagamento.getProcessosRetencao().get(0).getNrProcRet());
        assertEquals("12345", pagamento.getProcessosRetencao().get(0).getCodSusp());
        assertEquals(new BigDecimal("1000.00"), pagamento.getProcessosRetencao().get(0).getVlrBaseSuspIR());
        assertEquals(new BigDecimal("200.00"), pagamento.getProcessosRetencao().get(0).getVlrNIR());
        assertEquals(new BigDecimal("50.00"), pagamento.getProcessosRetencao().get(0).getVlrDepIR());
        
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
        
        pagamento.setId(80L);
        pagamento.setDtFG(LocalDate.of(2023, 2, 15));
        pagamento.setVlrLiq(new BigDecimal("10000.00"));
        pagamento.setVlrBaseIR(new BigDecimal("9000.00"));
        pagamento.setVlrIR(new BigDecimal("1800.00"));
        pagamento.setDtEscrCont(LocalDate.of(2023, 2, 20));
        pagamento.setDescr("Novo pagamento não identificado");
        pagamento.setProcessosRetencao(newProcessosRetencao);
        
        // Verify updated values
        assertEquals(80L, pagamento.getId());
        assertEquals(LocalDate.of(2023, 2, 15), pagamento.getDtFG());
        assertEquals(new BigDecimal("10000.00"), pagamento.getVlrLiq());
        assertEquals(new BigDecimal("9000.00"), pagamento.getVlrBaseIR());
        assertEquals(new BigDecimal("1800.00"), pagamento.getVlrIR());
        assertEquals(LocalDate.of(2023, 2, 20), pagamento.getDtEscrCont());
        assertEquals("Novo pagamento não identificado", pagamento.getDescr());
        
        assertNotNull(pagamento.getProcessosRetencao());
        assertEquals(1, pagamento.getProcessosRetencao().size());
        assertEquals(70L, pagamento.getProcessosRetencao().get(0).getId());
        assertEquals(2, pagamento.getProcessosRetencao().get(0).getTpProcRet());
        assertEquals("09876543210987654321", pagamento.getProcessosRetencao().get(0).getNrProcRet());
        assertEquals("54321", pagamento.getProcessosRetencao().get(0).getCodSusp());
        assertEquals(new BigDecimal("2000.00"), pagamento.getProcessosRetencao().get(0).getVlrBaseSuspIR());
        assertEquals(new BigDecimal("400.00"), pagamento.getProcessosRetencao().get(0).getVlrNIR());
        assertEquals(new BigDecimal("100.00"), pagamento.getProcessosRetencao().get(0).getVlrDepIR());
    }
    
    @Test
    void testEqualsAndHashCode() {
        // Create two pagamentos with the same ID
        Pagamento pagamento1 = Pagamento.builder().id(1L).build();
        Pagamento pagamento2 = Pagamento.builder().id(1L).build();
        
        // Create a pagamento with a different ID
        Pagamento pagamento3 = Pagamento.builder().id(2L).build();
        
        // Test equals
        assertEquals(pagamento1, pagamento2);
        assertNotEquals(pagamento1, pagamento3);
        
        // Test hashCode
        assertEquals(pagamento1.hashCode(), pagamento2.hashCode());
        assertNotEquals(pagamento1.hashCode(), pagamento3.hashCode());
        
        // Test equals with null and different class
        assertNotEquals(pagamento1, null);
        assertNotEquals(pagamento1, "not a pagamento");
    }
}