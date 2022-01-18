package ru.ibs.test.service;

import ru.ibs.test.model.Person;

import java.util.List;

public interface PersonService {
    Person get(Long id);

    void save(Person person);

    void delete(Long id);

    List<Person> getAll();

    void update(Person person, Long id);
}
