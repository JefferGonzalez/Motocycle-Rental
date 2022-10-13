package motocycle_rental.repositories;

import motocycle_rental.models.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationInterface extends CrudRepository<Reservation, Integer> {

    @Query("SELECT c.client, COUNT (c.client)  FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    List<Object[]> countReservationsByClient();

    List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date startDate, Date startFinish);

    List<Reservation> findAllByStatus(String status);
}
