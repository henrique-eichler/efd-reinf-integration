package br.gov.receita.reinf.r4010.repository;

import br.gov.receita.reinf.r4010.entity.Pagamento;
import br.gov.receita.reinf.repository.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Repository interface for Pagamento entity.
 */
public interface PagamentoRepository extends Repository<Pagamento, Long> {

    /**
     * Finds pagamentos by nature of income.
     *
     * @param natRend the nature of income
     * @return a list of pagamentos with the given nature of income
     */
    List<Pagamento> findByNatRend(Integer natRend);

    /**
     * Finds pagamentos by date of payment.
     *
     * @param dtFG the date of payment
     * @return a list of pagamentos with the given date of payment
     */
    List<Pagamento> findByDtFG(LocalDate dtFG);

    /**
     * Finds pagamentos with value greater than the specified amount.
     *
     * @param vlrRendBruto the minimum value of pagamento
     * @return a list of pagamentos with value greater than the specified amount
     */
    List<Pagamento> findByVlrRendBrutoGreaterThan(BigDecimal vlrRendBruto);
}