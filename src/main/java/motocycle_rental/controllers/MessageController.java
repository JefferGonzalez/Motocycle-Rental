package motocycle_rental.controllers;

import motocycle_rental.models.Message;
import motocycle_rental.repositories.MessageInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Message")
public class MessageController {

    @Autowired
    private MessageInterface messageInterface;

    @GetMapping("/all")
    public List<Message> getAll(){
        return (List<Message>) messageInterface.findAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Message message){
        messageInterface.save(message);
    }

}
