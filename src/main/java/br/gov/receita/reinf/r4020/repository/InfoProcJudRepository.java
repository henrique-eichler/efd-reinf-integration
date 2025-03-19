package br.gov.receita.reinf.r4020.repository;

import br.gov.receita.reinf.r4020.entity.InfoProcJud;
import br.gov.receita.reinf.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for InfoProcJud entity.
 */
public interface InfoProcJudRepository extends Repository<InfoProcJud, Long> {

    /**
     * Finds an InfoProcJud by its process number.
     *
     * @param nrProc the process number
     * @return an Optional containing the InfoProcJud if found, or empty if not found
     */
    Optional<InfoProcJud> findByNrProc(String nrProc);

    /**
     * Finds InfoProcJud entities by origin indicator.
     *
     * @param indOrigRec the origin indicator
     * @return a list of InfoProcJud entities with the given origin indicator
     */
    List<InfoProcJud> findByIndOrigRec(Integer indOrigRec);

    /**
     * Finds InfoProcJud entities by resource origin CNPJ.
     *
     * @param cnpjOrigRecurso the resource origin CNPJ
     * @return a list of InfoProcJud entities with the given resource origin CNPJ
     */
    List<InfoProcJud> findByCnpjOrigRecurso(String cnpjOrigRecurso);
}