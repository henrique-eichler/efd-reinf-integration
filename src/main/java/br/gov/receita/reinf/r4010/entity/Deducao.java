package br.gov.receita.reinf.r4010.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "deducao", schema = "r4010")
public class Deducao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer indTpDeducao;
    private BigDecimal vlrDeducao;
    private String nrInscPrevComp;
    private BigDecimal vlrPatrocFunp;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BeneficiarioPensao> beneficiariosPensao = new ArrayList<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIndTpDeducao() {
        return indTpDeducao;
    }

    public void setIndTpDeducao(Integer indTpDeducao) {
        this.indTpDeducao = indTpDeducao;
    }

    public BigDecimal getVlrDeducao() {
        return vlrDeducao;
    }

    public void setVlrDeducao(BigDecimal vlrDeducao) {
        this.vlrDeducao = vlrDeducao;
    }

    public String getNrInscPrevComp() {
        return nrInscPrevComp;
    }

    public void setNrInscPrevComp(String nrInscPrevComp) {
        this.nrInscPrevComp = nrInscPrevComp;
    }

    public BigDecimal getVlrPatrocFunp() {
        return vlrPatrocFunp;
    }

    public void setVlrPatrocFunp(BigDecimal vlrPatrocFunp) {
        this.vlrPatrocFunp = vlrPatrocFunp;
    }

    public List<BeneficiarioPensao> getBeneficiariosPensao() {
        return beneficiariosPensao;
    }

    public void setBeneficiariosPensao(List<BeneficiarioPensao> beneficiariosPensao) {
        this.beneficiariosPensao = beneficiariosPensao;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deducao deducao = (Deducao) o;
        return Objects.equals(id, deducao.id);
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
        private final Deducao instance = new Deducao();

        public Builder id(Long id) {
            instance.setId(id);
            return this;
        }

        public Builder indTpDeducao(Integer indTpDeducao) {
            instance.setIndTpDeducao(indTpDeducao);
            return this;
        }

        public Builder vlrDeducao(BigDecimal vlrDeducao) {
            instance.setVlrDeducao(vlrDeducao);
            return this;
        }

        public Builder nrInscPrevComp(String nrInscPrevComp) {
            instance.setNrInscPrevComp(nrInscPrevComp);
            return this;
        }

        public Builder vlrPatrocFunp(BigDecimal vlrPatrocFunp) {
            instance.setVlrPatrocFunp(vlrPatrocFunp);
            return this;
        }

        public Builder beneficiariosPensao(List<BeneficiarioPensao> beneficiariosPensao) {
            instance.setBeneficiariosPensao(beneficiariosPensao);
            return this;
        }

        public Deducao build() {
            return instance;
        }
    }
}
