package br.gov.receita.reinf.r4020.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BeneficiarioTest {

    @Test
    void testBuilderAndGettersSetters() {
        // Create a beneficiario using the builder
        Beneficiario beneficiario = Beneficiario.builder()
                .id(1L)
                .cnpjBenef("12345678901234")
                .nmBenef("Empresa XYZ")
                .isenImun(1)
                .ideEvtAdic("ID123456")
                .pagamentos(new ArrayList<>())
                .build();

        // Verify getters
        assertEquals(1L, beneficiario.getId());
        assertEquals("12345678901234", beneficiario.getCnpjBenef());
        assertEquals("Empresa XYZ", beneficiario.getNmBenef());
        assertEquals(1, beneficiario.getIsenImun());
        assertEquals("ID123456", beneficiario.getIdeEvtAdic());
        assertNotNull(beneficiario.getPagamentos());
        assertTrue(beneficiario.getPagamentos().isEmpty());

        // Test setters
        beneficiario.setId(2L);
        beneficiario.setCnpjBenef("98765432109876");
        beneficiario.setNmBenef("Empresa ABC");
        beneficiario.setIsenImun(2);
        beneficiario.setIdeEvtAdic("ID654321");
        
        List<Pagamento> pagamentos = new ArrayList<>();
        pagamentos.add(new Pagamento());
        beneficiario.setPagamentos(pagamentos);

        // Verify updated values
        assertEquals(2L, beneficiario.getId());
        assertEquals("98765432109876", beneficiario.getCnpjBenef());
        assertEquals("Empresa ABC", beneficiario.getNmBenef());
        assertEquals(2, beneficiario.getIsenImun());
        assertEquals("ID654321", beneficiario.getIdeEvtAdic());
        assertEquals(1, beneficiario.getPagamentos().size());
    }

    @Test
    void testEqualsAndHashCode() {
        // Create two beneficiarios with the same ID
        Beneficiario beneficiario1 = Beneficiario.builder().id(1L).build();
        Beneficiario beneficiario2 = Beneficiario.builder().id(1L).build();
        
        // Create a beneficiario with a different ID
        Beneficiario beneficiario3 = Beneficiario.builder().id(2L).build();

        // Test equals
        assertEquals(beneficiario1, beneficiario2);
        assertNotEquals(beneficiario1, beneficiario3);
        
        // Test hashCode
        assertEquals(beneficiario1.hashCode(), beneficiario2.hashCode());
        assertNotEquals(beneficiario1.hashCode(), beneficiario3.hashCode());
        
        // Test equals with null and different class
        assertNotEquals(beneficiario1, null);
        assertNotEquals(beneficiario1, "not a beneficiario");
    }
}