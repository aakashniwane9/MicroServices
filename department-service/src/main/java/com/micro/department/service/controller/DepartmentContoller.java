package com.micro.department.service.controller;

import com.micro.department.service.entity.Department;
import com.micro.department.service.services.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentContoller {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside saveDepartment -> DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/get")
    public Department findDepartmentById(@RequestParam(value = "id") Long departmentId) {
        log.info("Inside findDepartmentById -> DepartmentController");
        return departmentService.findDepartmentById(departmentId);
    }

}
