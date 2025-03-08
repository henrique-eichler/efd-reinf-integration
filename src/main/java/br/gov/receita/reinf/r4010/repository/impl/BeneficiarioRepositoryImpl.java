package br.gov.receita.reinf.r4010.repository.impl;

import br.gov.receita.reinf.r4010.entity.Beneficiario;
import br.gov.receita.reinf.r4010.repository.BeneficiarioRepository;
import br.gov.receita.reinf.repository.impl.AbstractRepository;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
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
    public Optional<Beneficiario> findByCpf(String cpf) {
        TypedQuery<Beneficiario> query = entityManager.createQuery(
                "SELECT b FROM Beneficiario b WHERE b.cpfBenef = :cpf", Beneficiario.class);
        query.setParameter("cpf", cpf);
        
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}