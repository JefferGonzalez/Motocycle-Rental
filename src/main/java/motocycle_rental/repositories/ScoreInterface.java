package motocycle_rental.repositories;

import motocycle_rental.models.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreInterface extends CrudRepository<Score, Integer> {
}
