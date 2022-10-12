package motocycle_rental.controllers;

import motocycle_rental.models.Client;
import motocycle_rental.models.Score;
import motocycle_rental.repositories.ClientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Client")
@CrossOrigin(origins = "*")
public class ClientController {
    @Autowired
    private ClientInterface clientInterface;

    @GetMapping("/all")
    public List<Client> getAll(){
        return (List<Client>) clientInterface.findAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)

    public void save(@RequestBody Client client) {
        clientInterface.save(client);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody Client client) {
        clientInterface.save(client);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        clientInterface.deleteById(id);
    }
}
