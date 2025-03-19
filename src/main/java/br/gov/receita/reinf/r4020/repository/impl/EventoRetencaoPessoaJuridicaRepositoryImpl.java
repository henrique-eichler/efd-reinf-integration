package br.gov.receita.reinf.r4020.repository.impl;

import br.gov.receita.reinf.r4020.entity.EventoRetencaoPessoaJuridica;
import br.gov.receita.reinf.r4020.repository.EventoRetencaoPessoaJuridicaRepository;
import br.gov.receita.reinf.repository.impl.AbstractRepository;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the EventoRetencaoPessoaJuridicaRepository interface.
 */
@Stateless
public class EventoRetencaoPessoaJuridicaRepositoryImpl extends AbstractRepository<EventoRetencaoPessoaJuridica, Long> implements EventoRetencaoPessoaJuridicaRepository {

    /**
     * Constructor.
     */
    public EventoRetencaoPessoaJuridicaRepositoryImpl() {
        super(EventoRetencaoPessoaJuridica.class);
    }

    @Override
    public Optional<EventoRetencaoPessoaJuridica> findByIdEvento(String idEvento) {
        TypedQuery<EventoRetencaoPessoaJuridica> query = entityManager.createQuery(
                "SELECT e FROM EventoRetencaoPessoaJuridica e WHERE e.idEvento = :idEvento", EventoRetencaoPessoaJuridica.class);
        query.setParameter("idEvento", idEvento);
        
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<EventoRetencaoPessoaJuridica> findByContribuinteNrInsc(String nrInsc) {
        TypedQuery<EventoRetencaoPessoaJuridica> query = entityManager.createQuery(
                "SELECT e FROM EventoRetencaoPessoaJuridica e WHERE e.contribuinte.nrInsc = :nrInsc", EventoRetencaoPessoaJuridica.class);
        query.setParameter("nrInsc", nrInsc);
        return query.getResultList();
    }

    @Override
    public List<EventoRetencaoPessoaJuridica> findByPerApur(YearMonth perApur) {
        TypedQuery<EventoRetencaoPessoaJuridica> query = entityManager.createQuery(
                "SELECT e FROM EventoRetencaoPessoaJuridica e WHERE e.perApur = :perApur", EventoRetencaoPessoaJuridica.class);
        query.setParameter("perApur", perApur);
        return query.getResultList();
    }
}