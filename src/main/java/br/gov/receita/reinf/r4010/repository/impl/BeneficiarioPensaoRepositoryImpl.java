package br.gov.receita.reinf.r4010.repository.impl;

import br.gov.receita.reinf.r4010.entity.BeneficiarioPensao;
import br.gov.receita.reinf.r4010.repository.BeneficiarioPensaoRepository;
import br.gov.receita.reinf.repository.impl.AbstractRepository;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Optional;

/**
 * Implementation of the BeneficiarioPensaoRepository interface.
 */
@Stateless
public class BeneficiarioPensaoRepositoryImpl extends AbstractRepository<BeneficiarioPensao, Long> implements BeneficiarioPensaoRepository {

    /**
     * Constructor.
     */
    public BeneficiarioPensaoRepositoryImpl() {
        super(BeneficiarioPensao.class);
    }

    @Override
    public Optional<BeneficiarioPensao> findByCpf(String cpf) {
        TypedQuery<BeneficiarioPensao> query = entityManager.createQuery(
                "SELECT b FROM BeneficiarioPensao b WHERE b.cpfDep = :cpf", BeneficiarioPensao.class);
        query.setParameter("cpf", cpf);
        
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}