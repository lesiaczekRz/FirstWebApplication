package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Invoice {

    private @Id @GeneratedValue Long id;
    private Float amount;
    private Date date;

    Invoice() {}

    public Invoice(Float amount, Date date) {
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
        if (!(o instanceof Invoice)) return false;
        Invoice invoice = (Invoice) o;
        return id.equals(invoice.id) && amount.equals(invoice.amount) && date.equals(invoice.date);
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
