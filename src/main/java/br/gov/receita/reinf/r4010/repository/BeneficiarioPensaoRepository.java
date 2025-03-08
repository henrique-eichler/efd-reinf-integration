package br.gov.receita.reinf.r4010.repository;

import br.gov.receita.reinf.r4010.entity.BeneficiarioPensao;
import br.gov.receita.reinf.repository.Repository;

import java.util.Optional;

/**
 * Repository interface for BeneficiarioPensao entity.
 */
public interface BeneficiarioPensaoRepository extends Repository<BeneficiarioPensao, Long> {

    /**
     * Finds a beneficiario pensao by CPF.
     *
     * @param cpf the CPF of the beneficiario pensao
     * @return an Optional containing the beneficiario pensao if found, or empty if not found
     */
    Optional<BeneficiarioPensao> findByCpf(String cpf);
}