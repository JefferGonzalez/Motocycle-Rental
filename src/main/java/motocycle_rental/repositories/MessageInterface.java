package motocycle_rental.repositories;

import motocycle_rental.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageInterface extends CrudRepository<Message, Integer> {
}
