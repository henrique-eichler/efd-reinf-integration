package br.gov.receita.reinf.r4020.repository;

import br.gov.receita.reinf.r4020.entity.IdeAdv;
import br.gov.receita.reinf.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for IdeAdv entity.
 */
public interface IdeAdvRepository extends Repository<IdeAdv, Long> {

    /**
     * Finds an IdeAdv by its inscription number.
     *
     * @param nrInscAdv the inscription number of the advocate
     * @return an Optional containing the IdeAdv if found, or empty if not found
     */
    Optional<IdeAdv> findByNrInscAdv(String nrInscAdv);

    /**
     * Finds IdeAdv entities by inscription type.
     *
     * @param tpInscAdv the inscription type of the advocate
     * @return a list of IdeAdv entities with the given inscription type
     */
    List<IdeAdv> findByTpInscAdv(Integer tpInscAdv);
}