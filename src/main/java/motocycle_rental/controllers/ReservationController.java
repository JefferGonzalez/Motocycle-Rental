package motocycle_rental.controllers;

import motocycle_rental.models.Client;
import motocycle_rental.models.Reservation;
import motocycle_rental.models.reports.Clients;
import motocycle_rental.models.reports.Status;
import motocycle_rental.repositories.ReservationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationInterface.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationInterface.save(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        reservationInterface.deleteById(id);
    }

    @GetMapping("/report-dates/{start_date}/{end_date}")
    public List<Reservation> filterDates(@PathVariable String start_date, @PathVariable String end_date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return reservationInterface.findAllByStartDateAfterAndStartDateBefore(format.parse(start_date), format.parse(end_date));
    }

    @GetMapping("/report-status")
    public Status reportStatus() {
        return new Status(reservationInterface.findAllByStatus("completed").size(), reservationInterface.findAllByStatus("cancelled").size());
    }

    @GetMapping("/report-clients")
    public List<Clients> reportClients() {
        List<Clients> report = new ArrayList<>();
        for (Object[] item : reservationInterface.countReservationsByClient()) {
            report.add(new Clients((Long) item[1], (Client) item[0]));
        }
        return report;
    }

}
