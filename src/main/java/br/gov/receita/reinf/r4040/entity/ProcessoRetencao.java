package br.gov.receita.reinf.r4040.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "processo_retencao", schema = "r4040")
public class ProcessoRetencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer tpProcRet;
    private String nrProcRet;
    private String codSusp;
    private BigDecimal vlrBaseSuspIR;
    private BigDecimal vlrNIR;
    private BigDecimal vlrDepIR;

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

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessoRetencao that = (ProcessoRetencao) o;
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
        private final ProcessoRetencao instance = new ProcessoRetencao();

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

        public ProcessoRetencao build() {
            return instance;
        }
    }
}