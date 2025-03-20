package br.gov.receita.reinf.r4040.repository.impl;

import br.gov.receita.reinf.r4040.entity.ProcessoRetencao;
import br.gov.receita.reinf.repository.test.RepositoryTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProcessoRetencaoRepositoryImplTest extends RepositoryTestBase {

    private TestProcessoRetencaoRepository repository;

    @BeforeEach
    void setUp() {
        repository = new TestProcessoRetencaoRepository(em);
    }

    /**
     * Test implementation of ProcessoRetencaoRepositoryImpl that uses the test EntityManager.
     */
    static class TestProcessoRetencaoRepository extends ProcessoRetencaoRepositoryImpl {

        public TestProcessoRetencaoRepository(EntityManager entityManager) {
            super();
            this.entityManager = entityManager;
        }
    }

    @Test
    void testFindByNrProcRet() {
        // Create test data
        ProcessoRetencao processoRetencao1 = ProcessoRetencao.builder()
                .nrProcRet("12345678901234")
                .tpProcRet(1)
                .vlrBaseSuspIR(new BigDecimal("1000.00"))
                .build();

        ProcessoRetencao processoRetencao2 = ProcessoRetencao.builder()
                .nrProcRet("12345678901234")
                .tpProcRet(2)
                .vlrBaseSuspIR(new BigDecimal("2000.00"))
                .build();

        ProcessoRetencao processoRetencao3 = ProcessoRetencao.builder()
                .nrProcRet("98765432109876")
                .tpProcRet(1)
                .vlrBaseSuspIR(new BigDecimal("3000.00"))
                .build();

        // Persist test data
        em.persist(processoRetencao1);
        em.persist(processoRetencao2);
        em.persist(processoRetencao3);
        em.flush();

        // Test findByNrProcRet
        List<ProcessoRetencao> result1 = repository.findByNrProcRet("12345678901234");
        assertEquals(2, result1.size());
        assertTrue(result1.contains(processoRetencao1));
        assertTrue(result1.contains(processoRetencao2));

        List<ProcessoRetencao> result2 = repository.findByNrProcRet("98765432109876");
        assertEquals(1, result2.size());
        assertTrue(result2.contains(processoRetencao3));

        List<ProcessoRetencao> result3 = repository.findByNrProcRet("00000000000000");
        assertTrue(result3.isEmpty());
    }

    @Test
    void testFindByTpProcRet() {
        // Create test data
        ProcessoRetencao processoRetencao1 = ProcessoRetencao.builder()
                .nrProcRet("12345678901234")
                .tpProcRet(1)
                .vlrBaseSuspIR(new BigDecimal("1000.00"))
                .build();

        ProcessoRetencao processoRetencao2 = ProcessoRetencao.builder()
                .nrProcRet("98765432109876")
                .tpProcRet(1)
                .vlrBaseSuspIR(new BigDecimal("2000.00"))
                .build();

        ProcessoRetencao processoRetencao3 = ProcessoRetencao.builder()
                .nrProcRet("11111111111111")
                .tpProcRet(2)
                .vlrBaseSuspIR(new BigDecimal("3000.00"))
                .build();

        // Persist test data
        em.persist(processoRetencao1);
        em.persist(processoRetencao2);
        em.persist(processoRetencao3);
        em.flush();

        // Test findByTpProcRet
        List<ProcessoRetencao> result1 = repository.findByTpProcRet(1);
        assertEquals(2, result1.size());
        assertTrue(result1.contains(processoRetencao1));
        assertTrue(result1.contains(processoRetencao2));

        List<ProcessoRetencao> result2 = repository.findByTpProcRet(2);
        assertEquals(1, result2.size());
        assertTrue(result2.contains(processoRetencao3));

        List<ProcessoRetencao> result3 = repository.findByTpProcRet(3);
        assertTrue(result3.isEmpty());
    }

    @Test
    void testFindByCodSusp() {
        // Create test data
        ProcessoRetencao processoRetencao1 = ProcessoRetencao.builder()
                .nrProcRet("12345678901234")
                .tpProcRet(1)
                .codSusp("SUSP001")
                .vlrBaseSuspIR(new BigDecimal("1000.00"))
                .build();

        ProcessoRetencao processoRetencao2 = ProcessoRetencao.builder()
                .nrProcRet("98765432109876")
                .tpProcRet(2)
                .codSusp("SUSP001")
                .vlrBaseSuspIR(new BigDecimal("2000.00"))
                .build();

        ProcessoRetencao processoRetencao3 = ProcessoRetencao.builder()
                .nrProcRet("11111111111111")
                .tpProcRet(1)
                .codSusp("SUSP002")
                .vlrBaseSuspIR(new BigDecimal("3000.00"))
                .build();

        // Persist test data
        em.persist(processoRetencao1);
        em.persist(processoRetencao2);
        em.persist(processoRetencao3);
        em.flush();

        // Test findByCodSusp
        List<ProcessoRetencao> result1 = repository.findByCodSusp("SUSP001");
        assertEquals(2, result1.size());
        assertTrue(result1.contains(processoRetencao1));
        assertTrue(result1.contains(processoRetencao2));

        List<ProcessoRetencao> result2 = repository.findByCodSusp("SUSP002");
        assertEquals(1, result2.size());
        assertTrue(result2.contains(processoRetencao3));

        List<ProcessoRetencao> result3 = repository.findByCodSusp("SUSP003");
        assertTrue(result3.isEmpty());
    }
}