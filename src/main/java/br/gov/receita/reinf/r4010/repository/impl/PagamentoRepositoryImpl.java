package br.gov.receita.reinf.r4010.repository.impl;

import br.gov.receita.reinf.r4010.entity.Pagamento;
import br.gov.receita.reinf.r4010.repository.PagamentoRepository;
import br.gov.receita.reinf.repository.impl.AbstractRepository;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Implementation of the PagamentoRepository interface.
 */
@Stateless
public class PagamentoRepositoryImpl extends AbstractRepository<Pagamento, Long> implements PagamentoRepository {

    /**
     * Constructor.
     */
    public PagamentoRepositoryImpl() {
        super(Pagamento.class);
    }

    @Override
    public List<Pagamento> findByNatRend(Integer natRend) {
        TypedQuery<Pagamento> query = entityManager.createQuery(
                "SELECT p FROM Pagamento p WHERE p.natRend = :natRend", Pagamento.class);
        query.setParameter("natRend", natRend);
        return query.getResultList();
    }

    @Override
    public List<Pagamento> findByDtFG(LocalDate dtFG) {
        TypedQuery<Pagamento> query = entityManager.createQuery(
                "SELECT p FROM Pagamento p WHERE p.dtFG = :dtFG", Pagamento.class);
        query.setParameter("dtFG", dtFG);
        return query.getResultList();
    }

    @Override
    public List<Pagamento> findByVlrRendBrutoGreaterThan(BigDecimal vlrRendBruto) {
        TypedQuery<Pagamento> query = entityManager.createQuery(
                "SELECT p FROM Pagamento p WHERE p.vlrRendBruto > :vlrRendBruto", Pagamento.class);
        query.setParameter("vlrRendBruto", vlrRendBruto);
        return query.getResultList();
    }
}