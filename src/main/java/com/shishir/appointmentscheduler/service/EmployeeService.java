package com.shishir.appointmentscheduler.service;

import com.shishir.appointmentscheduler.entities.Employees;

import java.util.List;

public interface EmployeeService {

    public List<Employees> getEmployees();
    public Employees getEmployee(Long empId);
    public Employees addEmployee(Employees employee);
    public boolean existEmployee(Long empId);

}
