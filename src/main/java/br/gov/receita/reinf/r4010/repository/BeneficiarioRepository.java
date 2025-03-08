package br.gov.receita.reinf.r4010.repository;

import br.gov.receita.reinf.r4010.entity.Beneficiario;
import br.gov.receita.reinf.repository.Repository;

import java.util.Optional;

/**
 * Repository interface for Beneficiario entity.
 */
public interface BeneficiarioRepository extends Repository<Beneficiario, Long> {

    /**
     * Finds a beneficiario by CPF.
     *
     * @param cpf the CPF of the beneficiario
     * @return an Optional containing the beneficiario if found, or empty if not found
     */
    Optional<Beneficiario> findByCpf(String cpf);
}