package br.gov.receita.reinf.r4040.repository.impl;

import br.gov.receita.reinf.r4040.entity.Pagamento;
import br.gov.receita.reinf.r4040.repository.PagamentoRepository;
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
    public List<Pagamento> findByDtFG(LocalDate dtFG) {
        TypedQuery<Pagamento> query = entityManager.createQuery(
                "SELECT p FROM PagamentoR4040 p WHERE p.dtFG = :dtFG",
                Pagamento.class);
        query.setParameter("dtFG", dtFG);
        return query.getResultList();
    }

    @Override
    public List<Pagamento> findByDtEscrCont(LocalDate dtEscrCont) {
        TypedQuery<Pagamento> query = entityManager.createQuery(
                "SELECT p FROM PagamentoR4040 p WHERE p.dtEscrCont = :dtEscrCont",
                Pagamento.class);
        query.setParameter("dtEscrCont", dtEscrCont);
        return query.getResultList();
    }

    @Override
    public List<Pagamento> findByVlrBaseIRGreaterThanEqual(BigDecimal vlrBaseIR) {
        TypedQuery<Pagamento> query = entityManager.createQuery(
                "SELECT p FROM PagamentoR4040 p WHERE p.vlrBaseIR >= :vlrBaseIR",
                Pagamento.class);
        query.setParameter("vlrBaseIR", vlrBaseIR);
        return query.getResultList();
    }
}
