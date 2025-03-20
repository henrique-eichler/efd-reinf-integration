package br.gov.receita.reinf.r4040.repository.impl;

import br.gov.receita.reinf.r4040.entity.ProcessoRetencao;
import br.gov.receita.reinf.r4040.repository.ProcessoRetencaoRepository;
import br.gov.receita.reinf.repository.impl.AbstractRepository;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Implementation of the ProcessoRetencaoRepository interface.
 */
@Stateless
public class ProcessoRetencaoRepositoryImpl extends AbstractRepository<ProcessoRetencao, Long> implements ProcessoRetencaoRepository {

    /**
     * Constructor.
     */
    public ProcessoRetencaoRepositoryImpl() {
        super(ProcessoRetencao.class);
    }

    @Override
    public List<ProcessoRetencao> findByNrProcRet(String nrProcRet) {
        TypedQuery<ProcessoRetencao> query = entityManager.createQuery(
                "SELECT p FROM ProcessoRetencao p WHERE p.nrProcRet = :nrProcRet",
                ProcessoRetencao.class);
        query.setParameter("nrProcRet", nrProcRet);
        return query.getResultList();
    }

    @Override
    public List<ProcessoRetencao> findByTpProcRet(Integer tpProcRet) {
        TypedQuery<ProcessoRetencao> query = entityManager.createQuery(
                "SELECT p FROM ProcessoRetencao p WHERE p.tpProcRet = :tpProcRet",
                ProcessoRetencao.class);
        query.setParameter("tpProcRet", tpProcRet);
        return query.getResultList();
    }

    @Override
    public List<ProcessoRetencao> findByCodSusp(String codSusp) {
        TypedQuery<ProcessoRetencao> query = entityManager.createQuery(
                "SELECT p FROM ProcessoRetencao p WHERE p.codSusp = :codSusp",
                ProcessoRetencao.class);
        query.setParameter("codSusp", codSusp);
        return query.getResultList();
    }
}