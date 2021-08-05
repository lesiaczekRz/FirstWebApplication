package app.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    @Query(value = "select number_invoice from invoice order by id desc limit 1", nativeQuery = true)
    String getLastNumberVoice();
}
