package br.gov.receita.reinf.r4040.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "PagamentoR4040")
@Table(name = "pagamento", schema = "r4040")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dtFG;
    private BigDecimal vlrLiq;
    private BigDecimal vlrBaseIR;
    private BigDecimal vlrIR;
    private LocalDate dtEscrCont;
    private String descr;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProcessoRetencao> processosRetencao = new ArrayList<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDtFG() {
        return dtFG;
    }

    public void setDtFG(LocalDate dtFG) {
        this.dtFG = dtFG;
    }

    public BigDecimal getVlrLiq() {
        return vlrLiq;
    }

    public void setVlrLiq(BigDecimal vlrLiq) {
        this.vlrLiq = vlrLiq;
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

    public LocalDate getDtEscrCont() {
        return dtEscrCont;
    }

    public void setDtEscrCont(LocalDate dtEscrCont) {
        this.dtEscrCont = dtEscrCont;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public List<ProcessoRetencao> getProcessosRetencao() {
        return processosRetencao;
    }

    public void setProcessosRetencao(List<ProcessoRetencao> processosRetencao) {
        this.processosRetencao = processosRetencao;
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

        public Builder dtFG(LocalDate dtFG) {
            instance.setDtFG(dtFG);
            return this;
        }

        public Builder vlrLiq(BigDecimal vlrLiq) {
            instance.setVlrLiq(vlrLiq);
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

        public Builder dtEscrCont(LocalDate dtEscrCont) {
            instance.setDtEscrCont(dtEscrCont);
            return this;
        }

        public Builder descr(String descr) {
            instance.setDescr(descr);
            return this;
        }

        public Builder processosRetencao(List<ProcessoRetencao> processosRetencao) {
            instance.setProcessosRetencao(processosRetencao);
            return this;
        }

        public Pagamento build() {
            return instance;
        }
    }
}
