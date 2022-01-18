package ru.ibs.test.controller;

import org.springframework.web.bind.annotation.*;
import ru.ibs.test.model.Person;
import ru.ibs.test.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/read")
    public List<Person> showAll() {
        return personService.getAll();
    }

    @GetMapping("/read/{id}")
    public Person get(@PathVariable Long id) {
        return personService.get(id);
    }

    @PostMapping("/create")
    public void add(@RequestBody Person person) {
        personService.save(person);
    }

    @PostMapping("/update/{id}")
    public void update(@RequestBody Person person, @PathVariable Long id) {
        personService.update(person, id);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }

    @GetMapping("/findByLastname")
    public List<Person> showByLastName(@RequestBody Person person) {
        return personService.findByLastName(person);
    }
}
