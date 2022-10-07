package motocycle_rental.controllers;

import motocycle_rental.models.Motorbike;
import motocycle_rental.repositories.MotorbikeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Motorbike")
public class MotorbikeController {

    @Autowired
    private MotorbikeInterface motorbikeInterface;

    @GetMapping("/all")
    public List<Motorbike> getAll(){
        return (List<Motorbike>) motorbikeInterface.findAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbike save(@RequestBody Motorbike motorbike){
        return motorbikeInterface.save(motorbike);
    }

}
