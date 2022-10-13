package motocycle_rental;

import motocycle_rental.models.Score;
import motocycle_rental.repositories.ScoreInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MotocycleRentalApplication {

	@Autowired
	ScoreInterface scoreInterface;

	public static void main(String[] args) {
		SpringApplication.run(MotocycleRentalApplication.class, args);
	}

	@Bean
	void applicationRunner() {
		scoreInterface.save(new Score(1, "Pésimo", null));
		scoreInterface.save(new Score(2, "Malo", null));
		scoreInterface.save(new Score(3, "Regular", null));
		scoreInterface.save(new Score(4, "Bueno", null));
		scoreInterface.save(new Score(5, "Excelente", null));
	}

}
