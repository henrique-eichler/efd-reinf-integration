package br.gov.receita.reinf.r4040.repository;

import br.gov.receita.reinf.r4040.entity.Estabelecimento;
import br.gov.receita.reinf.repository.Repository;

import java.util.List;

/**
 * Repository interface for Estabelecimento entity.
 */
public interface EstabelecimentoRepository extends Repository<Estabelecimento, Long> {

    /**
     * Find establishments by registration number.
     *
     * @param nrInscEstab the establishment registration number
     * @return list of establishments
     */
    List<Estabelecimento> findByNrInscEstab(String nrInscEstab);

    /**
     * Find establishments by registration type.
     *
     * @param tpInscEstab the establishment registration type
     * @return list of establishments
     */
    List<Estabelecimento> findByTpInscEstab(Integer tpInscEstab);
}