package br.gov.receita.reinf.r4020.entity;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class EndExt {

    private String dscLograd;
    private String nrLograd;
    private String complem;
    private String bairro;
    private String cidade;
    private String estado;
    private String codPostal;
    private String telef;

    // Getters and Setters
    public String getDscLograd() {
        return dscLograd;
    }

    public void setDscLograd(String dscLograd) {
        this.dscLograd = dscLograd;
    }

    public String getNrLograd() {
        return nrLograd;
    }

    public void setNrLograd(String nrLograd) {
        this.nrLograd = nrLograd;
    }

    public String getComplem() {
        return complem;
    }

    public void setComplem(String complem) {
        this.complem = complem;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndExt endExt = (EndExt) o;
        return Objects.equals(dscLograd, endExt.dscLograd) &&
               Objects.equals(nrLograd, endExt.nrLograd) &&
               Objects.equals(complem, endExt.complem) &&
               Objects.equals(bairro, endExt.bairro) &&
               Objects.equals(cidade, endExt.cidade) &&
               Objects.equals(estado, endExt.estado) &&
               Objects.equals(codPostal, endExt.codPostal) &&
               Objects.equals(telef, endExt.telef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dscLograd, nrLograd, complem, bairro, cidade, estado, codPostal, telef);
    }

    // Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final EndExt instance = new EndExt();

        public Builder dscLograd(String dscLograd) {
            instance.setDscLograd(dscLograd);
            return this;
        }

        public Builder nrLograd(String nrLograd) {
            instance.setNrLograd(nrLograd);
            return this;
        }

        public Builder complem(String complem) {
            instance.setComplem(complem);
            return this;
        }

        public Builder bairro(String bairro) {
            instance.setBairro(bairro);
            return this;
        }

        public Builder cidade(String cidade) {
            instance.setCidade(cidade);
            return this;
        }

        public Builder estado(String estado) {
            instance.setEstado(estado);
            return this;
        }

        public Builder codPostal(String codPostal) {
            instance.setCodPostal(codPostal);
            return this;
        }

        public Builder telef(String telef) {
            instance.setTelef(telef);
            return this;
        }

        public EndExt build() {
            return instance;
        }
    }
}