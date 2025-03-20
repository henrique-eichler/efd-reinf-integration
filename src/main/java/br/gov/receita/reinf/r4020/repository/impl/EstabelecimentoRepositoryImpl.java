package br.gov.receita.reinf.r4020.repository.impl;

import br.gov.receita.reinf.r4020.entity.Estabelecimento;
import br.gov.receita.reinf.r4020.repository.EstabelecimentoRepository;
import br.gov.receita.reinf.repository.impl.AbstractRepository;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Optional;

/**
 * Implementation of the EstabelecimentoRepository interface.
 */
@Stateless
public class EstabelecimentoRepositoryImpl extends AbstractRepository<Estabelecimento, Long> implements EstabelecimentoRepository {

    /**
     * Constructor.
     */
    public EstabelecimentoRepositoryImpl() {
        super(Estabelecimento.class);
    }

    @Override
    public Optional<Estabelecimento> findByNrInscEstab(String nrInscEstab) {
        TypedQuery<Estabelecimento> query = entityManager.createQuery(
                "SELECT e FROM EstabelecimentoR4020 e WHERE e.nrInscEstab = :nrInscEstab", Estabelecimento.class);
        query.setParameter("nrInscEstab", nrInscEstab);

        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Estabelecimento> findByTpInscEstabAndNrInscEstab(Integer tpInscEstab, String nrInscEstab) {
        TypedQuery<Estabelecimento> query = entityManager.createQuery(
                "SELECT e FROM EstabelecimentoR4020 e WHERE e.tpInscEstab = :tpInscEstab AND e.nrInscEstab = :nrInscEstab", Estabelecimento.class);
        query.setParameter("tpInscEstab", tpInscEstab);
        query.setParameter("nrInscEstab", nrInscEstab);

        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
