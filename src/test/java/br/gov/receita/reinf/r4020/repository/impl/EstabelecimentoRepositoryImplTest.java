package br.gov.receita.reinf.r4020.repository.impl;

import br.gov.receita.reinf.r4020.entity.Estabelecimento;
import br.gov.receita.reinf.repository.test.RepositoryTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.Optional;

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
                .tpInscEstab(2)
                .nrInscEstab("98765432109876")
                .build();

        // Persist test data
        em.persist(estabelecimento1);
        em.persist(estabelecimento2);
        em.flush();

        // Test findByNrInscEstab
        Optional<Estabelecimento> result1 = repository.findByNrInscEstab("12345678901234");
        assertTrue(result1.isPresent());
        assertEquals(estabelecimento1.getId(), result1.get().getId());
        assertEquals(estabelecimento1.getNrInscEstab(), result1.get().getNrInscEstab());

        Optional<Estabelecimento> result2 = repository.findByNrInscEstab("98765432109876");
        assertTrue(result2.isPresent());
        assertEquals(estabelecimento2.getId(), result2.get().getId());
        assertEquals(estabelecimento2.getNrInscEstab(), result2.get().getNrInscEstab());

        Optional<Estabelecimento> result3 = repository.findByNrInscEstab("00000000000000");
        assertFalse(result3.isPresent());
    }

    @Test
    void testFindByTpInscEstabAndNrInscEstab() {
        // Create test data
        Estabelecimento estabelecimento1 = Estabelecimento.builder()
                .tpInscEstab(1)
                .nrInscEstab("12345678901234")
                .build();

        Estabelecimento estabelecimento2 = Estabelecimento.builder()
                .tpInscEstab(2)
                .nrInscEstab("98765432109876")
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

        // Test findByTpInscEstabAndNrInscEstab
        Optional<Estabelecimento> result1 = repository.findByTpInscEstabAndNrInscEstab(1, "12345678901234");
        assertTrue(result1.isPresent());
        assertEquals(estabelecimento1.getId(), result1.get().getId());
        assertEquals(estabelecimento1.getTpInscEstab(), result1.get().getTpInscEstab());
        assertEquals(estabelecimento1.getNrInscEstab(), result1.get().getNrInscEstab());

        Optional<Estabelecimento> result2 = repository.findByTpInscEstabAndNrInscEstab(2, "98765432109876");
        assertTrue(result2.isPresent());
        assertEquals(estabelecimento2.getId(), result2.get().getId());
        assertEquals(estabelecimento2.getTpInscEstab(), result2.get().getTpInscEstab());
        assertEquals(estabelecimento2.getNrInscEstab(), result2.get().getNrInscEstab());

        Optional<Estabelecimento> result3 = repository.findByTpInscEstabAndNrInscEstab(1, "98765432109876");
        assertTrue(result3.isPresent());
        assertEquals(estabelecimento3.getId(), result3.get().getId());
        assertEquals(estabelecimento3.getTpInscEstab(), result3.get().getTpInscEstab());
        assertEquals(estabelecimento3.getNrInscEstab(), result3.get().getNrInscEstab());

        Optional<Estabelecimento> result4 = repository.findByTpInscEstabAndNrInscEstab(3, "00000000000000");
        assertFalse(result4.isPresent());
    }
}