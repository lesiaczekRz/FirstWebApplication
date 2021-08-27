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
     * @param id {@link Long}
     * @return Invoice
     */
    public Invoice changeBodyToInvoice(Map<String, String> body, Long id) throws WrongParameter {
        Invoice invoice;
        String numberInvoice;
        if (id == null) {
            invoice = new Invoice();
            InvoiceNumbering invoiceNumbering = new InvoiceNumbering(repository);
            numberInvoice = invoiceNumbering.getNextNumberInvoice();
        } else {
            invoice = repository.getById(id);
            numberInvoice = invoice.getNumberInvoice();
        }
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
