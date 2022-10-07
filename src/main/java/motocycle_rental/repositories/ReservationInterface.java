package motocycle_rental.repositories;

import motocycle_rental.models.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationInterface extends CrudRepository<Reservation, Integer> {
}
