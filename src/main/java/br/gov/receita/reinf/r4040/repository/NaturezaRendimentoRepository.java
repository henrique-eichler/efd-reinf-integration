package br.gov.receita.reinf.r4040.repository;

import br.gov.receita.reinf.r4040.entity.NaturezaRendimento;
import br.gov.receita.reinf.repository.Repository;

import java.util.List;

/**
 * Repository interface for NaturezaRendimento entity.
 */
public interface NaturezaRendimentoRepository extends Repository<NaturezaRendimento, Long> {

    /**
     * Find income natures by code.
     *
     * @param natRend the income nature code
     * @return list of income natures
     */
    List<NaturezaRendimento> findByNatRend(String natRend);
}