package br.gov.receita.reinf.r4020.repository.impl;

import br.gov.receita.reinf.r4020.entity.InfoProcJud;
import br.gov.receita.reinf.r4020.repository.InfoProcJudRepository;
import br.gov.receita.reinf.repository.impl.AbstractRepository;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the InfoProcJudRepository interface.
 */
@Stateless
public class InfoProcJudRepositoryImpl extends AbstractRepository<InfoProcJud, Long> implements InfoProcJudRepository {

    /**
     * Constructor.
     */
    public InfoProcJudRepositoryImpl() {
        super(InfoProcJud.class);
    }

    @Override
    public Optional<InfoProcJud> findByNrProc(String nrProc) {
        TypedQuery<InfoProcJud> query = entityManager.createQuery(
                "SELECT i FROM InfoProcJud i WHERE i.nrProc = :nrProc", InfoProcJud.class);
        query.setParameter("nrProc", nrProc);
        
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<InfoProcJud> findByIndOrigRec(Integer indOrigRec) {
        TypedQuery<InfoProcJud> query = entityManager.createQuery(
                "SELECT i FROM InfoProcJud i WHERE i.indOrigRec = :indOrigRec", InfoProcJud.class);
        query.setParameter("indOrigRec", indOrigRec);
        return query.getResultList();
    }

    @Override
    public List<InfoProcJud> findByCnpjOrigRecurso(String cnpjOrigRecurso) {
        TypedQuery<InfoProcJud> query = entityManager.createQuery(
                "SELECT i FROM InfoProcJud i WHERE i.cnpjOrigRecurso = :cnpjOrigRecurso", InfoProcJud.class);
        query.setParameter("cnpjOrigRecurso", cnpjOrigRecurso);
        return query.getResultList();
    }
}