package br.gov.receita.reinf.r4010.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pagamento", schema = "r4010")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer natRend;
    private String observ;
    private LocalDate dtFG;
    private String compFP;
    private String indDecTerc;
    private BigDecimal vlrRendBruto;
    private BigDecimal vlrRendTrib;
    private BigDecimal vlrIR;
    private String indRRA;
    private Integer indFciScp;
    private String nrInscFciScp;
    private BigDecimal percSCP;
    private String indJud;
    private String paisResidExt;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Deducao> deducoes = new ArrayList<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNatRend() {
        return natRend;
    }

    public void setNatRend(Integer natRend) {
        this.natRend = natRend;
    }

    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    public LocalDate getDtFG() {
        return dtFG;
    }

    public void setDtFG(LocalDate dtFG) {
        this.dtFG = dtFG;
    }

    public String getCompFP() {
        return compFP;
    }

    public void setCompFP(String compFP) {
        this.compFP = compFP;
    }

    public String getIndDecTerc() {
        return indDecTerc;
    }

    public void setIndDecTerc(String indDecTerc) {
        this.indDecTerc = indDecTerc;
    }

    public BigDecimal getVlrRendBruto() {
        return vlrRendBruto;
    }

    public void setVlrRendBruto(BigDecimal vlrRendBruto) {
        this.vlrRendBruto = vlrRendBruto;
    }

    public BigDecimal getVlrRendTrib() {
        return vlrRendTrib;
    }

    public void setVlrRendTrib(BigDecimal vlrRendTrib) {
        this.vlrRendTrib = vlrRendTrib;
    }

    public BigDecimal getVlrIR() {
        return vlrIR;
    }

    public void setVlrIR(BigDecimal vlrIR) {
        this.vlrIR = vlrIR;
    }

    public String getIndRRA() {
        return indRRA;
    }

    public void setIndRRA(String indRRA) {
        this.indRRA = indRRA;
    }

    public Integer getIndFciScp() {
        return indFciScp;
    }

    public void setIndFciScp(Integer indFciScp) {
        this.indFciScp = indFciScp;
    }

    public String getNrInscFciScp() {
        return nrInscFciScp;
    }

    public void setNrInscFciScp(String nrInscFciScp) {
        this.nrInscFciScp = nrInscFciScp;
    }

    public BigDecimal getPercSCP() {
        return percSCP;
    }

    public void setPercSCP(BigDecimal percSCP) {
        this.percSCP = percSCP;
    }

    public String getIndJud() {
        return indJud;
    }

    public void setIndJud(String indJud) {
        this.indJud = indJud;
    }

    public String getPaisResidExt() {
        return paisResidExt;
    }

    public void setPaisResidExt(String paisResidExt) {
        this.paisResidExt = paisResidExt;
    }

    public List<Deducao> getDeducoes() {
        return deducoes;
    }

    public void setDeducoes(List<Deducao> deducoes) {
        this.deducoes = deducoes;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
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
        private final Pagamento instance = new Pagamento();

        public Builder id(Long id) {
            instance.setId(id);
            return this;
        }

        public Builder natRend(Integer natRend) {
            instance.setNatRend(natRend);
            return this;
        }

        public Builder observ(String observ) {
            instance.setObserv(observ);
            return this;
        }

        public Builder dtFG(LocalDate dtFG) {
            instance.setDtFG(dtFG);
            return this;
        }

        public Builder compFP(String compFP) {
            instance.setCompFP(compFP);
            return this;
        }

        public Builder indDecTerc(String indDecTerc) {
            instance.setIndDecTerc(indDecTerc);
            return this;
        }

        public Builder vlrRendBruto(BigDecimal vlrRendBruto) {
            instance.setVlrRendBruto(vlrRendBruto);
            return this;
        }

        public Builder vlrRendTrib(BigDecimal vlrRendTrib) {
            instance.setVlrRendTrib(vlrRendTrib);
            return this;
        }

        public Builder vlrIR(BigDecimal vlrIR) {
            instance.setVlrIR(vlrIR);
            return this;
        }

        public Builder indRRA(String indRRA) {
            instance.setIndRRA(indRRA);
            return this;
        }

        public Builder indFciScp(Integer indFciScp) {
            instance.setIndFciScp(indFciScp);
            return this;
        }

        public Builder nrInscFciScp(String nrInscFciScp) {
            instance.setNrInscFciScp(nrInscFciScp);
            return this;
        }

        public Builder percSCP(BigDecimal percSCP) {
            instance.setPercSCP(percSCP);
            return this;
        }

        public Builder indJud(String indJud) {
            instance.setIndJud(indJud);
            return this;
        }

        public Builder paisResidExt(String paisResidExt) {
            instance.setPaisResidExt(paisResidExt);
            return this;
        }

        public Builder deducoes(List<Deducao> deducoes) {
            instance.setDeducoes(deducoes);
            return this;
        }

        public Pagamento build() {
            return instance;
        }
    }
}
