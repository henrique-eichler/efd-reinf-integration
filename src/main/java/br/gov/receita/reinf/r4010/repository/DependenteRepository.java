package br.gov.receita.reinf.r4010.repository;

import br.gov.receita.reinf.r4010.entity.Dependente;
import br.gov.receita.reinf.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Dependente entity.
 */
public interface DependenteRepository extends Repository<Dependente, Long> {

    /**
     * Finds a dependente by CPF.
     *
     * @param cpfDep the CPF of the dependente
     * @return an Optional containing the dependente if found, or empty if not found
     */
    Optional<Dependente> findByCpfDep(String cpfDep);

    /**
     * Finds dependentes by type of relationship.
     *
     * @param relDep the type of relationship
     * @return a list of dependentes with the given type of relationship
     */
    List<Dependente> findByRelDep(Integer relDep);
}
