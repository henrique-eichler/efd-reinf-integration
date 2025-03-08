package br.gov.receita.reinf.r4010.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estabelecimento", schema = "r4010")
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer tpInscEstab;
    private String nrInscEstab;

    @OneToOne(cascade = CascadeType.ALL)
    private Beneficiario beneficiario;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTpInscEstab() {
        return tpInscEstab;
    }

    public void setTpInscEstab(Integer tpInscEstab) {
        this.tpInscEstab = tpInscEstab;
    }

    public String getNrInscEstab() {
        return nrInscEstab;
    }

    public void setNrInscEstab(String nrInscEstab) {
        this.nrInscEstab = nrInscEstab;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estabelecimento that = (Estabelecimento) o;
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
        private final Estabelecimento instance = new Estabelecimento();

        public Builder id(Long id) {
            instance.setId(id);
            return this;
        }

        public Builder tpInscEstab(Integer tpInscEstab) {
            instance.setTpInscEstab(tpInscEstab);
            return this;
        }

        public Builder nrInscEstab(String nrInscEstab) {
            instance.setNrInscEstab(nrInscEstab);
            return this;
        }

        public Builder beneficiario(Beneficiario beneficiario) {
            instance.setBeneficiario(beneficiario);
            return this;
        }

        public Estabelecimento build() {
            return instance;
        }
    }
}
