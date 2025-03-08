package br.gov.receita.reinf.repository.test;

import br.gov.receita.reinf.repository.impl.AbstractRepository;
import javax.persistence.EntityManager;

/**
 * Test implementation of AbstractRepository.
 * Uses the EntityManager provided by RepositoryTestBase instead of the one injected by the container.
 *
 * @param <T> the entity type
 * @param <ID> the entity's primary key type
 */
public class TestRepository<T, ID> extends AbstractRepository<T, ID> {

    /**
     * Constructor.
     *
     * @param entityClass the entity class
     * @param entityManager the entity manager to use
     */
    public TestRepository(Class<T> entityClass, EntityManager entityManager) {
        super(entityClass);
        this.entityManager = entityManager;
    }
}