package app.controller;

import app.model.Invoice;
import app.model.InvoiceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvoiceController {

    private final InvoiceRepository repository;

    InvoiceController(InvoiceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/invoices")
     List<Invoice> all() {
        return repository.findAll();
    }
}
