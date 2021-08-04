package app.controller;

import app.model.Invoice;
import app.model.InvoiceRepository;
import app.view.InvoiceView;
import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {

    private final InvoiceRepository repository;

    InvoiceController(InvoiceRepository repository) {
        this.repository = repository;
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
    Invoice newInvoice(@RequestBody Invoice newInvoice) {
        return repository.save(newInvoice);
    }
//    public void saveNewInvoice() {
//        System.out.println("test");
//    }
}
