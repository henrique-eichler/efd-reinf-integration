package br.gov.receita.reinf.r4020.repository;

import br.gov.receita.reinf.r4020.entity.Beneficiario;
import br.gov.receita.reinf.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Beneficiario entity.
 */
public interface BeneficiarioRepository extends Repository<Beneficiario, Long> {

    /**
     * Finds a beneficiario by its CNPJ.
     *
     * @param cnpjBenef the CNPJ of the beneficiario
     * @return an Optional containing the beneficiario if found, or empty if not found
     */
    Optional<Beneficiario> findByCnpjBenef(String cnpjBenef);

    /**
     * Finds beneficiarios by name.
     *
     * @param nmBenef the name of the beneficiario
     * @return a list of beneficiarios with the given name
     */
    List<Beneficiario> findByNmBenef(String nmBenef);
}