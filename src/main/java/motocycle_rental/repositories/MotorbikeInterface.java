package motocycle_rental.repositories;

import motocycle_rental.models.Motorbike;
import org.springframework.data.repository.CrudRepository;

public interface MotorbikeInterface extends CrudRepository<Motorbike, Integer> {
}
