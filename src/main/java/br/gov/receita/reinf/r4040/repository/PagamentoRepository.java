package br.gov.receita.reinf.r4040.repository;

import br.gov.receita.reinf.r4040.entity.Pagamento;
import br.gov.receita.reinf.repository.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Repository interface for Pagamento entity.
 */
public interface PagamentoRepository extends Repository<Pagamento, Long> {

    /**
     * Find payments by payment date.
     *
     * @param dtFG the payment date
     * @return list of payments
     */
    List<Pagamento> findByDtFG(LocalDate dtFG);

    /**
     * Find payments by accounting entry date.
     *
     * @param dtEscrCont the accounting entry date
     * @return list of payments
     */
    List<Pagamento> findByDtEscrCont(LocalDate dtEscrCont);

    /**
     * Find payments by IR base value greater than or equal to the specified value.
     *
     * @param vlrBaseIR the IR base value
     * @return list of payments
     */
    List<Pagamento> findByVlrBaseIRGreaterThanEqual(BigDecimal vlrBaseIR);
}