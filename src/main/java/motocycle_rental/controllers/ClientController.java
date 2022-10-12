package motocycle_rental.controllers;

import motocycle_rental.models.Client;
import motocycle_rental.repositories.ClientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Client")
@CrossOrigin(origins = "*")
public class ClientController {
    @Autowired
    private ClientInterface clientInterface;

    @GetMapping("/all")
    public List<Client> getAll() {
        return (List<Client>) clientInterface.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> searchForId(@PathVariable Integer id) {
        return clientInterface.findById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)

    public Client save(@RequestBody Client client) {
        return clientInterface.save(client);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client) {
        return clientInterface.save(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        clientInterface.deleteById(id);
    }

}
