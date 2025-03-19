package br.gov.receita.reinf.r4020.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "info_proc_ret", schema = "r4020")
public class InfoProcRet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer tpProcRet;
    private String nrProcRet;
    private String codSusp;
    private BigDecimal vlrBaseSuspIR;
    private BigDecimal vlrNIR;
    private BigDecimal vlrDepIR;
    private BigDecimal vlrBaseSuspCSLL;
    private BigDecimal vlrNCSLL;
    private BigDecimal vlrDepCSLL;
    private BigDecimal vlrBaseSuspCofins;
    private BigDecimal vlrNCofins;
    private BigDecimal vlrDepCofins;
    private BigDecimal vlrBaseSuspPP;
    private BigDecimal vlrNPP;
    private BigDecimal vlrDepPP;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTpProcRet() {
        return tpProcRet;
    }

    public void setTpProcRet(Integer tpProcRet) {
        this.tpProcRet = tpProcRet;
    }

    public String getNrProcRet() {
        return nrProcRet;
    }

    public void setNrProcRet(String nrProcRet) {
        this.nrProcRet = nrProcRet;
    }

    public String getCodSusp() {
        return codSusp;
    }

    public void setCodSusp(String codSusp) {
        this.codSusp = codSusp;
    }

    public BigDecimal getVlrBaseSuspIR() {
        return vlrBaseSuspIR;
    }

    public void setVlrBaseSuspIR(BigDecimal vlrBaseSuspIR) {
        this.vlrBaseSuspIR = vlrBaseSuspIR;
    }

    public BigDecimal getVlrNIR() {
        return vlrNIR;
    }

    public void setVlrNIR(BigDecimal vlrNIR) {
        this.vlrNIR = vlrNIR;
    }

    public BigDecimal getVlrDepIR() {
        return vlrDepIR;
    }

    public void setVlrDepIR(BigDecimal vlrDepIR) {
        this.vlrDepIR = vlrDepIR;
    }

    public BigDecimal getVlrBaseSuspCSLL() {
        return vlrBaseSuspCSLL;
    }

    public void setVlrBaseSuspCSLL(BigDecimal vlrBaseSuspCSLL) {
        this.vlrBaseSuspCSLL = vlrBaseSuspCSLL;
    }

    public BigDecimal getVlrNCSLL() {
        return vlrNCSLL;
    }

    public void setVlrNCSLL(BigDecimal vlrNCSLL) {
        this.vlrNCSLL = vlrNCSLL;
    }

    public BigDecimal getVlrDepCSLL() {
        return vlrDepCSLL;
    }

    public void setVlrDepCSLL(BigDecimal vlrDepCSLL) {
        this.vlrDepCSLL = vlrDepCSLL;
    }

    public BigDecimal getVlrBaseSuspCofins() {
        return vlrBaseSuspCofins;
    }

    public void setVlrBaseSuspCofins(BigDecimal vlrBaseSuspCofins) {
        this.vlrBaseSuspCofins = vlrBaseSuspCofins;
    }

    public BigDecimal getVlrNCofins() {
        return vlrNCofins;
    }

    public void setVlrNCofins(BigDecimal vlrNCofins) {
        this.vlrNCofins = vlrNCofins;
    }

    public BigDecimal getVlrDepCofins() {
        return vlrDepCofins;
    }

    public void setVlrDepCofins(BigDecimal vlrDepCofins) {
        this.vlrDepCofins = vlrDepCofins;
    }

    public BigDecimal getVlrBaseSuspPP() {
        return vlrBaseSuspPP;
    }

    public void setVlrBaseSuspPP(BigDecimal vlrBaseSuspPP) {
        this.vlrBaseSuspPP = vlrBaseSuspPP;
    }

    public BigDecimal getVlrNPP() {
        return vlrNPP;
    }

    public void setVlrNPP(BigDecimal vlrNPP) {
        this.vlrNPP = vlrNPP;
    }

    public BigDecimal getVlrDepPP() {
        return vlrDepPP;
    }

    public void setVlrDepPP(BigDecimal vlrDepPP) {
        this.vlrDepPP = vlrDepPP;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoProcRet that = (InfoProcRet) o;
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
        private final InfoProcRet instance = new InfoProcRet();

        public Builder id(Long id) {
            instance.setId(id);
            return this;
        }

        public Builder tpProcRet(Integer tpProcRet) {
            instance.setTpProcRet(tpProcRet);
            return this;
        }

        public Builder nrProcRet(String nrProcRet) {
            instance.setNrProcRet(nrProcRet);
            return this;
        }

        public Builder codSusp(String codSusp) {
            instance.setCodSusp(codSusp);
            return this;
        }

        public Builder vlrBaseSuspIR(BigDecimal vlrBaseSuspIR) {
            instance.setVlrBaseSuspIR(vlrBaseSuspIR);
            return this;
        }

        public Builder vlrNIR(BigDecimal vlrNIR) {
            instance.setVlrNIR(vlrNIR);
            return this;
        }

        public Builder vlrDepIR(BigDecimal vlrDepIR) {
            instance.setVlrDepIR(vlrDepIR);
            return this;
        }

        public Builder vlrBaseSuspCSLL(BigDecimal vlrBaseSuspCSLL) {
            instance.setVlrBaseSuspCSLL(vlrBaseSuspCSLL);
            return this;
        }

        public Builder vlrNCSLL(BigDecimal vlrNCSLL) {
            instance.setVlrNCSLL(vlrNCSLL);
            return this;
        }

        public Builder vlrDepCSLL(BigDecimal vlrDepCSLL) {
            instance.setVlrDepCSLL(vlrDepCSLL);
            return this;
        }

        public Builder vlrBaseSuspCofins(BigDecimal vlrBaseSuspCofins) {
            instance.setVlrBaseSuspCofins(vlrBaseSuspCofins);
            return this;
        }

        public Builder vlrNCofins(BigDecimal vlrNCofins) {
            instance.setVlrNCofins(vlrNCofins);
            return this;
        }

        public Builder vlrDepCofins(BigDecimal vlrDepCofins) {
            instance.setVlrDepCofins(vlrDepCofins);
            return this;
        }

        public Builder vlrBaseSuspPP(BigDecimal vlrBaseSuspPP) {
            instance.setVlrBaseSuspPP(vlrBaseSuspPP);
            return this;
        }

        public Builder vlrNPP(BigDecimal vlrNPP) {
            instance.setVlrNPP(vlrNPP);
            return this;
        }

        public Builder vlrDepPP(BigDecimal vlrDepPP) {
            instance.setVlrDepPP(vlrDepPP);
            return this;
        }

        public InfoProcRet build() {
            return instance;
        }
    }
}