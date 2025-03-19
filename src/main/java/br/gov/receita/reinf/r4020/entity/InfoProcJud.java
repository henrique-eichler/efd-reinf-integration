package br.gov.receita.reinf.r4020.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "info_proc_jud", schema = "r4020")
public class InfoProcJud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nrProc;
    private Integer indOrigRec;
    private String cnpjOrigRecurso;
    private String desc;
    private BigDecimal vlrDespCustas;
    private BigDecimal vlrDespAdvogados;

    @OneToMany(cascade = CascadeType.ALL)
    private List<IdeAdv> advogados = new ArrayList<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNrProc() {
        return nrProc;
    }

    public void setNrProc(String nrProc) {
        this.nrProc = nrProc;
    }

    public Integer getIndOrigRec() {
        return indOrigRec;
    }

    public void setIndOrigRec(Integer indOrigRec) {
        this.indOrigRec = indOrigRec;
    }

    public String getCnpjOrigRecurso() {
        return cnpjOrigRecurso;
    }

    public void setCnpjOrigRecurso(String cnpjOrigRecurso) {
        this.cnpjOrigRecurso = cnpjOrigRecurso;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getVlrDespCustas() {
        return vlrDespCustas;
    }

    public void setVlrDespCustas(BigDecimal vlrDespCustas) {
        this.vlrDespCustas = vlrDespCustas;
    }

    public BigDecimal getVlrDespAdvogados() {
        return vlrDespAdvogados;
    }

    public void setVlrDespAdvogados(BigDecimal vlrDespAdvogados) {
        this.vlrDespAdvogados = vlrDespAdvogados;
    }

    public List<IdeAdv> getAdvogados() {
        return advogados;
    }

    public void setAdvogados(List<IdeAdv> advogados) {
        this.advogados = advogados;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoProcJud that = (InfoProcJud) o;
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
        private final InfoProcJud instance = new InfoProcJud();

        public Builder id(Long id) {
            instance.setId(id);
            return this;
        }

        public Builder nrProc(String nrProc) {
            instance.setNrProc(nrProc);
            return this;
        }

        public Builder indOrigRec(Integer indOrigRec) {
            instance.setIndOrigRec(indOrigRec);
            return this;
        }

        public Builder cnpjOrigRecurso(String cnpjOrigRecurso) {
            instance.setCnpjOrigRecurso(cnpjOrigRecurso);
            return this;
        }

        public Builder desc(String desc) {
            instance.setDesc(desc);
            return this;
        }

        public Builder vlrDespCustas(BigDecimal vlrDespCustas) {
            instance.setVlrDespCustas(vlrDespCustas);
            return this;
        }

        public Builder vlrDespAdvogados(BigDecimal vlrDespAdvogados) {
            instance.setVlrDespAdvogados(vlrDespAdvogados);
            return this;
        }

        public Builder advogados(List<IdeAdv> advogados) {
            instance.setAdvogados(advogados);
            return this;
        }

        public InfoProcJud build() {
            return instance;
        }
    }
}