package br.gov.receita.reinf.r4010.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstabelecimentoTest {

    @Test
    void testBuilderAndGettersSetters() {
        // Create a beneficiario for the estabelecimento
        Beneficiario beneficiario = Beneficiario.builder()
                .id(10L)
                .cpfBenef("12345678901")
                .nmBenef("John Doe")
                .build();
        
        // Create an estabelecimento using the builder
        Estabelecimento estabelecimento = Estabelecimento.builder()
                .id(1L)
                .tpInscEstab(1) // 1 - CNPJ
                .nrInscEstab("12345678901234")
                .beneficiario(beneficiario)
                .build();

        // Verify getters
        assertEquals(1L, estabelecimento.getId());
        assertEquals(1, estabelecimento.getTpInscEstab());
        assertEquals("12345678901234", estabelecimento.getNrInscEstab());
        assertNotNull(estabelecimento.getBeneficiario());
        assertEquals(10L, estabelecimento.getBeneficiario().getId());
        assertEquals("12345678901", estabelecimento.getBeneficiario().getCpfBenef());
        assertEquals("John Doe", estabelecimento.getBeneficiario().getNmBenef());

        // Test setters
        Beneficiario newBeneficiario = Beneficiario.builder()
                .id(20L)
                .cpfBenef("98765432109")
                .nmBenef("Jane Doe")
                .build();
        
        estabelecimento.setId(2L);
        estabelecimento.setTpInscEstab(2); // 2 - CPF
        estabelecimento.setNrInscEstab("98765432109");
        estabelecimento.setBeneficiario(newBeneficiario);

        // Verify updated values
        assertEquals(2L, estabelecimento.getId());
        assertEquals(2, estabelecimento.getTpInscEstab());
        assertEquals("98765432109", estabelecimento.getNrInscEstab());
        assertNotNull(estabelecimento.getBeneficiario());
        assertEquals(20L, estabelecimento.getBeneficiario().getId());
        assertEquals("98765432109", estabelecimento.getBeneficiario().getCpfBenef());
        assertEquals("Jane Doe", estabelecimento.getBeneficiario().getNmBenef());
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