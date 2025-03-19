package br.gov.receita.reinf.r4020.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "retencoes", schema = "r4020")
public class Retencoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal vlrBaseIR;
    private BigDecimal vlrIR;
    private BigDecimal vlrBaseAgreg;
    private BigDecimal vlrAgreg;
    private BigDecimal vlrBaseCSLL;
    private BigDecimal vlrCSLL;
    private BigDecimal vlrBaseCofins;
    private BigDecimal vlrCofins;
    private BigDecimal vlrBasePP;
    private BigDecimal vlrPP;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getVlrBaseIR() {
        return vlrBaseIR;
    }

    public void setVlrBaseIR(BigDecimal vlrBaseIR) {
        this.vlrBaseIR = vlrBaseIR;
    }

    public BigDecimal getVlrIR() {
        return vlrIR;
    }

    public void setVlrIR(BigDecimal vlrIR) {
        this.vlrIR = vlrIR;
    }

    public BigDecimal getVlrBaseAgreg() {
        return vlrBaseAgreg;
    }

    public void setVlrBaseAgreg(BigDecimal vlrBaseAgreg) {
        this.vlrBaseAgreg = vlrBaseAgreg;
    }

    public BigDecimal getVlrAgreg() {
        return vlrAgreg;
    }

    public void setVlrAgreg(BigDecimal vlrAgreg) {
        this.vlrAgreg = vlrAgreg;
    }

    public BigDecimal getVlrBaseCSLL() {
        return vlrBaseCSLL;
    }

    public void setVlrBaseCSLL(BigDecimal vlrBaseCSLL) {
        this.vlrBaseCSLL = vlrBaseCSLL;
    }

    public BigDecimal getVlrCSLL() {
        return vlrCSLL;
    }

    public void setVlrCSLL(BigDecimal vlrCSLL) {
        this.vlrCSLL = vlrCSLL;
    }

    public BigDecimal getVlrBaseCofins() {
        return vlrBaseCofins;
    }

    public void setVlrBaseCofins(BigDecimal vlrBaseCofins) {
        this.vlrBaseCofins = vlrBaseCofins;
    }

    public BigDecimal getVlrCofins() {
        return vlrCofins;
    }

    public void setVlrCofins(BigDecimal vlrCofins) {
        this.vlrCofins = vlrCofins;
    }

    public BigDecimal getVlrBasePP() {
        return vlrBasePP;
    }

    public void setVlrBasePP(BigDecimal vlrBasePP) {
        this.vlrBasePP = vlrBasePP;
    }

    public BigDecimal getVlrPP() {
        return vlrPP;
    }

    public void setVlrPP(BigDecimal vlrPP) {
        this.vlrPP = vlrPP;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Retencoes retencoes = (Retencoes) o;
        return Objects.equals(id, retencoes.id);
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
        private final Retencoes instance = new Retencoes();

        public Builder id(Long id) {
            instance.setId(id);
            return this;
        }

        public Builder vlrBaseIR(BigDecimal vlrBaseIR) {
            instance.setVlrBaseIR(vlrBaseIR);
            return this;
        }

        public Builder vlrIR(BigDecimal vlrIR) {
            instance.setVlrIR(vlrIR);
            return this;
        }

        public Builder vlrBaseAgreg(BigDecimal vlrBaseAgreg) {
            instance.setVlrBaseAgreg(vlrBaseAgreg);
            return this;
        }

        public Builder vlrAgreg(BigDecimal vlrAgreg) {
            instance.setVlrAgreg(vlrAgreg);
            return this;
        }

        public Builder vlrBaseCSLL(BigDecimal vlrBaseCSLL) {
            instance.setVlrBaseCSLL(vlrBaseCSLL);
            return this;
        }

        public Builder vlrCSLL(BigDecimal vlrCSLL) {
            instance.setVlrCSLL(vlrCSLL);
            return this;
        }

        public Builder vlrBaseCofins(BigDecimal vlrBaseCofins) {
            instance.setVlrBaseCofins(vlrBaseCofins);
            return this;
        }

        public Builder vlrCofins(BigDecimal vlrCofins) {
            instance.setVlrCofins(vlrCofins);
            return this;
        }

        public Builder vlrBasePP(BigDecimal vlrBasePP) {
            instance.setVlrBasePP(vlrBasePP);
            return this;
        }

        public Builder vlrPP(BigDecimal vlrPP) {
            instance.setVlrPP(vlrPP);
            return this;
        }

        public Retencoes build() {
            return instance;
        }
    }
}