package br.gov.receita.reinf.r4010.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeducaoTest {

    @Test
    void testBuilderAndGettersSetters() {
        // Create a deducao using the builder
        Deducao deducao = Deducao.builder()
                .id(1L)
                .indTpDeducao(1)
                .vlrDeducao(new BigDecimal("500.75"))
                .nrInscPrevComp("12345678901234")
                .vlrPatrocFunp(new BigDecimal("100.25"))
                .beneficiariosPensao(new ArrayList<>())
                .build();

        // Verify getters
        assertEquals(1L, deducao.getId());
        assertEquals(1, deducao.getIndTpDeducao());
        assertEquals(new BigDecimal("500.75"), deducao.getVlrDeducao());
        assertEquals("12345678901234", deducao.getNrInscPrevComp());
        assertEquals(new BigDecimal("100.25"), deducao.getVlrPatrocFunp());
        assertNotNull(deducao.getBeneficiariosPensao());
        assertTrue(deducao.getBeneficiariosPensao().isEmpty());

        // Test setters
        deducao.setId(2L);
        deducao.setIndTpDeducao(2);
        deducao.setVlrDeducao(new BigDecimal("1000.50"));
        deducao.setNrInscPrevComp("98765432109876");
        deducao.setVlrPatrocFunp(new BigDecimal("200.50"));
        
        List<BeneficiarioPensao> beneficiariosPensao = new ArrayList<>();
        beneficiariosPensao.add(new BeneficiarioPensao());
        deducao.setBeneficiariosPensao(beneficiariosPensao);

        // Verify updated values
        assertEquals(2L, deducao.getId());
        assertEquals(2, deducao.getIndTpDeducao());
        assertEquals(new BigDecimal("1000.50"), deducao.getVlrDeducao());
        assertEquals("98765432109876", deducao.getNrInscPrevComp());
        assertEquals(new BigDecimal("200.50"), deducao.getVlrPatrocFunp());
        assertEquals(1, deducao.getBeneficiariosPensao().size());
    }

    @Test
    void testEqualsAndHashCode() {
        // Create two deducoes with the same ID
        Deducao deducao1 = Deducao.builder().id(1L).build();
        Deducao deducao2 = Deducao.builder().id(1L).build();
        
        // Create a deducao with a different ID
        Deducao deducao3 = Deducao.builder().id(2L).build();

        // Test equals
        assertEquals(deducao1, deducao2);
        assertNotEquals(deducao1, deducao3);
        
        // Test hashCode
        assertEquals(deducao1.hashCode(), deducao2.hashCode());
        assertNotEquals(deducao1.hashCode(), deducao3.hashCode());
        
        // Test equals with null and different class
        assertNotEquals(deducao1, null);
        assertNotEquals(deducao1, "not a deducao");
    }
}