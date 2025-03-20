package br.gov.receita.reinf.r4040.repository.impl;

import br.gov.receita.reinf.r4040.entity.NaturezaRendimento;
import br.gov.receita.reinf.r4040.repository.NaturezaRendimentoRepository;
import br.gov.receita.reinf.repository.impl.AbstractRepository;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Implementation of the NaturezaRendimentoRepository interface.
 */
@Stateless
public class NaturezaRendimentoRepositoryImpl extends AbstractRepository<NaturezaRendimento, Long> implements NaturezaRendimentoRepository {

    /**
     * Constructor.
     */
    public NaturezaRendimentoRepositoryImpl() {
        super(NaturezaRendimento.class);
    }

    @Override
    public List<NaturezaRendimento> findByNatRend(String natRend) {
        TypedQuery<NaturezaRendimento> query = entityManager.createQuery(
                "SELECT n FROM NaturezaRendimento n WHERE n.natRend = :natRend",
                NaturezaRendimento.class);
        query.setParameter("natRend", natRend);
        return query.getResultList();
    }
}