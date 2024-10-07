package com.shishir.appointmentscheduler.controller;

import com.shishir.appointmentscheduler.entities.Appointment;
import com.shishir.appointmentscheduler.service.AppointmentService;
import com.shishir.appointmentscheduler.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/appointments")
public class AppointmentContoller {

    @Autowired
    private AppointmentService appointmentService;
    //private EmployeeService employeeService;

    public AppointmentContoller(AppointmentService appointmentService, EmployeeService employeeService) {
        this.appointmentService = appointmentService;
       // this.employeeService = employeeService;
    }

    //get all Appointment
    @GetMapping("/appointments")
    public List<Appointment> getAppointments(){
        return appointmentService.getAppointments();
    }

    @GetMapping("/appointments/{aptId}")
    public Appointment getAppointment(@PathVariable String aptId){
        return this.appointmentService.getAppointment(Long.parseLong(aptId));
    }

    @PostMapping("/appointments")
    public String createAppointment(@RequestBody Appointment appointment)
    {

        return this.appointmentService.createAppointment(appointment);
    }

    @DeleteMapping("/appointments")
    public String deleteAppointment(@RequestBody Appointment appointment)
    {

        return this.appointmentService.deleteAppointment(appointment);
    }

    @PatchMapping("/appointments")
    public String updateAppointment(@RequestBody Appointment appointment)
    {
        return this.appointmentService.updateAppointment(appointment);
    }

    @GetMapping("/getMyAppointments/{empId}")
    public List<Appointment> createAppointment(@PathVariable  String empId)
    {
        System.out.println("getMyAppointments");
        return this.appointmentService.getMyAppointments(Long.parseLong(empId));
    }

    @DeleteMapping("/unsubscribeAppointments")
    public String unsubAppointment(@RequestBody List<Appointment> appointment)
    {
        return this.appointmentService.unsubAppointment(appointment);
    }



}
