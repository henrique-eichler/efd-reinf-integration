package br.gov.receita.reinf.r4040.entity;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Contribuinte {

    private Integer tpInsc; // 1 - CNPJ, 2 - CPF
    private String nrInsc;

    // Getters and Setters
    public Integer getTpInsc() {
        return tpInsc;
    }

    public void setTpInsc(Integer tpInsc) {
        this.tpInsc = tpInsc;
    }

    public String getNrInsc() {
        return nrInsc;
    }

    public void setNrInsc(String nrInsc) {
        this.nrInsc = nrInsc;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contribuinte that = (Contribuinte) o;
        return Objects.equals(tpInsc, that.tpInsc) && 
               Objects.equals(nrInsc, that.nrInsc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tpInsc, nrInsc);
    }

    // Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Contribuinte instance = new Contribuinte();

        public Builder tpInsc(Integer tpInsc) {
            instance.setTpInsc(tpInsc);
            return this;
        }

        public Builder nrInsc(String nrInsc) {
            instance.setNrInsc(nrInsc);
            return this;
        }

        public Contribuinte build() {
            return instance;
        }
    }
}