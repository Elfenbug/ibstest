package ru.ibs.test.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ibs.test.dto.PersonDto;
import ru.ibs.test.model.Person;
import ru.ibs.test.repository.PersonRepository;
import ru.ibs.test.service.PersonService;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @Transactional
    public void save(PersonDto personDto) {
        ModelMapper mapper = new ModelMapper();
        Person person = mapper.map(personDto, Person.class);
        person.setVersionId(0L);
        person.setDateCreated(LocalDateTime.now());
        person.setActive(true);
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
    @Transactional
    public void update(PersonDto personDto, Long personId) {
        if (personRepository.findPersonByPersonId(personId) != null) {
            ModelMapper mapper = new ModelMapper();
            Person person = mapper.map(personDto, Person.class);
            person.setPersonId(personDto.getPersonId());
            person.setVersionId(personRepository.findPersonByPersonIdAndActiveTrue(personId).getVersionId() + 1);
            person.setDateCreated(LocalDateTime.now());
            person.setActive(true);
            personRepository.findPersonByPersonIdAndActiveTrue(personId).setActive(false);
            personRepository.save(person);
        }
    }

    @Override
    public List<Person> findByLastname(String lastname) {
        return personRepository.findByLastname(lastname);
    }

    @Override
    public List<Person> findByBirthday(LocalDate birthday) {
        return personRepository.findByBirthday(birthday);
    }

    @Override
    public List<Person> findByDepartment(String departmentShortName) {
        return personRepository.findByDepartment_ShortName(departmentShortName);
    }

    @Override
    public Person findPersonByPersonIdAndActiveTrue(Long personId) {
        return personRepository.findPersonByPersonIdAndActiveTrue(personId);
    }

    @Override
    public void updateWithVersion(Person person, Long id) {

    }
}
