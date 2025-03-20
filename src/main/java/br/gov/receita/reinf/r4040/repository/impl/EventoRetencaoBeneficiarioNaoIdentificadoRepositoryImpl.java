package br.gov.receita.reinf.r4040.repository.impl;

import br.gov.receita.reinf.r4040.entity.EventoRetencaoBeneficiarioNaoIdentificado;
import br.gov.receita.reinf.r4040.repository.EventoRetencaoBeneficiarioNaoIdentificadoRepository;
import br.gov.receita.reinf.repository.impl.AbstractRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.YearMonth;
import java.util.List;

/**
 * Implementation of the EventoRetencaoBeneficiarioNaoIdentificadoRepository interface.
 */
@Stateless
public class EventoRetencaoBeneficiarioNaoIdentificadoRepositoryImpl extends AbstractRepository<EventoRetencaoBeneficiarioNaoIdentificado, Long> implements EventoRetencaoBeneficiarioNaoIdentificadoRepository {

    /**
     * Constructor.
     */
    public EventoRetencaoBeneficiarioNaoIdentificadoRepositoryImpl() {
        super(EventoRetencaoBeneficiarioNaoIdentificado.class);
    }

    @Override
    public List<EventoRetencaoBeneficiarioNaoIdentificado> findByPerApur(YearMonth perApur) {
        TypedQuery<EventoRetencaoBeneficiarioNaoIdentificado> query = entityManager.createQuery(
                "SELECT e FROM EventoRetencaoBeneficiarioNaoIdentificado e WHERE e.perApur = :perApur",
                EventoRetencaoBeneficiarioNaoIdentificado.class);
        query.setParameter("perApur", perApur);
        return query.getResultList();
    }

    @Override
    public List<EventoRetencaoBeneficiarioNaoIdentificado> findByContribuinteNrInsc(String nrInsc) {
        TypedQuery<EventoRetencaoBeneficiarioNaoIdentificado> query = entityManager.createQuery(
                "SELECT e FROM EventoRetencaoBeneficiarioNaoIdentificado e WHERE e.contribuinte.nrInsc = :nrInsc",
                EventoRetencaoBeneficiarioNaoIdentificado.class);
        query.setParameter("nrInsc", nrInsc);
        return query.getResultList();
    }
}
