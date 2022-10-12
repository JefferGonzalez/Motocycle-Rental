package motocycle_rental.controllers;

import motocycle_rental.models.Motorbike;
import motocycle_rental.models.Score;
import motocycle_rental.repositories.ScoreInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Score")
@CrossOrigin(origins = "*")
public class ScoreController {

        @Autowired
        private ScoreInterface scoreInterface;

        @GetMapping("/all")
        public List<Score> getAll(){
            return (List<Score>) scoreInterface.findAll();
        }

        @PostMapping("/save")
        @ResponseStatus(HttpStatus.CREATED)
        public void save(@RequestBody Score score){
            scoreInterface.save(score);
        }
        @PutMapping("/update")
        @ResponseStatus(HttpStatus.CREATED)
        public void update(@RequestBody Score score) {
            scoreInterface.save(score);
        }
        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void delete(@PathVariable Integer id){
            scoreInterface.deleteById(id);
        }


    }

