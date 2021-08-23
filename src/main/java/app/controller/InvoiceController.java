package app.controller;

import app.model.InvoiceModel;
import app.model.InvoiceRepository;
import app.model.WrongParameter;
import app.view.InvoiceView;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class InvoiceController {

    private final InvoiceRepository repository;
    private final InvoiceModel invoiceModel;

    InvoiceController(InvoiceRepository repository) {
        this.repository = repository;
        invoiceModel = new InvoiceModel(repository);
    }

    @GetMapping("/invoices")
    public String displayInvoices() {
        return InvoiceView.displayInvoices(repository.findAll());
    }

    @GetMapping("/new-invoice")
    public String newInvoice() {
        return InvoiceView.displayNewInvoice();
    }

    @GetMapping("/invoices/delete/{id}")
    public String toDeleteInvoice(@PathVariable Long id) {
        var val = repository.findById(id);
        if (val.isEmpty()) {
            return "Błąd! Brak rekordu do usunięcia";
        } else {
            return InvoiceView.displayDelete(id, val.get().getNumberInvoice());
        }
    }

    @PostMapping("/save-new-invoice")
    public String saveNewInvoice(@RequestParam Map<String, String> body) {
        try {
            repository.save(invoiceModel.changeBodyToInvoice(body));
            return displayInvoices();
        } catch (WrongParameter e) {
            return "Błąd! " + e.getMessage();
        }
    }

    @DeleteMapping("/invoices/{id}")
    public String deleteInvoice(@PathVariable Long id) {
        repository.deleteById(id);
        return displayInvoices();
    }
}
