package ru.ibs.test.service;

import ru.ibs.test.model.Department;

import java.util.List;

public interface DepartmentService {
    Department get(Long id);

    void save(Department department);

    void delete(Long id);

    List<Department> getAll();

    void update(Department department, Long id);
}
