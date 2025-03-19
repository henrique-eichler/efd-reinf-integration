package br.gov.receita.reinf.r4020.repository;

import br.gov.receita.reinf.r4020.entity.Estabelecimento;
import br.gov.receita.reinf.repository.Repository;

import java.util.Optional;

/**
 * Repository interface for Estabelecimento entity.
 */
public interface EstabelecimentoRepository extends Repository<Estabelecimento, Long> {

    /**
     * Finds an estabelecimento by its inscription number.
     *
     * @param nrInscEstab the inscription number of the estabelecimento
     * @return an Optional containing the estabelecimento if found, or empty if not found
     */
    Optional<Estabelecimento> findByNrInscEstab(String nrInscEstab);

    /**
     * Finds an estabelecimento by its type and inscription number.
     *
     * @param tpInscEstab the type of inscription of the estabelecimento
     * @param nrInscEstab the inscription number of the estabelecimento
     * @return an Optional containing the estabelecimento if found, or empty if not found
     */
    Optional<Estabelecimento> findByTpInscEstabAndNrInscEstab(Integer tpInscEstab, String nrInscEstab);
}