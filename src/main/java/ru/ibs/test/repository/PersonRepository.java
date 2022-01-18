package ru.ibs.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.test.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
