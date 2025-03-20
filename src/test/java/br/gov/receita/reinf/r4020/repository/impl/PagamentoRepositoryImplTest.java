package br.gov.receita.reinf.r4020.repository.impl;

import br.gov.receita.reinf.r4020.entity.Pagamento;
import br.gov.receita.reinf.repository.test.RepositoryTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoRepositoryImplTest extends RepositoryTestBase {

    private TestPagamentoRepository repository;

    @BeforeEach
    void setUp() {
        repository = new TestPagamentoRepository(em);
    }

    /**
     * Test implementation of PagamentoRepositoryImpl that uses the test EntityManager.
     */
    static class TestPagamentoRepository extends PagamentoRepositoryImpl {

        public TestPagamentoRepository(EntityManager entityManager) {
            super();
            this.entityManager = entityManager;
        }
    }

    @Test
    void testFindByNatRend() {
        // Create test data
        Pagamento pagamento1 = Pagamento.builder()
                .natRend("1234")
                .vlrBruto(new BigDecimal("1000.00"))
                .build();

        Pagamento pagamento2 = Pagamento.builder()
                .natRend("1234")
                .vlrBruto(new BigDecimal("2000.00"))
                .build();

        Pagamento pagamento3 = Pagamento.builder()
                .natRend("5678")
                .vlrBruto(new BigDecimal("3000.00"))
                .build();

        // Persist test data
        em.persist(pagamento1);
        em.persist(pagamento2);
        em.persist(pagamento3);
        em.flush();

        // Test findByNatRend
        List<Pagamento> result1 = repository.findByNatRend("1234");
        assertEquals(2, result1.size());
        assertTrue(result1.contains(pagamento1));
        assertTrue(result1.contains(pagamento2));

        List<Pagamento> result2 = repository.findByNatRend("5678");
        assertEquals(1, result2.size());
        assertTrue(result2.contains(pagamento3));

        List<Pagamento> result3 = repository.findByNatRend("9999");
        assertTrue(result3.isEmpty());
    }

    @Test
    void testFindByDtFG() {
        // Create test data
        LocalDate date1 = LocalDate.of(2023, 1, 15);
        LocalDate date2 = LocalDate.of(2023, 2, 20);

        Pagamento pagamento1 = Pagamento.builder()
                .natRend("1234")
                .dtFG(date1)
                .vlrBruto(new BigDecimal("1000.00"))
                .build();

        Pagamento pagamento2 = Pagamento.builder()
                .natRend("5678")
                .dtFG(date1)
                .vlrBruto(new BigDecimal("2000.00"))
                .build();

        Pagamento pagamento3 = Pagamento.builder()
                .natRend("9012")
                .dtFG(date2)
                .vlrBruto(new BigDecimal("3000.00"))
                .build();

        // Persist test data
        em.persist(pagamento1);
        em.persist(pagamento2);
        em.persist(pagamento3);
        em.flush();

        // Test findByDtFG
        List<Pagamento> result1 = repository.findByDtFG(date1);
        assertEquals(2, result1.size());
        assertTrue(result1.contains(pagamento1));
        assertTrue(result1.contains(pagamento2));

        List<Pagamento> result2 = repository.findByDtFG(date2);
        assertEquals(1, result2.size());
        assertTrue(result2.contains(pagamento3));

        List<Pagamento> result3 = repository.findByDtFG(LocalDate.of(2023, 3, 1));
        assertTrue(result3.isEmpty());
    }

    @Test
    void testFindByNatRendAndDtFG() {
        // Create test data
        LocalDate date1 = LocalDate.of(2023, 1, 15);
        LocalDate date2 = LocalDate.of(2023, 2, 20);

        Pagamento pagamento1 = Pagamento.builder()
                .natRend("1234")
                .dtFG(date1)
                .vlrBruto(new BigDecimal("1000.00"))
                .build();

        Pagamento pagamento2 = Pagamento.builder()
                .natRend("1234")
                .dtFG(date2)
                .vlrBruto(new BigDecimal("2000.00"))
                .build();

        Pagamento pagamento3 = Pagamento.builder()
                .natRend("5678")
                .dtFG(date1)
                .vlrBruto(new BigDecimal("3000.00"))
                .build();

        // Persist test data
        em.persist(pagamento1);
        em.persist(pagamento2);
        em.persist(pagamento3);
        em.flush();

        // Test findByNatRendAndDtFG
        List<Pagamento> result1 = repository.findByNatRendAndDtFG("1234", date1);
        assertEquals(1, result1.size());
        assertTrue(result1.contains(pagamento1));

        List<Pagamento> result2 = repository.findByNatRendAndDtFG("1234", date2);
        assertEquals(1, result2.size());
        assertTrue(result2.contains(pagamento2));

        List<Pagamento> result3 = repository.findByNatRendAndDtFG("5678", date1);
        assertEquals(1, result3.size());
        assertTrue(result3.contains(pagamento3));

        List<Pagamento> result4 = repository.findByNatRendAndDtFG("9999", date1);
        assertTrue(result4.isEmpty());

        List<Pagamento> result5 = repository.findByNatRendAndDtFG("1234", LocalDate.of(2023, 3, 1));
        assertTrue(result5.isEmpty());
    }
}