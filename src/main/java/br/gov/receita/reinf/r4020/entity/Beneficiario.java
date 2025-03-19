package br.gov.receita.reinf.r4020.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "beneficiario", schema = "r4020")
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cnpjBenef;
    private String nmBenef;
    private Integer isenImun;
    private String ideEvtAdic;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Pagamento> pagamentos = new ArrayList<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpjBenef() {
        return cnpjBenef;
    }

    public void setCnpjBenef(String cnpjBenef) {
        this.cnpjBenef = cnpjBenef;
    }

    public String getNmBenef() {
        return nmBenef;
    }

    public void setNmBenef(String nmBenef) {
        this.nmBenef = nmBenef;
    }

    public Integer getIsenImun() {
        return isenImun;
    }

    public void setIsenImun(Integer isenImun) {
        this.isenImun = isenImun;
    }

    public String getIdeEvtAdic() {
        return ideEvtAdic;
    }

    public void setIdeEvtAdic(String ideEvtAdic) {
        this.ideEvtAdic = ideEvtAdic;
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

        public Builder cnpjBenef(String cnpjBenef) {
            instance.setCnpjBenef(cnpjBenef);
            return this;
        }

        public Builder nmBenef(String nmBenef) {
            instance.setNmBenef(nmBenef);
            return this;
        }

        public Builder isenImun(Integer isenImun) {
            instance.setIsenImun(isenImun);
            return this;
        }

        public Builder ideEvtAdic(String ideEvtAdic) {
            instance.setIdeEvtAdic(ideEvtAdic);
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
