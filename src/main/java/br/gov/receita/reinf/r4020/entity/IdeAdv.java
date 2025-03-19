package br.gov.receita.reinf.r4020.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "ide_adv", schema = "r4020")
public class IdeAdv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer tpInscAdv;
    private String nrInscAdv;
    private BigDecimal vlrAdv;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTpInscAdv() {
        return tpInscAdv;
    }

    public void setTpInscAdv(Integer tpInscAdv) {
        this.tpInscAdv = tpInscAdv;
    }

    public String getNrInscAdv() {
        return nrInscAdv;
    }

    public void setNrInscAdv(String nrInscAdv) {
        this.nrInscAdv = nrInscAdv;
    }

    public BigDecimal getVlrAdv() {
        return vlrAdv;
    }

    public void setVlrAdv(BigDecimal vlrAdv) {
        this.vlrAdv = vlrAdv;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdeAdv ideAdv = (IdeAdv) o;
        return Objects.equals(id, ideAdv.id);
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
        private final IdeAdv instance = new IdeAdv();

        public Builder id(Long id) {
            instance.setId(id);
            return this;
        }

        public Builder tpInscAdv(Integer tpInscAdv) {
            instance.setTpInscAdv(tpInscAdv);
            return this;
        }

        public Builder nrInscAdv(String nrInscAdv) {
            instance.setNrInscAdv(nrInscAdv);
            return this;
        }

        public Builder vlrAdv(BigDecimal vlrAdv) {
            instance.setVlrAdv(vlrAdv);
            return this;
        }

        public IdeAdv build() {
            return instance;
        }
    }
}