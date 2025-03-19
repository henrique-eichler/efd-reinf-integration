package br.gov.receita.reinf.r4020.repository;

import br.gov.receita.reinf.r4020.entity.InfoProcRet;
import br.gov.receita.reinf.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for InfoProcRet entity.
 */
public interface InfoProcRetRepository extends Repository<InfoProcRet, Long> {

    /**
     * Finds InfoProcRet entities by retention process type.
     *
     * @param tpProcRet the retention process type
     * @return a list of InfoProcRet entities with the given retention process type
     */
    List<InfoProcRet> findByTpProcRet(Integer tpProcRet);

    /**
     * Finds an InfoProcRet by its retention process number.
     *
     * @param nrProcRet the retention process number
     * @return an Optional containing the InfoProcRet if found, or empty if not found
     */
    Optional<InfoProcRet> findByNrProcRet(String nrProcRet);

    /**
     * Finds InfoProcRet entities by suspension code.
     *
     * @param codSusp the suspension code
     * @return a list of InfoProcRet entities with the given suspension code
     */
    List<InfoProcRet> findByCodSusp(String codSusp);
}