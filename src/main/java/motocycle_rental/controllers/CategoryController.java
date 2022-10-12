package motocycle_rental.controllers;

import motocycle_rental.models.Category;
import motocycle_rental.repositories.CategoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Category")
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private CategoryInterface categoryInterface;

    @GetMapping("/all")
    public List<Category> getAll(){
        return (List<Category>) categoryInterface.findAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)

    public Category save(@RequestBody Category category){
        return categoryInterface.save(category);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category){
        return categoryInterface.save(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        categoryInterface.deleteById(id);
    }

}
