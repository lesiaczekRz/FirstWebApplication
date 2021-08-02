package app.controller;

import app.model.Facture;
import app.model.FactureRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FactureController {

    private final FactureRepository repository;

    FactureController(FactureRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/factures")
     List<Facture> all() {
        return repository.findAll();
    }
}
