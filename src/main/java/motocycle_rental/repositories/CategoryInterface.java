package motocycle_rental.repositories;

import motocycle_rental.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryInterface extends CrudRepository<Category, Integer> {
}
