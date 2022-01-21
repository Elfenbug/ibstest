package ru.ibs.test.controller;

import org.springframework.web.bind.annotation.*;
import ru.ibs.test.dto.PersonDto;
import ru.ibs.test.model.Person;
import ru.ibs.test.service.PersonService;

import java.time.LocalDate;
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
    public void add(@RequestBody PersonDto personDto) {
        personService.save(personDto);
    }

    @PostMapping("/update/{id}")
    public void update(@RequestBody PersonDto personDto, @PathVariable Long id) {
        personService.update(personDto, id);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }

    @PostMapping("/findByLastname")
    public List<Person> showByLastname(@RequestBody String lastname) {
        return personService.findByLastname(lastname);
    }

    @PostMapping("/findByBirthday")
    public List<Person> showByBirthday(@RequestBody LocalDate birthday) {
        return personService.findByBirthday(birthday);
    }

    @PostMapping("/findByDepartment")
    public List<Person> showByDepartmentShortName(@RequestBody String departmentShortName) {
        return personService.findByDepartment(departmentShortName);
    }
}
