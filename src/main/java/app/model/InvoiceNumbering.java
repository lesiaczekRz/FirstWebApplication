package app.model;

import java.util.Calendar;

public class InvoiceNumbering {

    private final InvoiceRepository repository;

    public InvoiceNumbering(InvoiceRepository repository) {
        this.repository = repository;
    }

    /**
     * Pobiera następny numer faktury
     *
     * @return String|null
     */
    public String getNextNumberInvoice() {
        String lastNumber = repository.getLastNumberVoice();
        int n;
        if (lastNumber == null) {
            lastNumber = "0/0";
        }
        String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        String[] arrayNumber = lastNumber.split("/");
        if (year.equals(arrayNumber[1])) {
            n = Integer.parseInt(arrayNumber[0]) + 1;
        } else {
            n = 1;
        }
        return n + "/" + year;
    }
}
