package motocycle_rental.repositories;

import motocycle_rental.models.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientInterface extends CrudRepository<Client, Integer> {
}
