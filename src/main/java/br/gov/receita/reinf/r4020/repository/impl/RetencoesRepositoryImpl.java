package br.gov.receita.reinf.r4020.repository.impl;

import br.gov.receita.reinf.r4020.entity.Retencoes;
import br.gov.receita.reinf.r4020.repository.RetencoesRepository;
import br.gov.receita.reinf.repository.impl.AbstractRepository;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

/**
 * Implementation of the RetencoesRepository interface.
 */
@Stateless
public class RetencoesRepositoryImpl extends AbstractRepository<Retencoes, Long> implements RetencoesRepository {

    /**
     * Constructor.
     */
    public RetencoesRepositoryImpl() {
        super(Retencoes.class);
    }

    @Override
    public List<Retencoes> findByVlrBaseIR(BigDecimal vlrBaseIR) {
        TypedQuery<Retencoes> query = entityManager.createQuery(
                "SELECT r FROM Retencoes r WHERE r.vlrBaseIR = :vlrBaseIR", Retencoes.class);
        query.setParameter("vlrBaseIR", vlrBaseIR);
        return query.getResultList();
    }

    @Override
    public List<Retencoes> findByVlrIR(BigDecimal vlrIR) {
        TypedQuery<Retencoes> query = entityManager.createQuery(
                "SELECT r FROM Retencoes r WHERE r.vlrIR = :vlrIR", Retencoes.class);
        query.setParameter("vlrIR", vlrIR);
        return query.getResultList();
    }

    @Override
    public List<Retencoes> findByVlrBaseCSLL(BigDecimal vlrBaseCSLL) {
        TypedQuery<Retencoes> query = entityManager.createQuery(
                "SELECT r FROM Retencoes r WHERE r.vlrBaseCSLL = :vlrBaseCSLL", Retencoes.class);
        query.setParameter("vlrBaseCSLL", vlrBaseCSLL);
        return query.getResultList();
    }

    @Override
    public List<Retencoes> findByVlrCSLL(BigDecimal vlrCSLL) {
        TypedQuery<Retencoes> query = entityManager.createQuery(
                "SELECT r FROM Retencoes r WHERE r.vlrCSLL = :vlrCSLL", Retencoes.class);
        query.setParameter("vlrCSLL", vlrCSLL);
        return query.getResultList();
    }
}