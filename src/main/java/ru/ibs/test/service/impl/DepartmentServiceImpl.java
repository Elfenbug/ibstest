package ru.ibs.test.service.impl;

import org.springframework.stereotype.Service;
import ru.ibs.test.model.Department;
import ru.ibs.test.repository.DepartmentRepository;
import ru.ibs.test.service.DepartmentService;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department get(Long id) {
        return departmentRepository.getById(id);
    }

    @Override
    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public void update(Department department, Long id) {
        if (departmentRepository.findById(id).orElse(null) != null) {
            department.setId(id);
            departmentRepository.save(department);
        }
    }
}
