package app.controller;

import app.model.InvoiceRepository;
import app.view.InvoiceView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {

    private final InvoiceRepository repository;

    InvoiceController(InvoiceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/invoices")
    public String displayAll() {
        return InvoiceView.displayInvoices(repository.findAll());
    }
}
