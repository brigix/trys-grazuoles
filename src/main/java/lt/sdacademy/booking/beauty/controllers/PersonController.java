package lt.sdacademy.booking.beauty.controllers;

import lt.sdacademy.booking.beauty.models.dto.PersonDTO;
import lt.sdacademy.booking.beauty.models.entities.PersonEntity;
import lt.sdacademy.booking.beauty.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable Integer id) {
        return personService.getPerson(id);
    }

    @PostMapping
    public PersonEntity create(@RequestBody PersonDTO person) {
        return personService.save(person);
    }

    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody PersonDTO personDTO) {
        return personService.save(personDTO) != null ?
            ResponseEntity.status(HttpStatus.OK).body(true) :
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        personService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
