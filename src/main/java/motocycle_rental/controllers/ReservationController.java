package motocycle_rental.controllers;

import motocycle_rental.models.Reservation;
import motocycle_rental.repositories.ReservationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Reservation")
@CrossOrigin(origins = "*")
public class ReservationController {

    @Autowired
    private ReservationInterface reservationInterface;

    @GetMapping("/all")
    public List<Reservation> getAll() {
        return (List<Reservation>) reservationInterface.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> searchForId(@PathVariable Integer id) {
        return reservationInterface.findById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationInterface.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationInterface.save(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        reservationInterface.deleteById(id);
    }

}
