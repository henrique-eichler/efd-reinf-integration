package br.gov.receita.reinf.r4010.repository;

import br.gov.receita.reinf.r4010.entity.Deducao;
import br.gov.receita.reinf.repository.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Repository interface for Deducao entity.
 */
public interface DeducaoRepository extends Repository<Deducao, Long> {

    /**
     * Finds deducoes by type.
     *
     * @param indTpDeducao the type of deducao
     * @return a list of deducoes of the given type
     */
    List<Deducao> findByIndTpDeducao(Integer indTpDeducao);

    /**
     * Finds deducoes with value greater than the specified amount.
     *
     * @param vlrDeducao the minimum value of deducao
     * @return a list of deducoes with value greater than the specified amount
     */
    List<Deducao> findByVlrDeducaoGreaterThan(BigDecimal vlrDeducao);
}
