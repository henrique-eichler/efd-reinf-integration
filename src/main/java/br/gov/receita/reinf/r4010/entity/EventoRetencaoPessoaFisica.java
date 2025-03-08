package br.gov.receita.reinf.r4010.entity;

import javax.persistence.*;
import java.time.YearMonth;
import java.util.Objects;

@Entity
@Table(name = "evento_retencao_pf", schema = "r4010")
public class EventoRetencaoPessoaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idEvento;
    private Integer indRetif;
    private String nrRecibo;
    private YearMonth perApur;
    private Integer tpAmb;
    private Integer procEmi;
    private String verProc;

    @Embedded
    private Contribuinte contribuinte;

    @OneToOne(cascade = CascadeType.ALL)
    private Estabelecimento estabelecimento;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public Integer getIndRetif() {
        return indRetif;
    }

    public void setIndRetif(Integer indRetif) {
        this.indRetif = indRetif;
    }

    public String getNrRecibo() {
        return nrRecibo;
    }

    public void setNrRecibo(String nrRecibo) {
        this.nrRecibo = nrRecibo;
    }

    public YearMonth getPerApur() {
        return perApur;
    }

    public void setPerApur(YearMonth perApur) {
        this.perApur = perApur;
    }

    public Integer getTpAmb() {
        return tpAmb;
    }

    public void setTpAmb(Integer tpAmb) {
        this.tpAmb = tpAmb;
    }

    public Integer getProcEmi() {
        return procEmi;
    }

    public void setProcEmi(Integer procEmi) {
        this.procEmi = procEmi;
    }

    public String getVerProc() {
        return verProc;
    }

    public void setVerProc(String verProc) {
        this.verProc = verProc;
    }

    public Contribuinte getContribuinte() {
        return contribuinte;
    }

    public void setContribuinte(Contribuinte contribuinte) {
        this.contribuinte = contribuinte;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventoRetencaoPessoaFisica that = (EventoRetencaoPessoaFisica) o;
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
        private final EventoRetencaoPessoaFisica instance = new EventoRetencaoPessoaFisica();

        public Builder id(Long id) {
            instance.setId(id);
            return this;
        }

        public Builder idEvento(String idEvento) {
            instance.setIdEvento(idEvento);
            return this;
        }

        public Builder indRetif(Integer indRetif) {
            instance.setIndRetif(indRetif);
            return this;
        }

        public Builder nrRecibo(String nrRecibo) {
            instance.setNrRecibo(nrRecibo);
            return this;
        }

        public Builder perApur(YearMonth perApur) {
            instance.setPerApur(perApur);
            return this;
        }

        public Builder tpAmb(Integer tpAmb) {
            instance.setTpAmb(tpAmb);
            return this;
        }

        public Builder procEmi(Integer procEmi) {
            instance.setProcEmi(procEmi);
            return this;
        }

        public Builder verProc(String verProc) {
            instance.setVerProc(verProc);
            return this;
        }

        public Builder contribuinte(Contribuinte contribuinte) {
            instance.setContribuinte(contribuinte);
            return this;
        }

        public Builder estabelecimento(Estabelecimento estabelecimento) {
            instance.setEstabelecimento(estabelecimento);
            return this;
        }

        public EventoRetencaoPessoaFisica build() {
            return instance;
        }
    }
}
