package app.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,unique=true)
    private String numberInvoice;

    @Column(nullable = false)
    private Float amount;

    @Column(nullable = false)
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
