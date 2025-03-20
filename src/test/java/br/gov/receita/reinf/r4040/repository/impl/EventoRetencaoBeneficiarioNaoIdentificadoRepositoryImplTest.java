package br.gov.receita.reinf.r4040.repository.impl;

import br.gov.receita.reinf.r4040.entity.Contribuinte;
import br.gov.receita.reinf.r4040.entity.Estabelecimento;
import br.gov.receita.reinf.r4040.entity.EventoRetencaoBeneficiarioNaoIdentificado;
import br.gov.receita.reinf.repository.test.RepositoryTestBase;
import br.gov.receita.reinf.repository.test.TestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.time.YearMonth;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventoRetencaoBeneficiarioNaoIdentificadoRepositoryImplTest extends RepositoryTestBase {

    private TestEventoRetencaoBeneficiarioNaoIdentificadoRepository repository;

    @BeforeEach
    void setUp() {
        repository = new TestEventoRetencaoBeneficiarioNaoIdentificadoRepository(em);
    }

    /**
     * Test implementation of EventoRetencaoBeneficiarioNaoIdentificadoRepositoryImpl that uses the test EntityManager.
     */
    static class TestEventoRetencaoBeneficiarioNaoIdentificadoRepository extends EventoRetencaoBeneficiarioNaoIdentificadoRepositoryImpl {

        public TestEventoRetencaoBeneficiarioNaoIdentificadoRepository(EntityManager entityManager) {
            super();
            this.entityManager = entityManager;
        }
    }

    @Test
    void testFindByPerApur() {
        // Create test data
        YearMonth perApur1 = YearMonth.of(2023, 1);
        YearMonth perApur2 = YearMonth.of(2023, 2);

        Contribuinte contribuinte = Contribuinte.builder()
                .tpInsc(1)
                .nrInsc("12345678901234")
                .build();

        Estabelecimento estabelecimento = Estabelecimento.builder()
                .tpInscEstab(1)
                .nrInscEstab("12345678901234")
                .build();

        EventoRetencaoBeneficiarioNaoIdentificado evento1 = EventoRetencaoBeneficiarioNaoIdentificado.builder()
                .idEvento("ID1")
                .perApur(perApur1)
                .contribuinte(contribuinte)
                .estabelecimento(estabelecimento)
                .build();

        EventoRetencaoBeneficiarioNaoIdentificado evento2 = EventoRetencaoBeneficiarioNaoIdentificado.builder()
                .idEvento("ID2")
                .perApur(perApur1)
                .contribuinte(contribuinte)
                .estabelecimento(estabelecimento)
                .build();

        EventoRetencaoBeneficiarioNaoIdentificado evento3 = EventoRetencaoBeneficiarioNaoIdentificado.builder()
                .idEvento("ID3")
                .perApur(perApur2)
                .contribuinte(contribuinte)
                .estabelecimento(estabelecimento)
                .build();

        // Persist test data
        em.persist(evento1);
        em.persist(evento2);
        em.persist(evento3);
        em.flush();

        // Test findByPerApur
        List<EventoRetencaoBeneficiarioNaoIdentificado> result1 = repository.findByPerApur(perApur1);
        assertEquals(2, result1.size());
        assertTrue(result1.stream().anyMatch(e -> "ID1".equals(e.getIdEvento())));
        assertTrue(result1.stream().anyMatch(e -> "ID2".equals(e.getIdEvento())));

        List<EventoRetencaoBeneficiarioNaoIdentificado> result2 = repository.findByPerApur(perApur2);
        assertEquals(1, result2.size());
        assertTrue(result2.stream().anyMatch(e -> "ID3".equals(e.getIdEvento())));

        List<EventoRetencaoBeneficiarioNaoIdentificado> result3 = repository.findByPerApur(YearMonth.of(2023, 3));
        assertTrue(result3.isEmpty());
    }

    @Test
    void testFindByContribuinteNrInsc() {
        // Create test data
        Contribuinte contribuinte1 = Contribuinte.builder()
                .tpInsc(1)
                .nrInsc("12345678901234")
                .build();

        Contribuinte contribuinte2 = Contribuinte.builder()
                .tpInsc(1)
                .nrInsc("98765432109876")
                .build();

        Estabelecimento estabelecimento = Estabelecimento.builder()
                .tpInscEstab(1)
                .nrInscEstab("12345678901234")
                .build();

        EventoRetencaoBeneficiarioNaoIdentificado evento1 = EventoRetencaoBeneficiarioNaoIdentificado.builder()
                .idEvento("ID1")
                .contribuinte(contribuinte1)
                .estabelecimento(estabelecimento)
                .build();

        EventoRetencaoBeneficiarioNaoIdentificado evento2 = EventoRetencaoBeneficiarioNaoIdentificado.builder()
                .idEvento("ID2")
                .contribuinte(contribuinte1)
                .estabelecimento(estabelecimento)
                .build();

        EventoRetencaoBeneficiarioNaoIdentificado evento3 = EventoRetencaoBeneficiarioNaoIdentificado.builder()
                .idEvento("ID3")
                .contribuinte(contribuinte2)
                .estabelecimento(estabelecimento)
                .build();

        // Persist test data
        em.persist(evento1);
        em.persist(evento2);
        em.persist(evento3);
        em.flush();

        // Test findByContribuinteNrInsc
        List<EventoRetencaoBeneficiarioNaoIdentificado> result1 = repository.findByContribuinteNrInsc("12345678901234");
        assertEquals(2, result1.size());
        assertTrue(result1.stream().anyMatch(e -> "ID1".equals(e.getIdEvento())));
        assertTrue(result1.stream().anyMatch(e -> "ID2".equals(e.getIdEvento())));

        List<EventoRetencaoBeneficiarioNaoIdentificado> result2 = repository.findByContribuinteNrInsc("98765432109876");
        assertEquals(1, result2.size());
        assertTrue(result2.stream().anyMatch(e -> "ID3".equals(e.getIdEvento())));

        List<EventoRetencaoBeneficiarioNaoIdentificado> result3 = repository.findByContribuinteNrInsc("00000000000000");
        assertTrue(result3.isEmpty());
    }
}
