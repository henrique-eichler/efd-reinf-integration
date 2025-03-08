package br.gov.receita.reinf.r4010.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DependenteTest {

    @Test
    void testBuilderAndGettersSetters() {
        // Create a dependente using the builder
        LocalDate birthDate = LocalDate.of(2000, 1, 15);
        Dependente dependente = Dependente.builder()
                .id(1L)
                .cpfDep("12345678901")
                .dtNascto(birthDate)
                .nome("John Doe Jr")
                .relDep(3) // Filho ou enteado
                .descrDep("Filho")
                .build();

        // Verify getters
        assertEquals(1L, dependente.getId());
        assertEquals("12345678901", dependente.getCpfDep());
        assertEquals(birthDate, dependente.getDtNascto());
        assertEquals("John Doe Jr", dependente.getNome());
        assertEquals(3, dependente.getRelDep());
        assertEquals("Filho", dependente.getDescrDep());

        // Test setters
        LocalDate newBirthDate = LocalDate.of(2001, 2, 20);
        dependente.setId(2L);
        dependente.setCpfDep("98765432109");
        dependente.setDtNascto(newBirthDate);
        dependente.setNome("Jane Doe Jr");
        dependente.setRelDep(4); // Irmão ou irmã
        dependente.setDescrDep("Irmã");

        // Verify updated values
        assertEquals(2L, dependente.getId());
        assertEquals("98765432109", dependente.getCpfDep());
        assertEquals(newBirthDate, dependente.getDtNascto());
        assertEquals("Jane Doe Jr", dependente.getNome());
        assertEquals(4, dependente.getRelDep());
        assertEquals("Irmã", dependente.getDescrDep());
    }

    @Test
    void testEqualsAndHashCode() {
        // Create two dependentes with the same ID
        Dependente dependente1 = Dependente.builder().id(1L).build();
        Dependente dependente2 = Dependente.builder().id(1L).build();
        
        // Create a dependente with a different ID
        Dependente dependente3 = Dependente.builder().id(2L).build();

        // Test equals
        assertEquals(dependente1, dependente2);
        assertNotEquals(dependente1, dependente3);
        
        // Test hashCode
        assertEquals(dependente1.hashCode(), dependente2.hashCode());
        assertNotEquals(dependente1.hashCode(), dependente3.hashCode());
        
        // Test equals with null and different class
        assertNotEquals(dependente1, null);
        assertNotEquals(dependente1, "not a dependente");
    }
}