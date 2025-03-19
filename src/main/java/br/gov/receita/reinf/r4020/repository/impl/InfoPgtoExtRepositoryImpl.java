package br.gov.receita.reinf.r4020.repository.impl;

import br.gov.receita.reinf.r4020.entity.InfoPgtoExt;
import br.gov.receita.reinf.r4020.repository.InfoPgtoExtRepository;
import br.gov.receita.reinf.repository.impl.AbstractRepository;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the InfoPgtoExtRepository interface.
 */
@Stateless
public class InfoPgtoExtRepositoryImpl extends AbstractRepository<InfoPgtoExt, Long> implements InfoPgtoExtRepository {

    /**
     * Constructor.
     */
    public InfoPgtoExtRepositoryImpl() {
        super(InfoPgtoExt.class);
    }

    @Override
    public List<InfoPgtoExt> findByIndNIF(Integer indNIF) {
        TypedQuery<InfoPgtoExt> query = entityManager.createQuery(
                "SELECT i FROM InfoPgtoExt i WHERE i.indNIF = :indNIF", InfoPgtoExt.class);
        query.setParameter("indNIF", indNIF);
        return query.getResultList();
    }

    @Override
    public Optional<InfoPgtoExt> findByNifBenef(String nifBenef) {
        TypedQuery<InfoPgtoExt> query = entityManager.createQuery(
                "SELECT i FROM InfoPgtoExt i WHERE i.nifBenef = :nifBenef", InfoPgtoExt.class);
        query.setParameter("nifBenef", nifBenef);
        
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<InfoPgtoExt> findByRelFontPg(String relFontPg) {
        TypedQuery<InfoPgtoExt> query = entityManager.createQuery(
                "SELECT i FROM InfoPgtoExt i WHERE i.relFontPg = :relFontPg", InfoPgtoExt.class);
        query.setParameter("relFontPg", relFontPg);
        return query.getResultList();
    }
}