package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Facture {

    private @Id @GeneratedValue Long id;
    private Float amount;
    private Date date;

    Facture() {}

    public Facture(Float amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Facture)) return false;
        Facture facture = (Facture) o;
        return id.equals(facture.id) && amount.equals(facture.amount) && date.equals(facture.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, date);
    }

    @Override
    public String toString() {
        return "Facture{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
