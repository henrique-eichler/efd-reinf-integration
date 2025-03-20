package br.gov.receita.reinf.r4040.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "natureza_rendimento", schema = "r4040")
public class NaturezaRendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String natRend;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Pagamento> pagamentos = new ArrayList<>();

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

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NaturezaRendimento that = (NaturezaRendimento) o;
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
        private final NaturezaRendimento instance = new NaturezaRendimento();

        public Builder id(Long id) {
            instance.setId(id);
            return this;
        }

        public Builder natRend(String natRend) {
            instance.setNatRend(natRend);
            return this;
        }

        public Builder pagamentos(List<Pagamento> pagamentos) {
            instance.setPagamentos(pagamentos);
            return this;
        }

        public NaturezaRendimento build() {
            return instance;
        }
    }
}