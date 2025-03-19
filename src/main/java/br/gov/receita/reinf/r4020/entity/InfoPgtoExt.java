package br.gov.receita.reinf.r4020.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "info_pgto_ext", schema = "r4020")
public class InfoPgtoExt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer indNIF;
    private String nifBenef;
    private String relFontPg;
    private String frmTribut;

    @Embedded
    private EndExt endExt;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIndNIF() {
        return indNIF;
    }

    public void setIndNIF(Integer indNIF) {
        this.indNIF = indNIF;
    }

    public String getNifBenef() {
        return nifBenef;
    }

    public void setNifBenef(String nifBenef) {
        this.nifBenef = nifBenef;
    }

    public String getRelFontPg() {
        return relFontPg;
    }

    public void setRelFontPg(String relFontPg) {
        this.relFontPg = relFontPg;
    }

    public String getFrmTribut() {
        return frmTribut;
    }

    public void setFrmTribut(String frmTribut) {
        this.frmTribut = frmTribut;
    }

    public EndExt getEndExt() {
        return endExt;
    }

    public void setEndExt(EndExt endExt) {
        this.endExt = endExt;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoPgtoExt that = (InfoPgtoExt) o;
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
        private final InfoPgtoExt instance = new InfoPgtoExt();

        public Builder id(Long id) {
            instance.setId(id);
            return this;
        }

        public Builder indNIF(Integer indNIF) {
            instance.setIndNIF(indNIF);
            return this;
        }

        public Builder nifBenef(String nifBenef) {
            instance.setNifBenef(nifBenef);
            return this;
        }

        public Builder relFontPg(String relFontPg) {
            instance.setRelFontPg(relFontPg);
            return this;
        }

        public Builder frmTribut(String frmTribut) {
            instance.setFrmTribut(frmTribut);
            return this;
        }

        public Builder endExt(EndExt endExt) {
            instance.setEndExt(endExt);
            return this;
        }

        public InfoPgtoExt build() {
            return instance;
        }
    }
}