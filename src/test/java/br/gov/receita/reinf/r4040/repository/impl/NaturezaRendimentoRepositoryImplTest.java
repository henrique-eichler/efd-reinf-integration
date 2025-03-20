package br.gov.receita.reinf.r4040.repository.impl;

import br.gov.receita.reinf.r4040.entity.NaturezaRendimento;
import br.gov.receita.reinf.repository.test.RepositoryTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NaturezaRendimentoRepositoryImplTest extends RepositoryTestBase {

    private TestNaturezaRendimentoRepository repository;

    @BeforeEach
    void setUp() {
        repository = new TestNaturezaRendimentoRepository(em);
    }

    /**
     * Test implementation of NaturezaRendimentoRepositoryImpl that uses the test EntityManager.
     */
    static class TestNaturezaRendimentoRepository extends NaturezaRendimentoRepositoryImpl {

        public TestNaturezaRendimentoRepository(EntityManager entityManager) {
            super();
            this.entityManager = entityManager;
        }
    }

    @Test
    void testFindByNatRend() {
        // Create test data
        NaturezaRendimento naturezaRendimento1 = NaturezaRendimento.builder()
                .natRend("12345")
                .build();

        NaturezaRendimento naturezaRendimento2 = NaturezaRendimento.builder()
                .natRend("12345")
                .build();

        NaturezaRendimento naturezaRendimento3 = NaturezaRendimento.builder()
                .natRend("67890")
                .build();

        // Persist test data
        em.persist(naturezaRendimento1);
        em.persist(naturezaRendimento2);
        em.persist(naturezaRendimento3);
        em.flush();

        // Test findByNatRend
        List<NaturezaRendimento> result1 = repository.findByNatRend("12345");
        assertEquals(2, result1.size());
        assertTrue(result1.contains(naturezaRendimento1));
        assertTrue(result1.contains(naturezaRendimento2));

        List<NaturezaRendimento> result2 = repository.findByNatRend("67890");
        assertEquals(1, result2.size());
        assertTrue(result2.contains(naturezaRendimento3));

        List<NaturezaRendimento> result3 = repository.findByNatRend("00000");
        assertTrue(result3.isEmpty());
    }
}