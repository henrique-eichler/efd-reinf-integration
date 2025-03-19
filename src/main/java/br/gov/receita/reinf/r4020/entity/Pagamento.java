package br.gov.receita.reinf.r4020.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "pagamento", schema = "r4020")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String natRend;
    private String observ;
    private LocalDate dtFG;
    private BigDecimal vlrBruto;
    private Integer indFciScp;
    private String nrInscFciScp;
    private BigDecimal percSCP;
    private String indJud;
    private String paisResidExt;
    private LocalDate dtEscrCont;
    private String observPgto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "retencoes_id")
    private Retencoes retencoes;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNatRend() {
        return natRend;
    }

    public void setNatRend(String natRend) {
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

    public BigDecimal getVlrBruto() {
        return vlrBruto;
    }

    public void setVlrBruto(BigDecimal vlrBruto) {
        this.vlrBruto = vlrBruto;
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

    public LocalDate getDtEscrCont() {
        return dtEscrCont;
    }

    public void setDtEscrCont(LocalDate dtEscrCont) {
        this.dtEscrCont = dtEscrCont;
    }

    public String getObservPgto() {
        return observPgto;
    }

    public void setObservPgto(String observPgto) {
        this.observPgto = observPgto;
    }

    public Retencoes getRetencoes() {
        return retencoes;
    }

    public void setRetencoes(Retencoes retencoes) {
        this.retencoes = retencoes;
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

        public Builder natRend(String natRend) {
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

        public Builder vlrBruto(BigDecimal vlrBruto) {
            instance.setVlrBruto(vlrBruto);
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

        public Builder dtEscrCont(LocalDate dtEscrCont) {
            instance.setDtEscrCont(dtEscrCont);
            return this;
        }

        public Builder observPgto(String observPgto) {
            instance.setObservPgto(observPgto);
            return this;
        }

        public Builder retencoes(Retencoes retencoes) {
            instance.setRetencoes(retencoes);
            return this;
        }

        public Pagamento build() {
            return instance;
        }
    }
}
