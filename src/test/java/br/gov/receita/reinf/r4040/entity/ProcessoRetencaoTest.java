package br.gov.receita.reinf.r4040.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProcessoRetencaoTest {

    @Test
    void testBuilderAndGettersSetters() {
        // Create a processo retencao using the builder
        ProcessoRetencao processoRetencao = ProcessoRetencao.builder()
                .id(30L)
                .tpProcRet(1)
                .nrProcRet("12345678901234567890")
                .codSusp("12345")
                .vlrBaseSuspIR(new BigDecimal("1000.00"))
                .vlrNIR(new BigDecimal("200.00"))
                .vlrDepIR(new BigDecimal("50.00"))
                .build();
        
        // Verify getters
        assertEquals(30L, processoRetencao.getId());
        assertEquals(1, processoRetencao.getTpProcRet());
        assertEquals("12345678901234567890", processoRetencao.getNrProcRet());
        assertEquals("12345", processoRetencao.getCodSusp());
        assertEquals(new BigDecimal("1000.00"), processoRetencao.getVlrBaseSuspIR());
        assertEquals(new BigDecimal("200.00"), processoRetencao.getVlrNIR());
        assertEquals(new BigDecimal("50.00"), processoRetencao.getVlrDepIR());
        
        // Test setters
        processoRetencao.setId(70L);
        processoRetencao.setTpProcRet(2);
        processoRetencao.setNrProcRet("09876543210987654321");
        processoRetencao.setCodSusp("54321");
        processoRetencao.setVlrBaseSuspIR(new BigDecimal("2000.00"));
        processoRetencao.setVlrNIR(new BigDecimal("400.00"));
        processoRetencao.setVlrDepIR(new BigDecimal("100.00"));
        
        // Verify updated values
        assertEquals(70L, processoRetencao.getId());
        assertEquals(2, processoRetencao.getTpProcRet());
        assertEquals("09876543210987654321", processoRetencao.getNrProcRet());
        assertEquals("54321", processoRetencao.getCodSusp());
        assertEquals(new BigDecimal("2000.00"), processoRetencao.getVlrBaseSuspIR());
        assertEquals(new BigDecimal("400.00"), processoRetencao.getVlrNIR());
        assertEquals(new BigDecimal("100.00"), processoRetencao.getVlrDepIR());
    }
    
    @Test
    void testEqualsAndHashCode() {
        // Create two processos retencao with the same ID
        ProcessoRetencao processoRetencao1 = ProcessoRetencao.builder().id(1L).build();
        ProcessoRetencao processoRetencao2 = ProcessoRetencao.builder().id(1L).build();
        
        // Create a processo retencao with a different ID
        ProcessoRetencao processoRetencao3 = ProcessoRetencao.builder().id(2L).build();
        
        // Test equals
        assertEquals(processoRetencao1, processoRetencao2);
        assertNotEquals(processoRetencao1, processoRetencao3);
        
        // Test hashCode
        assertEquals(processoRetencao1.hashCode(), processoRetencao2.hashCode());
        assertNotEquals(processoRetencao1.hashCode(), processoRetencao3.hashCode());
        
        // Test equals with null and different class
        assertNotEquals(processoRetencao1, null);
        assertNotEquals(processoRetencao1, "not a processo retencao");
    }
}