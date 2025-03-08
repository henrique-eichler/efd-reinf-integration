package br.gov.receita.reinf.r4010.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoTest {

    @Test
    void testBuilderAndGettersSetters() {
        // Create a deducao for the pagamento
        Deducao deducao = Deducao.builder()
                .id(10L)
                .indTpDeducao(1)
                .vlrDeducao(new BigDecimal("100.50"))
                .build();
        
        List<Deducao> deducoes = new ArrayList<>();
        deducoes.add(deducao);
        
        // Create a pagamento using the builder
        LocalDate dtFG = LocalDate.of(2023, 1, 15);
        Pagamento pagamento = Pagamento.builder()
                .id(1L)
                .natRend(1000)
                .observ("Observação de teste")
                .dtFG(dtFG)
                .compFP("202301")
                .indDecTerc("S")
                .vlrRendBruto(new BigDecimal("5000.00"))
                .vlrRendTrib(new BigDecimal("4500.00"))
                .vlrIR(new BigDecimal("900.00"))
                .indRRA("N")
                .indFciScp(0)
                .nrInscFciScp("12345678901234")
                .percSCP(new BigDecimal("10.00"))
                .indJud("N")
                .paisResidExt("BR")
                .deducoes(deducoes)
                .build();

        // Verify getters
        assertEquals(1L, pagamento.getId());
        assertEquals(1000, pagamento.getNatRend());
        assertEquals("Observação de teste", pagamento.getObserv());
        assertEquals(dtFG, pagamento.getDtFG());
        assertEquals("202301", pagamento.getCompFP());
        assertEquals("S", pagamento.getIndDecTerc());
        assertEquals(new BigDecimal("5000.00"), pagamento.getVlrRendBruto());
        assertEquals(new BigDecimal("4500.00"), pagamento.getVlrRendTrib());
        assertEquals(new BigDecimal("900.00"), pagamento.getVlrIR());
        assertEquals("N", pagamento.getIndRRA());
        assertEquals(0, pagamento.getIndFciScp());
        assertEquals("12345678901234", pagamento.getNrInscFciScp());
        assertEquals(new BigDecimal("10.00"), pagamento.getPercSCP());
        assertEquals("N", pagamento.getIndJud());
        assertEquals("BR", pagamento.getPaisResidExt());
        
        assertNotNull(pagamento.getDeducoes());
        assertEquals(1, pagamento.getDeducoes().size());
        assertEquals(10L, pagamento.getDeducoes().get(0).getId());
        assertEquals(1, pagamento.getDeducoes().get(0).getIndTpDeducao());
        assertEquals(new BigDecimal("100.50"), pagamento.getDeducoes().get(0).getVlrDeducao());

        // Test setters
        LocalDate newDtFG = LocalDate.of(2023, 2, 20);
        Deducao newDeducao = Deducao.builder()
                .id(20L)
                .indTpDeducao(2)
                .vlrDeducao(new BigDecimal("200.75"))
                .build();
        
        List<Deducao> newDeducoes = new ArrayList<>();
        newDeducoes.add(newDeducao);
        
        pagamento.setId(2L);
        pagamento.setNatRend(2000);
        pagamento.setObserv("Nova observação");
        pagamento.setDtFG(newDtFG);
        pagamento.setCompFP("202302");
        pagamento.setIndDecTerc("N");
        pagamento.setVlrRendBruto(new BigDecimal("6000.00"));
        pagamento.setVlrRendTrib(new BigDecimal("5500.00"));
        pagamento.setVlrIR(new BigDecimal("1100.00"));
        pagamento.setIndRRA("S");
        pagamento.setIndFciScp(1);
        pagamento.setNrInscFciScp("98765432109876");
        pagamento.setPercSCP(new BigDecimal("20.00"));
        pagamento.setIndJud("S");
        pagamento.setPaisResidExt("US");
        pagamento.setDeducoes(newDeducoes);

        // Verify updated values
        assertEquals(2L, pagamento.getId());
        assertEquals(2000, pagamento.getNatRend());
        assertEquals("Nova observação", pagamento.getObserv());
        assertEquals(newDtFG, pagamento.getDtFG());
        assertEquals("202302", pagamento.getCompFP());
        assertEquals("N", pagamento.getIndDecTerc());
        assertEquals(new BigDecimal("6000.00"), pagamento.getVlrRendBruto());
        assertEquals(new BigDecimal("5500.00"), pagamento.getVlrRendTrib());
        assertEquals(new BigDecimal("1100.00"), pagamento.getVlrIR());
        assertEquals("S", pagamento.getIndRRA());
        assertEquals(1, pagamento.getIndFciScp());
        assertEquals("98765432109876", pagamento.getNrInscFciScp());
        assertEquals(new BigDecimal("20.00"), pagamento.getPercSCP());
        assertEquals("S", pagamento.getIndJud());
        assertEquals("US", pagamento.getPaisResidExt());
        
        assertNotNull(pagamento.getDeducoes());
        assertEquals(1, pagamento.getDeducoes().size());
        assertEquals(20L, pagamento.getDeducoes().get(0).getId());
        assertEquals(2, pagamento.getDeducoes().get(0).getIndTpDeducao());
        assertEquals(new BigDecimal("200.75"), pagamento.getDeducoes().get(0).getVlrDeducao());
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