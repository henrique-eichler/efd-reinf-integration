package br.gov.receita.reinf.r4010.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BeneficiarioPensaoTest {

    @Test
    void testBuilderAndGettersSetters() {
        // Create a beneficiarioPensao using the builder
        BeneficiarioPensao beneficiarioPensao = BeneficiarioPensao.builder()
                .id(1L)
                .cpfDep("12345678901")
                .vlrDepen(new BigDecimal("1000.50"))
                .build();

        // Verify getters
        assertEquals(1L, beneficiarioPensao.getId());
        assertEquals("12345678901", beneficiarioPensao.getCpfDep());
        assertEquals(new BigDecimal("1000.50"), beneficiarioPensao.getVlrDepen());

        // Test setters
        beneficiarioPensao.setId(2L);
        beneficiarioPensao.setCpfDep("98765432109");
        beneficiarioPensao.setVlrDepen(new BigDecimal("2000.75"));

        // Verify updated values
        assertEquals(2L, beneficiarioPensao.getId());
        assertEquals("98765432109", beneficiarioPensao.getCpfDep());
        assertEquals(new BigDecimal("2000.75"), beneficiarioPensao.getVlrDepen());
    }

    @Test
    void testEqualsAndHashCode() {
        // Create two beneficiariosPensao with the same ID
        BeneficiarioPensao beneficiarioPensao1 = BeneficiarioPensao.builder().id(1L).build();
        BeneficiarioPensao beneficiarioPensao2 = BeneficiarioPensao.builder().id(1L).build();
        
        // Create a beneficiarioPensao with a different ID
        BeneficiarioPensao beneficiarioPensao3 = BeneficiarioPensao.builder().id(2L).build();

        // Test equals
        assertEquals(beneficiarioPensao1, beneficiarioPensao2);
        assertNotEquals(beneficiarioPensao1, beneficiarioPensao3);
        
        // Test hashCode
        assertEquals(beneficiarioPensao1.hashCode(), beneficiarioPensao2.hashCode());
        assertNotEquals(beneficiarioPensao1.hashCode(), beneficiarioPensao3.hashCode());
        
        // Test equals with null and different class
        assertNotEquals(beneficiarioPensao1, null);
        assertNotEquals(beneficiarioPensao1, "not a beneficiarioPensao");
    }
}