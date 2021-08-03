package app.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(InvoiceRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Invoice(10.50f,
                    new SimpleDateFormat("yyyyMMdd").parse("20210802"))));
            log.info("Preloading " + repository.save(new Invoice(100.00f,
                    new SimpleDateFormat("yyyyMMdd").parse("20210801"))));
        };
    }

}
