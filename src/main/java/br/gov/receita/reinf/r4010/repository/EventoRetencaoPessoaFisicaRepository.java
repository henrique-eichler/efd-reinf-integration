package br.gov.receita.reinf.r4010.repository;

import br.gov.receita.reinf.r4010.entity.EventoRetencaoPessoaFisica;
import br.gov.receita.reinf.repository.Repository;

import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for EventoRetencaoPessoaFisica entity.
 */
public interface EventoRetencaoPessoaFisicaRepository extends Repository<EventoRetencaoPessoaFisica, Long> {

    /**
     * Finds an evento by its unique identifier.
     *
     * @param idEvento the unique identifier of the evento
     * @return an Optional containing the evento if found, or empty if not found
     */
    Optional<EventoRetencaoPessoaFisica> findByIdEvento(String idEvento);

    /**
     * Finds eventos by the contribuinte's inscription number.
     *
     * @param nrInsc the inscription number of the contribuinte
     * @return a list of eventos for the given contribuinte
     */
    List<EventoRetencaoPessoaFisica> findByContribuinteNrInsc(String nrInsc);

    /**
     * Finds eventos for a specific period.
     *
     * @param perApur the period of apuration
     * @return a list of eventos for the given period
     */
    List<EventoRetencaoPessoaFisica> findByPerApur(YearMonth perApur);
}