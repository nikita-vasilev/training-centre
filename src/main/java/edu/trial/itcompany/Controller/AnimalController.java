package edu.trial.itcompany.Controller;

import edu.trial.itcompany.DB.entity.Animal;
import edu.trial.itcompany.DB.repository.AnimalRepository;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class AnimalController {

    private final AnimalRepository repository;

    public AnimalController ( AnimalRepository repository ) {
        this.repository = repository;
    }

    @GetMapping("/animals")
    List<Animal> all ( ) {
        return repository.findAll ( );
    }

    @PostMapping("/animals")
    void addAnimal ( @RequestBody Animal animal ) {
        repository.save ( animal );
    }


    @GetMapping("/animals/{id}")
    Animal byId ( @PathVariable Long id ) throws NotFoundException {

        return repository.findById ( id ).orElseThrow ( ( ) -> new NotFoundException ( "No such animal with id:" + id ) );
    }

    @PutMapping("/animals/{id}")
    Animal update ( @RequestBody Animal updatedAnimal, @PathVariable("id") Long id ) {
        return repository.findById ( updatedAnimal.getId ( ) )
                .map ( animal -> {
                    animal.setName ( updatedAnimal.getName ( ) );
                    animal.setSpecies ( updatedAnimal.getSpecies ( ) );
                    animal.setWeight ( updatedAnimal.getWeight ( ) );
                    return repository.save ( animal );
                } )
                .orElseGet ( ( ) -> {
                    updatedAnimal.setId ( id );
                    return repository.save ( updatedAnimal );
                } );

    }

    @DeleteMapping("/animals/{id}")
    void deleteAnimal ( @PathVariable("id") Long id ) {
        repository.deleteById ( id );
    }


}
