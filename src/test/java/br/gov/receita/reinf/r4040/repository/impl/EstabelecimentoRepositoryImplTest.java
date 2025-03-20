package br.gov.receita.reinf.r4040.repository.impl;

import br.gov.receita.reinf.r4040.entity.Estabelecimento;
import br.gov.receita.reinf.repository.test.RepositoryTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EstabelecimentoRepositoryImplTest extends RepositoryTestBase {

    private TestEstabelecimentoRepository repository;

    @BeforeEach
    void setUp() {
        repository = new TestEstabelecimentoRepository(em);
    }

    /**
     * Test implementation of EstabelecimentoRepositoryImpl that uses the test EntityManager.
     */
    static class TestEstabelecimentoRepository extends EstabelecimentoRepositoryImpl {

        public TestEstabelecimentoRepository(EntityManager entityManager) {
            super();
            this.entityManager = entityManager;
        }
    }

    @Test
    void testFindByNrInscEstab() {
        // Create test data
        Estabelecimento estabelecimento1 = Estabelecimento.builder()
                .tpInscEstab(1)
                .nrInscEstab("12345678901234")
                .build();

        Estabelecimento estabelecimento2 = Estabelecimento.builder()
                .tpInscEstab(1)
                .nrInscEstab("12345678901234")
                .build();

        Estabelecimento estabelecimento3 = Estabelecimento.builder()
                .tpInscEstab(1)
                .nrInscEstab("98765432109876")
                .build();

        // Persist test data
        em.persist(estabelecimento1);
        em.persist(estabelecimento2);
        em.persist(estabelecimento3);
        em.flush();

        // Test findByNrInscEstab
        List<Estabelecimento> result1 = repository.findByNrInscEstab("12345678901234");
        assertEquals(2, result1.size());
        assertTrue(result1.contains(estabelecimento1));
        assertTrue(result1.contains(estabelecimento2));

        List<Estabelecimento> result2 = repository.findByNrInscEstab("98765432109876");
        assertEquals(1, result2.size());
        assertTrue(result2.contains(estabelecimento3));

        List<Estabelecimento> result3 = repository.findByNrInscEstab("00000000000000");
        assertTrue(result3.isEmpty());
    }

    @Test
    void testFindByTpInscEstab() {
        // Create test data
        Estabelecimento estabelecimento1 = Estabelecimento.builder()
                .tpInscEstab(1)
                .nrInscEstab("12345678901234")
                .build();

        Estabelecimento estabelecimento2 = Estabelecimento.builder()
                .tpInscEstab(1)
                .nrInscEstab("98765432109876")
                .build();

        Estabelecimento estabelecimento3 = Estabelecimento.builder()
                .tpInscEstab(2)
                .nrInscEstab("12345678901")
                .build();

        // Persist test data
        em.persist(estabelecimento1);
        em.persist(estabelecimento2);
        em.persist(estabelecimento3);
        em.flush();

        // Test findByTpInscEstab
        List<Estabelecimento> result1 = repository.findByTpInscEstab(1);
        assertEquals(2, result1.size());
        assertTrue(result1.contains(estabelecimento1));
        assertTrue(result1.contains(estabelecimento2));

        List<Estabelecimento> result2 = repository.findByTpInscEstab(2);
        assertEquals(1, result2.size());
        assertTrue(result2.contains(estabelecimento3));

        List<Estabelecimento> result3 = repository.findByTpInscEstab(3);
        assertTrue(result3.isEmpty());
    }
}