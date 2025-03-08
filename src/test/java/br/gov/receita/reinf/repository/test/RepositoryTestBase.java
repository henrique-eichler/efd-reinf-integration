package br.gov.receita.reinf.repository.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * Base class for repository tests.
 * Sets up an in-memory H2 database for testing repositories.
 */
public abstract class RepositoryTestBase {

    protected static EntityManagerFactory emf;
    protected EntityManager em;

    /**
     * Creates the EntityManagerFactory before all tests.
     */
    @BeforeAll
    public static void setupClass() {
        // Create EntityManagerFactory using the test persistence unit
        emf = Persistence.createEntityManagerFactory("reinfPU");
    }

    /**
     * Closes the EntityManagerFactory after all tests.
     */
    @AfterAll
    public static void tearDownClass() {
        if (emf != null) {
            emf.close();
        }
    }

    /**
     * Creates an EntityManager and begins a transaction before each test.
     */
    @BeforeEach
    public void setup() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    /**
     * Rolls back the transaction and closes the EntityManager after each test.
     */
    @AfterEach
    public void tearDown() {
        if (em != null) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }
}