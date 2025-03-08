package br.gov.receita.reinf.r4010.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContribuinteTest {

    @Test
    void testBuilderAndGettersSetters() {
        // Create a contribuinte using the builder
        Contribuinte contribuinte = Contribuinte.builder()
                .tpInsc(1) // 1 - CNPJ
                .nrInsc("12345678901234")
                .build();

        // Verify getters
        assertEquals(1, contribuinte.getTpInsc());
        assertEquals("12345678901234", contribuinte.getNrInsc());

        // Test setters
        contribuinte.setTpInsc(2); // 2 - CPF
        contribuinte.setNrInsc("98765432109");

        // Verify updated values
        assertEquals(2, contribuinte.getTpInsc());
        assertEquals("98765432109", contribuinte.getNrInsc());
    }

    @Test
    void testEqualsAndHashCode() {
        // Create two contribuintes with the same values
        Contribuinte contribuinte1 = Contribuinte.builder()
                .tpInsc(1)
                .nrInsc("12345678901234")
                .build();
        
        Contribuinte contribuinte2 = Contribuinte.builder()
                .tpInsc(1)
                .nrInsc("12345678901234")
                .build();
        
        // Create a contribuinte with different values
        Contribuinte contribuinte3 = Contribuinte.builder()
                .tpInsc(2)
                .nrInsc("98765432109")
                .build();

        // Test equals
        assertEquals(contribuinte1, contribuinte2);
        assertNotEquals(contribuinte1, contribuinte3);
        
        // Test hashCode
        assertEquals(contribuinte1.hashCode(), contribuinte2.hashCode());
        assertNotEquals(contribuinte1.hashCode(), contribuinte3.hashCode());
        
        // Test equals with null and different class
        assertNotEquals(contribuinte1, null);
        assertNotEquals(contribuinte1, "not a contribuinte");
        
        // Test equals with different fields
        Contribuinte contribuinte4 = Contribuinte.builder()
                .tpInsc(1)
                .nrInsc("98765432109")
                .build();
        
        assertNotEquals(contribuinte1, contribuinte4);
    }
}