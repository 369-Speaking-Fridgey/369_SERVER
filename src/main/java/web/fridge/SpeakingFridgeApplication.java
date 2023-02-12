package web.fridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpeakingFridgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeakingFridgeApplication.class, args);
	}

}
