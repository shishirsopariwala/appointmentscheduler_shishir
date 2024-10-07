package com.shishir.appointmentscheduler.service.impl;

import com.shishir.appointmentscheduler.entities.Appointment;
import com.shishir.appointmentscheduler.entities.Employees;
import com.shishir.appointmentscheduler.service.AppointmentService;
import com.shishir.appointmentscheduler.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    public List<Appointment> appointments;
    public List<Employees> employees;
    private final EmployeeService employeeService;

    public AppointmentServiceImpl(List<Appointment> appointments, List<Employees> employees,EmployeeService employeeService) {

        appointments = new ArrayList<>();
        employees = new ArrayList<>();

        employees.add(new Employees(9001L,"Raj","Mehta"));

        employees.add(new Employees(9002L,"Scott","Travis"));

        appointments.add(new Appointment(1001L,"SpringDemo","Spring detail demo", LocalDateTime.of(2024,10,9,13,00),LocalDateTime.of(2024,10,9,14,00),"Scheduled",9001L,employees));

        this.appointments = appointments;
        this.employees = employees;
        this.employeeService = employeeService;

    }

    @Override
    public List<Appointment> getAppointments() {
        return this.appointments;
    }

    @Override
    public Appointment getAppointment(Long aptId) {
        Appointment apt = null;
        for (Appointment appointment:appointments)
        {
            Long lclAptId = appointment.getAptId();
            if( Long.compare(lclAptId,aptId)==0)
            {
                apt = appointment;
                break;
            }
        }
        return apt;
    }

    @Override
    public String createAppointment(Appointment appointment) {
        List<Employees> empList = appointment.getEmployeeList();
        String retMessage = "";

        for(Employees empAvailabilityChk : empList)
        {
            Long empAvlChkId = empAvailabilityChk.getEmpId();
            List<Appointment> empAppointment = this.getMyAppointments(empAvlChkId);
            for(Appointment empApt : empAppointment) {
                if((appointment.getStart().isAfter(empApt.getStart()) || appointment.getStart().isEqual(empApt.getStart())) && appointment.getStart().isBefore(empApt.getEnd()))
                {
                    retMessage += " Appointment can't be created because of conflict of Appointment of employeee "+empAvailabilityChk.getEmpId();
                } else if (appointment.getStart().isBefore(empApt.getStart()) && ((appointment.getEnd().isBefore(empApt.getEnd())||appointment.getEnd().isEqual(empApt.getEnd())) && appointment.getEnd().isAfter(empApt.getStart()))) {
                    retMessage += " Appointment can't be created because of conflict of Appointment of employeee "+empAvailabilityChk.getEmpId();
                }
            }

        }

        if (retMessage == "") {
            for (Employees emp : empList) {
                Long empId = emp.getEmpId();
                boolean empExist = this.employeeService.existEmployee(empId);

                if (empExist == false) {
                    this.employeeService.addEmployee(emp);
                }
            }
        }

        if (retMessage=="") {
            this.appointments.add(appointment);
            retMessage = "Appointment created successfully";
            return retMessage;
        }
        else
        {
            return retMessage;
        }
    }

    @Override
    public String deleteAppointment(Appointment appointment) {
       // this.appointments.remove(appointment);
        for (Appointment appList:appointments)
        {
            Long lclAptId = appList.getAptId();
            if( Long.compare(lclAptId,appointment.getAptId())==0)
            {
                appointments.remove(appList);
            }
        }
        return "Appointment Deleted Successfully";
    }

    @Override
    public String updateAppointment(Appointment appointment) {
        for (Appointment appList:appointments)
        {
            Long lclAptId = appList.getAptId();
            if( Long.compare(lclAptId,appointment.getAptId())==0)
            {
                appList.setStart(appointment.getStart());
                appList.setEnd(appointment.getEnd());
            }
        }
        return "Appointment updated successfully";
    }

    @Override
    public List<Appointment> getMyAppointments(Long empId) {
        List<Appointment> apt = new ArrayList();
        for (Appointment appointment:appointments)
        {
            List<Employees> empList = appointment.getEmployeeList();

                    for(Employees emp : empList)
                    {
                        Long empListId = emp.getEmpId();

                        if( Long.compare(empListId, empId) == 0 )
                        {
                            apt.add(appointment);
                        }

                    }

            }
    return apt;
    }

    @Override
    public String unsubAppointment(List<Appointment> lstAppointment) {


        for (Appointment appointment:appointments)
        {

            for (Appointment app:lstAppointment)
            {
                Long lclAptId = app.getAptId();
                if( Long.compare(lclAptId,appointment.getAptId())==0)
                {
                    Long delEmpId = app.getEmployeeList().getFirst().getEmpId();
                    List<Employees> empl = appointment.getEmployeeList();
                    for(Employees emplLst:empl)
                    {
                        Long empId = emplLst.getEmpId();
                        if(Long.compare(delEmpId,empId)==0)
                        {
                            empl.remove(emplLst);
                        }
                    }
                }
            }


        }

        return "Employee successfully unsubscribed from Appointments";
    }
}
