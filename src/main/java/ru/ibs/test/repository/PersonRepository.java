package ru.ibs.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.test.model.Department;
import ru.ibs.test.model.Person;

import java.time.LocalDate;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByLastname(String lastname);
    List<Person> findByBirthday(LocalDate birthday);
    List<Person> findByDepartment_ShortName(String departmentShortName);
}
