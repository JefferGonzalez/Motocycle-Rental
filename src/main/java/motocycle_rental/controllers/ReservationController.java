package motocycle_rental.controllers;

import motocycle_rental.models.Reservation;
import motocycle_rental.repositories.ReservationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Reservation")

public class ReservationController {

    @Autowired
    private ReservationInterface reservationInterface;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationInterface.findAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Reservation reservation){
        reservationInterface.save(reservation);
    }

}

/* DOCUMENTACIÓN DE LA CLASE

@RestControler: Esta anotación se utiliza para crear un controlador RESTful. Esta anotación es una combinación de @Controller y @ResponseBody.
@RequestMappin: Esta anotación se utiliza para mapear solicitudes web en métodos de controlador específicos. Se puede usar en el nivel de clase y en el nivel de método.
@GetMapping: Esta anotación se utiliza para mapear solicitudes HTTP GET en métodos de controlador específicos.
@PostMapping: Esta anotación se utiliza para mapear solicitudes HTTP POST en métodos de controlador específicos.
*/
