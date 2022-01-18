package ru.ibs.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.test.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
