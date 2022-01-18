package ru.ibs.test.service.impl;

import org.springframework.stereotype.Service;
import ru.ibs.test.model.Person;
import ru.ibs.test.repository.PersonRepository;
import ru.ibs.test.service.PersonService;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person get(Long id) {
        return personRepository.getById(id);
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public void update(Person person, Long id) {
        if (personRepository.findById(id).orElse(null) != null) {
            person.setId(id);
            personRepository.save(person);
        }
    }
}
