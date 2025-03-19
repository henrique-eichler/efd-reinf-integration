package br.gov.receita.reinf.r4020.repository;

import br.gov.receita.reinf.r4020.entity.InfoPgtoExt;
import br.gov.receita.reinf.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for InfoPgtoExt entity.
 */
public interface InfoPgtoExtRepository extends Repository<InfoPgtoExt, Long> {

    /**
     * Finds InfoPgtoExt entities by NIF indicator.
     *
     * @param indNIF the NIF indicator
     * @return a list of InfoPgtoExt entities with the given NIF indicator
     */
    List<InfoPgtoExt> findByIndNIF(Integer indNIF);

    /**
     * Finds an InfoPgtoExt by its beneficiary NIF.
     *
     * @param nifBenef the beneficiary NIF
     * @return an Optional containing the InfoPgtoExt if found, or empty if not found
     */
    Optional<InfoPgtoExt> findByNifBenef(String nifBenef);

    /**
     * Finds InfoPgtoExt entities by payment source relationship.
     *
     * @param relFontPg the payment source relationship
     * @return a list of InfoPgtoExt entities with the given payment source relationship
     */
    List<InfoPgtoExt> findByRelFontPg(String relFontPg);
}