package ru.ibs.test.controller;

import org.springframework.web.bind.annotation.*;
import ru.ibs.test.model.Department;
import ru.ibs.test.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/read")
    public List<Department> showAll() {
        return departmentService.getAll();
    }

    @GetMapping("/read/{id}")
    public Department get(@PathVariable Long id) {
        return departmentService.get(id);
    }

    @PostMapping("/create")
    public void add(@RequestBody Department department) {
        departmentService.save(department);
    }

    @PostMapping("/update/{id}")
    public void update(@RequestBody Department department, @PathVariable Long id) {
        departmentService.update(department, id);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        departmentService.delete(id);
    }
}
