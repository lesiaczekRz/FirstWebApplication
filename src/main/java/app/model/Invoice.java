package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Invoice {

    private @Id @GeneratedValue Long id;
    private String numberInvoice;
    private Float amount;
    private Date date;

    Invoice() {}

    public Invoice(String numberInvoice, Float amount, Date date) {
        this.numberInvoice = numberInvoice;
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

    public String getNumberInvoice() {
        return numberInvoice;
    }

    public void setNumberInvoice(String numberInvoice) {
        this.numberInvoice = numberInvoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice)) return false;
        Invoice invoice = (Invoice) o;
        return id.equals(invoice.id) && numberInvoice.equals(invoice.numberInvoice) &&
                amount.equals(invoice.amount) && date.equals(invoice.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberInvoice, amount, date);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", numberInvoice='" + numberInvoice + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
