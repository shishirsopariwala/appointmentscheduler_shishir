package com.shishir.appointmentscheduler.controller;

import com.shishir.appointmentscheduler.entities.Appointment;
import com.shishir.appointmentscheduler.entities.Employees;
import com.shishir.appointmentscheduler.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employees> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{empId}")
    public Employees getEmployee(@PathVariable String empId){
        return this.employeeService.getEmployee(Long.parseLong(empId));
    }

    @PostMapping("/employees")
    public Employees addEmployee(@RequestBody Employees emp){
        return this.employeeService.addEmployee(emp);
    }

}
