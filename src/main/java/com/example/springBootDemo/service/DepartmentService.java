package com.example.springBootDemo.service;

import com.example.springBootDemo.entity.Department;
import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> saveDepartments(List<Department> departments);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId);

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department newDepartment);

    Department fetchDepartmentByName(String departmentName);
}
