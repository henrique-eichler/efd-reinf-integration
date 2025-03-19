package br.gov.receita.reinf.r4020.repository.impl;

import br.gov.receita.reinf.r4020.entity.InfoProcRet;
import br.gov.receita.reinf.r4020.repository.InfoProcRetRepository;
import br.gov.receita.reinf.repository.impl.AbstractRepository;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the InfoProcRetRepository interface.
 */
@Stateless
public class InfoProcRetRepositoryImpl extends AbstractRepository<InfoProcRet, Long> implements InfoProcRetRepository {

    /**
     * Constructor.
     */
    public InfoProcRetRepositoryImpl() {
        super(InfoProcRet.class);
    }

    @Override
    public List<InfoProcRet> findByTpProcRet(Integer tpProcRet) {
        TypedQuery<InfoProcRet> query = entityManager.createQuery(
                "SELECT i FROM InfoProcRet i WHERE i.tpProcRet = :tpProcRet", InfoProcRet.class);
        query.setParameter("tpProcRet", tpProcRet);
        return query.getResultList();
    }

    @Override
    public Optional<InfoProcRet> findByNrProcRet(String nrProcRet) {
        TypedQuery<InfoProcRet> query = entityManager.createQuery(
                "SELECT i FROM InfoProcRet i WHERE i.nrProcRet = :nrProcRet", InfoProcRet.class);
        query.setParameter("nrProcRet", nrProcRet);
        
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<InfoProcRet> findByCodSusp(String codSusp) {
        TypedQuery<InfoProcRet> query = entityManager.createQuery(
                "SELECT i FROM InfoProcRet i WHERE i.codSusp = :codSusp", InfoProcRet.class);
        query.setParameter("codSusp", codSusp);
        return query.getResultList();
    }
}