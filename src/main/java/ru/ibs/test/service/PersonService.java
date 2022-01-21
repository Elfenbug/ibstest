package ru.ibs.test.service;

import ru.ibs.test.dto.PersonDto;
import ru.ibs.test.model.Person;

import java.time.LocalDate;
import java.util.List;

public interface PersonService {
    Person get(Long id);

    void save(PersonDto personDto);

    void delete(Long id);

    List<Person> getAll();

    void update(PersonDto person, Long id);

    List<Person> findByLastname(String lastname);

    List<Person> findByBirthday(LocalDate birthday);

    List<Person> findByDepartment(String department);

    Person findPersonByPersonIdAndActiveTrue(Long personId);

    void updateWithVersion(Person person, Long id);
}
