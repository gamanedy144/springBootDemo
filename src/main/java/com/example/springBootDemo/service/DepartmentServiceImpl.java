package com.example.springBootDemo.service;

import com.example.springBootDemo.entity.Department;
import com.example.springBootDemo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> saveDepartments(List<Department> departments) {
        return departmentRepository.saveAll(departments);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department newDepartment) {
        Department depDB = departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(newDepartment.getDepartmentName()) && !"".equalsIgnoreCase(newDepartment.getDepartmentName())){
            depDB.setDepartmentName(newDepartment.getDepartmentName());
        }
        if(Objects.nonNull(newDepartment.getDepartmentAddress()) && !"".equalsIgnoreCase(newDepartment.getDepartmentAddress())){
            depDB.setDepartmentAddress(newDepartment.getDepartmentAddress());
        }
        if(Objects.nonNull(newDepartment.getDepartmentCode()) && !"".equalsIgnoreCase(newDepartment.getDepartmentCode())){
            depDB.setDepartmentCode(newDepartment.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

}
