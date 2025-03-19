package br.gov.receita.reinf.r4020.repository.impl;

import br.gov.receita.reinf.r4020.entity.IdeAdv;
import br.gov.receita.reinf.r4020.repository.IdeAdvRepository;
import br.gov.receita.reinf.repository.impl.AbstractRepository;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the IdeAdvRepository interface.
 */
@Stateless
public class IdeAdvRepositoryImpl extends AbstractRepository<IdeAdv, Long> implements IdeAdvRepository {

    /**
     * Constructor.
     */
    public IdeAdvRepositoryImpl() {
        super(IdeAdv.class);
    }

    @Override
    public Optional<IdeAdv> findByNrInscAdv(String nrInscAdv) {
        TypedQuery<IdeAdv> query = entityManager.createQuery(
                "SELECT i FROM IdeAdv i WHERE i.nrInscAdv = :nrInscAdv", IdeAdv.class);
        query.setParameter("nrInscAdv", nrInscAdv);
        
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<IdeAdv> findByTpInscAdv(Integer tpInscAdv) {
        TypedQuery<IdeAdv> query = entityManager.createQuery(
                "SELECT i FROM IdeAdv i WHERE i.tpInscAdv = :tpInscAdv", IdeAdv.class);
        query.setParameter("tpInscAdv", tpInscAdv);
        return query.getResultList();
    }
}