package com.example.springBootDemo.controller;

import com.example.springBootDemo.entity.Department;
import com.example.springBootDemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/department")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }
    @PostMapping("/departments")
    public List<Department> saveDepartments(@RequestBody List<Department> departments) {
        return departmentService.saveDepartments(departments);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/departments/{departmentId}")
    public Department fetchDepartmentById(@PathVariable("departmentId") Long departmentId){
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{departmentId}")
    public String deleteDepartmentById(@PathVariable("departmentId") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);

        return "Department deleted Successfully!";
    }

    @PutMapping("/departments/{departmentId}")
    public Department updateDepartment(@PathVariable("departmentId") Long departmentId, @RequestBody Department newDepartment){
        return departmentService.updateDepartment(departmentId, newDepartment);
    }
}
