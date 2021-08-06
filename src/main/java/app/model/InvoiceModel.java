package app.model;

import java.util.Date;
import java.util.Map;

public class InvoiceModel {

    private final InvoiceRepository repository;

    public InvoiceModel(InvoiceRepository repository) {
        this.repository = repository;
    }

    /**
     * Zamienia dane przesłane z formularza z Map na Invoice
     *
     * @param body {@link Map}
     * @return Invoice
     */
    public Invoice changeBodyToInvoice(Map<String, String> body) throws WrongParameter {
        Invoice invoice = new Invoice();
        InvoiceNumbering invoiceNumbering = new InvoiceNumbering(repository);
        String numberInvoice = invoiceNumbering.getNextNumberInvoice();
        Float amount = Conversion.changeToFloat(body.get("amount"));
        Date date = Conversion.changeToDate(body.get("date"));
        invoice.setNumberInvoice(numberInvoice);
        if (amount == null) {
            throw new WrongParameter("Błędny format kwoty");
        } else {
            invoice.setAmount(amount);
        }
        if (date == null) {
            throw new WrongParameter("Błędny format daty");
        } else {
            invoice.setDate(date);
        }
        return invoice;
    }
}
