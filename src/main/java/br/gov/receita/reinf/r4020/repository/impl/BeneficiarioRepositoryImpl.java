package br.gov.receita.reinf.r4020.repository.impl;

import br.gov.receita.reinf.r4020.entity.Beneficiario;
import br.gov.receita.reinf.r4020.repository.BeneficiarioRepository;
import br.gov.receita.reinf.repository.impl.AbstractRepository;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the BeneficiarioRepository interface.
 */
@Stateless
public class BeneficiarioRepositoryImpl extends AbstractRepository<Beneficiario, Long> implements BeneficiarioRepository {

    /**
     * Constructor.
     */
    public BeneficiarioRepositoryImpl() {
        super(Beneficiario.class);
    }

    @Override
    public Optional<Beneficiario> findByCnpjBenef(String cnpjBenef) {
        TypedQuery<Beneficiario> query = entityManager.createQuery(
                "SELECT b FROM Beneficiario b WHERE b.cnpjBenef = :cnpjBenef", Beneficiario.class);
        query.setParameter("cnpjBenef", cnpjBenef);
        
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Beneficiario> findByNmBenef(String nmBenef) {
        TypedQuery<Beneficiario> query = entityManager.createQuery(
                "SELECT b FROM Beneficiario b WHERE b.nmBenef = :nmBenef", Beneficiario.class);
        query.setParameter("nmBenef", nmBenef);
        return query.getResultList();
    }
}