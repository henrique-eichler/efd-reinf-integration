package br.gov.receita.reinf.r4040.repository.impl;

import br.gov.receita.reinf.r4040.entity.Estabelecimento;
import br.gov.receita.reinf.r4040.repository.EstabelecimentoRepository;
import br.gov.receita.reinf.repository.impl.AbstractRepository;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

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
    public List<Estabelecimento> findByNrInscEstab(String nrInscEstab) {
        TypedQuery<Estabelecimento> query = entityManager.createQuery(
                "SELECT e FROM EstabelecimentoR4040 e WHERE e.nrInscEstab = :nrInscEstab",
                Estabelecimento.class);
        query.setParameter("nrInscEstab", nrInscEstab);
        return query.getResultList();
    }

    @Override
    public List<Estabelecimento> findByTpInscEstab(Integer tpInscEstab) {
        TypedQuery<Estabelecimento> query = entityManager.createQuery(
                "SELECT e FROM EstabelecimentoR4040 e WHERE e.tpInscEstab = :tpInscEstab",
                Estabelecimento.class);
        query.setParameter("tpInscEstab", tpInscEstab);
        return query.getResultList();
    }
}
