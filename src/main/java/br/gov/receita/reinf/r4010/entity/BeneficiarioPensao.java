package br.gov.receita.reinf.r4010.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "beneficiario_pensao")
public class BeneficiarioPensao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpfDep;
    private BigDecimal vlrDepen;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpfDep() {
        return cpfDep;
    }

    public void setCpfDep(String cpfDep) {
        this.cpfDep = cpfDep;
    }

    public BigDecimal getVlrDepen() {
        return vlrDepen;
    }

    public void setVlrDepen(BigDecimal vlrDepen) {
        this.vlrDepen = vlrDepen;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeneficiarioPensao that = (BeneficiarioPensao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final BeneficiarioPensao instance = new BeneficiarioPensao();

        public Builder id(Long id) {
            instance.setId(id);
            return this;
        }

        public Builder cpfDep(String cpfDep) {
            instance.setCpfDep(cpfDep);
            return this;
        }

        public Builder vlrDepen(BigDecimal vlrDepen) {
            instance.setVlrDepen(vlrDepen);
            return this;
        }

        public BeneficiarioPensao build() {
            return instance;
        }
    }
}
