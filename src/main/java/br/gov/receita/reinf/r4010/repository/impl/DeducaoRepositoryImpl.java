package br.gov.receita.reinf.r4010.repository.impl;

import br.gov.receita.reinf.r4010.entity.Deducao;
import br.gov.receita.reinf.r4010.repository.DeducaoRepository;
import br.gov.receita.reinf.repository.impl.AbstractRepository;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

/**
 * Implementation of the DeducaoRepository interface.
 */
@Stateless
public class DeducaoRepositoryImpl extends AbstractRepository<Deducao, Long> implements DeducaoRepository {

    /**
     * Constructor.
     */
    public DeducaoRepositoryImpl() {
        super(Deducao.class);
    }

    @Override
    public List<Deducao> findByIndTpDeducao(Integer indTpDeducao) {
        TypedQuery<Deducao> query = entityManager.createQuery(
                "SELECT d FROM Deducao d WHERE d.indTpDeducao = :indTpDeducao", Deducao.class);
        query.setParameter("indTpDeducao", indTpDeducao);
        return query.getResultList();
    }

    @Override
    public List<Deducao> findByVlrDeducaoGreaterThan(BigDecimal vlrDeducao) {
        TypedQuery<Deducao> query = entityManager.createQuery(
                "SELECT d FROM Deducao d WHERE d.vlrDeducao > :vlrDeducao", Deducao.class);
        query.setParameter("vlrDeducao", vlrDeducao);
        return query.getResultList();
    }
}