package br.gov.receita.reinf.r4040.repository.impl;

import br.gov.receita.reinf.r4040.entity.Pagamento;
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
    void testFindByDtFG() {
        // Create test data
        LocalDate date1 = LocalDate.of(2023, 1, 15);
        LocalDate date2 = LocalDate.of(2023, 2, 20);

        Pagamento pagamento1 = Pagamento.builder()
                .dtFG(date1)
                .vlrLiq(new BigDecimal("1000.00"))
                .build();

        Pagamento pagamento2 = Pagamento.builder()
                .dtFG(date1)
                .vlrLiq(new BigDecimal("2000.00"))
                .build();

        Pagamento pagamento3 = Pagamento.builder()
                .dtFG(date2)
                .vlrLiq(new BigDecimal("3000.00"))
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
    void testFindByDtEscrCont() {
        // Create test data
        LocalDate date1 = LocalDate.of(2023, 1, 15);
        LocalDate date2 = LocalDate.of(2023, 2, 20);

        Pagamento pagamento1 = Pagamento.builder()
                .dtEscrCont(date1)
                .vlrLiq(new BigDecimal("1000.00"))
                .build();

        Pagamento pagamento2 = Pagamento.builder()
                .dtEscrCont(date1)
                .vlrLiq(new BigDecimal("2000.00"))
                .build();

        Pagamento pagamento3 = Pagamento.builder()
                .dtEscrCont(date2)
                .vlrLiq(new BigDecimal("3000.00"))
                .build();

        // Persist test data
        em.persist(pagamento1);
        em.persist(pagamento2);
        em.persist(pagamento3);
        em.flush();

        // Test findByDtEscrCont
        List<Pagamento> result1 = repository.findByDtEscrCont(date1);
        assertEquals(2, result1.size());
        assertTrue(result1.contains(pagamento1));
        assertTrue(result1.contains(pagamento2));

        List<Pagamento> result2 = repository.findByDtEscrCont(date2);
        assertEquals(1, result2.size());
        assertTrue(result2.contains(pagamento3));

        List<Pagamento> result3 = repository.findByDtEscrCont(LocalDate.of(2023, 3, 1));
        assertTrue(result3.isEmpty());
    }

    @Test
    void testFindByVlrBaseIRGreaterThanEqual() {
        // Create test data
        Pagamento pagamento1 = Pagamento.builder()
                .vlrBaseIR(new BigDecimal("1000.00"))
                .build();

        Pagamento pagamento2 = Pagamento.builder()
                .vlrBaseIR(new BigDecimal("2000.00"))
                .build();

        Pagamento pagamento3 = Pagamento.builder()
                .vlrBaseIR(new BigDecimal("3000.00"))
                .build();

        // Persist test data
        em.persist(pagamento1);
        em.persist(pagamento2);
        em.persist(pagamento3);
        em.flush();

        // Test findByVlrBaseIRGreaterThanEqual
        List<Pagamento> result1 = repository.findByVlrBaseIRGreaterThanEqual(new BigDecimal("1000.00"));
        assertEquals(3, result1.size());
        assertTrue(result1.contains(pagamento1));
        assertTrue(result1.contains(pagamento2));
        assertTrue(result1.contains(pagamento3));

        List<Pagamento> result2 = repository.findByVlrBaseIRGreaterThanEqual(new BigDecimal("2000.00"));
        assertEquals(2, result2.size());
        assertTrue(result2.contains(pagamento2));
        assertTrue(result2.contains(pagamento3));

        List<Pagamento> result3 = repository.findByVlrBaseIRGreaterThanEqual(new BigDecimal("3000.00"));
        assertEquals(1, result3.size());
        assertTrue(result3.contains(pagamento3));

        List<Pagamento> result4 = repository.findByVlrBaseIRGreaterThanEqual(new BigDecimal("4000.00"));
        assertTrue(result4.isEmpty());
    }
}