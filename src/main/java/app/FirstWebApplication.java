package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class FirstWebApplication {

	public static void main(String[] args) {
		setUp();
		SpringApplication.run(FirstWebApplication.class, args);
	}

	private static void setUp() {
		Locale polishLocale = Locale.forLanguageTag("pl-PL");
		Locale.setDefault(polishLocale);
	}
}
