package br.gov.receita.reinf.r4010.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "dependente", schema = "r4010")
public class Dependente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpfDep;
    private LocalDate dtNascto;
    private String nome;
    private Integer relDep; // Enumerado pode ser criado
    private String descrDep;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpfDep() {
        return cpfDep;
    }

    public void setCpfDep(String cpfDep) {
        this.cpfDep = cpfDep;
    }

    public LocalDate getDtNascto() {
        return dtNascto;
    }

    public void setDtNascto(LocalDate dtNascto) {
        this.dtNascto = dtNascto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getRelDep() {
        return relDep;
    }

    public void setRelDep(Integer relDep) {
        this.relDep = relDep;
    }

    public String getDescrDep() {
        return descrDep;
    }

    public void setDescrDep(String descrDep) {
        this.descrDep = descrDep;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dependente that = (Dependente) o;
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
        private final Dependente instance = new Dependente();

        public Builder id(Long id) {
            instance.setId(id);
            return this;
        }

        public Builder cpfDep(String cpfDep) {
            instance.setCpfDep(cpfDep);
            return this;
        }

        public Builder dtNascto(LocalDate dtNascto) {
            instance.setDtNascto(dtNascto);
            return this;
        }

        public Builder nome(String nome) {
            instance.setNome(nome);
            return this;
        }

        public Builder relDep(Integer relDep) {
            instance.setRelDep(relDep);
            return this;
        }

        public Builder descrDep(String descrDep) {
            instance.setDescrDep(descrDep);
            return this;
        }

        public Dependente build() {
            return instance;
        }
    }
}
