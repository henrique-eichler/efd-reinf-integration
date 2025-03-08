package br.gov.receita.reinf.repository;

import java.util.List;
import java.util.Optional;

/**
 * Generic repository interface for CRUD operations.
 *
 * @param <T> the entity type
 * @param <ID> the entity's primary key type
 */
public interface Repository<T, ID> {

    /**
     * Saves an entity.
     *
     * @param entity the entity to save
     * @return the saved entity
     */
    T save(T entity);

    /**
     * Updates an entity.
     *
     * @param entity the entity to update
     * @return the updated entity
     */
    T update(T entity);

    /**
     * Finds an entity by its ID.
     *
     * @param id the entity ID
     * @return an Optional containing the entity if found, or empty if not found
     */
    Optional<T> findById(ID id);

    /**
     * Finds all entities.
     *
     * @return a list of all entities
     */
    List<T> findAll();

    /**
     * Deletes an entity.
     *
     * @param entity the entity to delete
     */
    void delete(T entity);

    /**
     * Deletes an entity by its ID.
     *
     * @param id the entity ID
     */
    void deleteById(ID id);
}