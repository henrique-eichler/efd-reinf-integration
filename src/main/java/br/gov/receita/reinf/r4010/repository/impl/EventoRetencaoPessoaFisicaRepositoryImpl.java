package br.gov.receita.reinf.r4010.repository.impl;

import br.gov.receita.reinf.r4010.entity.EventoRetencaoPessoaFisica;
import br.gov.receita.reinf.r4010.repository.EventoRetencaoPessoaFisicaRepository;
import br.gov.receita.reinf.repository.impl.AbstractRepository;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the EventoRetencaoPessoaFisicaRepository interface.
 */
@Stateless
public class EventoRetencaoPessoaFisicaRepositoryImpl extends AbstractRepository<EventoRetencaoPessoaFisica, Long> implements EventoRetencaoPessoaFisicaRepository {

    /**
     * Constructor.
     */
    public EventoRetencaoPessoaFisicaRepositoryImpl() {
        super(EventoRetencaoPessoaFisica.class);
    }

    @Override
    public Optional<EventoRetencaoPessoaFisica> findByIdEvento(String idEvento) {
        TypedQuery<EventoRetencaoPessoaFisica> query = entityManager.createQuery(
                "SELECT e FROM EventoRetencaoPessoaFisica e WHERE e.idEvento = :idEvento", EventoRetencaoPessoaFisica.class);
        query.setParameter("idEvento", idEvento);
        
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<EventoRetencaoPessoaFisica> findByContribuinteNrInsc(String nrInsc) {
        TypedQuery<EventoRetencaoPessoaFisica> query = entityManager.createQuery(
                "SELECT e FROM EventoRetencaoPessoaFisica e WHERE e.contribuinte.nrInsc = :nrInsc", EventoRetencaoPessoaFisica.class);
        query.setParameter("nrInsc", nrInsc);
        return query.getResultList();
    }

    @Override
    public List<EventoRetencaoPessoaFisica> findByPerApur(YearMonth perApur) {
        TypedQuery<EventoRetencaoPessoaFisica> query = entityManager.createQuery(
                "SELECT e FROM EventoRetencaoPessoaFisica e WHERE e.perApur = :perApur", EventoRetencaoPessoaFisica.class);
        query.setParameter("perApur", perApur);
        return query.getResultList();
    }
}