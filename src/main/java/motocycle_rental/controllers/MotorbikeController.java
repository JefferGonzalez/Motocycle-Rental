package motocycle_rental.controllers;

import motocycle_rental.models.Motorbike;
import motocycle_rental.repositories.MotorbikeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Motorbike")
@CrossOrigin(origins = "*")
public class MotorbikeController {

    @Autowired
    private MotorbikeInterface motorbikeInterface;

    @GetMapping("/all")
    public List<Motorbike> getAll() {
        return (List<Motorbike>) motorbikeInterface.findAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Motorbike motorbike) {
        motorbikeInterface.save(motorbike);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody Motorbike motorbike) {
        Optional<Motorbike> moto = motorbikeInterface.findById(motorbike.getId());
        if(moto.isPresent()){
            if(motorbike.getCategory() == null) motorbike.setCategory(moto.get().getCategory());
            motorbikeInterface.save(motorbike);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        motorbikeInterface.deleteById(id);
    }

}
