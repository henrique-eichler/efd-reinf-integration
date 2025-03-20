package br.gov.receita.reinf.r4040.repository;

import br.gov.receita.reinf.r4040.entity.EventoRetencaoBeneficiarioNaoIdentificado;
import br.gov.receita.reinf.repository.Repository;

import java.time.YearMonth;
import java.util.List;

/**
 * Repository interface for EventoRetencaoBeneficiarioNaoIdentificado entity.
 */
public interface EventoRetencaoBeneficiarioNaoIdentificadoRepository extends Repository<EventoRetencaoBeneficiarioNaoIdentificado, Long> {

    /**
     * Find events by period.
     *
     * @param perApur the period
     * @return list of events
     */
    List<EventoRetencaoBeneficiarioNaoIdentificado> findByPerApur(YearMonth perApur);

    /**
     * Find events by contributor registration number.
     *
     * @param nrInsc the contributor registration number
     * @return list of events
     */
    List<EventoRetencaoBeneficiarioNaoIdentificado> findByContribuinteNrInsc(String nrInsc);
}