package app.controller;

import app.model.InvoiceModel;
import app.model.InvoiceRepository;
import app.model.WrongParameter;
import app.view.InvoiceView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/save-new-invoice")
    public String saveNewInvoice(@RequestParam Map<String, String> body) {
        try {
            repository.save(invoiceModel.changeBodyToInvoice(body));
            return displayInvoices();
        } catch (WrongParameter e) {
            return e.getMessage();
        }
    }
}
