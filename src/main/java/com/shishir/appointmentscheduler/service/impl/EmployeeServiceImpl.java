package com.shishir.appointmentscheduler.service.impl;

import com.shishir.appointmentscheduler.entities.Appointment;
import com.shishir.appointmentscheduler.entities.Employees;
import com.shishir.appointmentscheduler.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public List<Employees> employees;

    public EmployeeServiceImpl(List<Employees> employees) {
        employees = new ArrayList<>();
        employees.add(new Employees(9001L,"Raj","Mehta"));
        employees.add(new Employees(9002L,"Tony","Dsouza"));
        this.employees = employees;
    }

    @Override
    public List<Employees> getEmployees() {
        return this.employees;
    }

    @Override
    public Employees getEmployee(Long empId) {
        Employees emp = null;
        for (Employees employee:employees)
        {
            Long lclEmpId = employee.getEmpId();
            if(Long.compare(lclEmpId,empId)==0)
            {
                emp = employee;
                break;
            }
        }
        return emp;
    }

    @Override
    public Employees addEmployee(Employees employee) {
        this.employees.add(employee);
        return employee;
    }

    @Override
    public boolean existEmployee(Long empId) {

        for (Employees employee:employees)
        {
            Long lclEmpId = employee.getEmpId();
            if(Long.compare(lclEmpId,empId)==0)
            {
                return true;
            }
        }
        return false;
    }
}
