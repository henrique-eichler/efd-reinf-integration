package br.gov.receita.reinf.r4040.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "EstabelecimentoR4040")
@Table(name = "estabelecimento", schema = "r4040")
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer tpInscEstab;
    private String nrInscEstab;
    private String ideEvtAdic;

    @OneToMany(cascade = CascadeType.ALL)
    private List<NaturezaRendimento> naturezasRendimento = new ArrayList<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTpInscEstab() {
        return tpInscEstab;
    }

    public void setTpInscEstab(Integer tpInscEstab) {
        this.tpInscEstab = tpInscEstab;
    }

    public String getNrInscEstab() {
        return nrInscEstab;
    }

    public void setNrInscEstab(String nrInscEstab) {
        this.nrInscEstab = nrInscEstab;
    }

    public String getIdeEvtAdic() {
        return ideEvtAdic;
    }

    public void setIdeEvtAdic(String ideEvtAdic) {
        this.ideEvtAdic = ideEvtAdic;
    }

    public List<NaturezaRendimento> getNaturezasRendimento() {
        return naturezasRendimento;
    }

    public void setNaturezasRendimento(List<NaturezaRendimento> naturezasRendimento) {
        this.naturezasRendimento = naturezasRendimento;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estabelecimento that = (Estabelecimento) o;
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
        private final Estabelecimento instance = new Estabelecimento();

        public Builder id(Long id) {
            instance.setId(id);
            return this;
        }

        public Builder tpInscEstab(Integer tpInscEstab) {
            instance.setTpInscEstab(tpInscEstab);
            return this;
        }

        public Builder nrInscEstab(String nrInscEstab) {
            instance.setNrInscEstab(nrInscEstab);
            return this;
        }

        public Builder ideEvtAdic(String ideEvtAdic) {
            instance.setIdeEvtAdic(ideEvtAdic);
            return this;
        }

        public Builder naturezasRendimento(List<NaturezaRendimento> naturezasRendimento) {
            instance.setNaturezasRendimento(naturezasRendimento);
            return this;
        }

        public Estabelecimento build() {
            return instance;
        }
    }
}
