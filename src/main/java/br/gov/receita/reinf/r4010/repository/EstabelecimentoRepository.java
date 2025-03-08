package br.gov.receita.reinf.r4010.repository;

import br.gov.receita.reinf.r4010.entity.Estabelecimento;
import br.gov.receita.reinf.repository.Repository;

import java.util.Optional;

/**
 * Repository interface for Estabelecimento entity.
 */
public interface EstabelecimentoRepository extends Repository<Estabelecimento, Long> {

    /**
     * Finds an estabelecimento by CNPJ.
     *
     * @param nrInscEstab the CNPJ of the estabelecimento
     * @return an Optional containing the estabelecimento if found, or empty if not found
     */
    Optional<Estabelecimento> findByNrInscEstab(String nrInscEstab);
}
