package br.gov.receita.reinf.r4010.repository.impl;

import br.gov.receita.reinf.r4010.entity.Dependente;
import br.gov.receita.reinf.r4010.repository.DependenteRepository;
import br.gov.receita.reinf.repository.impl.AbstractRepository;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the DependenteRepository interface.
 */
@Stateless
public class DependenteRepositoryImpl extends AbstractRepository<Dependente, Long> implements DependenteRepository {

    /**
     * Constructor.
     */
    public DependenteRepositoryImpl() {
        super(Dependente.class);
    }

    @Override
    public Optional<Dependente> findByCpfDep(String cpfDep) {
        TypedQuery<Dependente> query = entityManager.createQuery(
                "SELECT d FROM Dependente d WHERE d.cpfDep = :cpfDep", Dependente.class);
        query.setParameter("cpfDep", cpfDep);
        
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Dependente> findByRelDep(Integer relDep) {
        TypedQuery<Dependente> query = entityManager.createQuery(
                "SELECT d FROM Dependente d WHERE d.relDep = :relDep", Dependente.class);
        query.setParameter("relDep", relDep);
        return query.getResultList();
    }
}