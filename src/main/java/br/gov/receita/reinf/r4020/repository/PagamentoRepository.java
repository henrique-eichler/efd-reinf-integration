package br.gov.receita.reinf.r4020.repository;

import br.gov.receita.reinf.r4020.entity.Pagamento;
import br.gov.receita.reinf.repository.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository interface for Pagamento entity.
 */
public interface PagamentoRepository extends Repository<Pagamento, Long> {

    /**
     * Finds pagamentos by the nature of the income.
     *
     * @param natRend the nature of the income
     * @return a list of pagamentos with the given nature of income
     */
    List<Pagamento> findByNatRend(String natRend);

    /**
     * Finds pagamentos by the payment date.
     *
     * @param dtFG the payment date
     * @return a list of pagamentos with the given payment date
     */
    List<Pagamento> findByDtFG(LocalDate dtFG);

    /**
     * Finds pagamentos by the nature of the income and payment date.
     *
     * @param natRend the nature of the income
     * @param dtFG the payment date
     * @return a list of pagamentos with the given nature of income and payment date
     */
    List<Pagamento> findByNatRendAndDtFG(String natRend, LocalDate dtFG);
}