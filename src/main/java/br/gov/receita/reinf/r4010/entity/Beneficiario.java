package br.gov.receita.reinf.r4010.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "beneficiario", schema = "r4010")
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpfBenef;
    private String nmBenef;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Dependente> dependentes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Pagamento> pagamentos = new ArrayList<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpfBenef() {
        return cpfBenef;
    }

    public void setCpfBenef(String cpfBenef) {
        this.cpfBenef = cpfBenef;
    }

    public String getNmBenef() {
        return nmBenef;
    }

    public void setNmBenef(String nmBenef) {
        this.nmBenef = nmBenef;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beneficiario that = (Beneficiario) o;
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
        private final Beneficiario instance = new Beneficiario();

        public Builder id(Long id) {
            instance.setId(id);
            return this;
        }

        public Builder cpfBenef(String cpfBenef) {
            instance.setCpfBenef(cpfBenef);
            return this;
        }

        public Builder nmBenef(String nmBenef) {
            instance.setNmBenef(nmBenef);
            return this;
        }

        public Builder dependentes(List<Dependente> dependentes) {
            instance.setDependentes(dependentes);
            return this;
        }

        public Builder pagamentos(List<Pagamento> pagamentos) {
            instance.setPagamentos(pagamentos);
            return this;
        }

        public Beneficiario build() {
            return instance;
        }
    }
}
