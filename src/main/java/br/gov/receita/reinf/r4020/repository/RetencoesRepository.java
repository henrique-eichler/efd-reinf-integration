package br.gov.receita.reinf.r4020.repository;

import br.gov.receita.reinf.r4020.entity.Retencoes;
import br.gov.receita.reinf.repository.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Repository interface for Retencoes entity.
 */
public interface RetencoesRepository extends Repository<Retencoes, Long> {

    /**
     * Finds Retencoes entities by IR base value.
     *
     * @param vlrBaseIR the IR base value
     * @return a list of Retencoes entities with the given IR base value
     */
    List<Retencoes> findByVlrBaseIR(BigDecimal vlrBaseIR);

    /**
     * Finds Retencoes entities by IR value.
     *
     * @param vlrIR the IR value
     * @return a list of Retencoes entities with the given IR value
     */
    List<Retencoes> findByVlrIR(BigDecimal vlrIR);

    /**
     * Finds Retencoes entities by CSLL base value.
     *
     * @param vlrBaseCSLL the CSLL base value
     * @return a list of Retencoes entities with the given CSLL base value
     */
    List<Retencoes> findByVlrBaseCSLL(BigDecimal vlrBaseCSLL);

    /**
     * Finds Retencoes entities by CSLL value.
     *
     * @param vlrCSLL the CSLL value
     * @return a list of Retencoes entities with the given CSLL value
     */
    List<Retencoes> findByVlrCSLL(BigDecimal vlrCSLL);
}