package br.gov.receita.reinf.r4040.repository;

import br.gov.receita.reinf.r4040.entity.ProcessoRetencao;
import br.gov.receita.reinf.repository.Repository;

import java.util.List;

/**
 * Repository interface for ProcessoRetencao entity.
 */
public interface ProcessoRetencaoRepository extends Repository<ProcessoRetencao, Long> {

    /**
     * Find retention processes by process number.
     *
     * @param nrProcRet the process number
     * @return list of retention processes
     */
    List<ProcessoRetencao> findByNrProcRet(String nrProcRet);

    /**
     * Find retention processes by process type.
     *
     * @param tpProcRet the process type
     * @return list of retention processes
     */
    List<ProcessoRetencao> findByTpProcRet(Integer tpProcRet);

    /**
     * Find retention processes by suspension code.
     *
     * @param codSusp the suspension code
     * @return list of retention processes
     */
    List<ProcessoRetencao> findByCodSusp(String codSusp);
}