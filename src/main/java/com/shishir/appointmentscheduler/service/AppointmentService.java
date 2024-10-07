package com.shishir.appointmentscheduler.service;

import com.shishir.appointmentscheduler.entities.Appointment;

import java.util.List;

public interface AppointmentService {
    public List<Appointment> getAppointments();
    public Appointment getAppointment(Long aptId);
    public String createAppointment(Appointment appointment);
    public String deleteAppointment(Appointment appointment);
    public String updateAppointment(Appointment appointment);
    public List<Appointment> getMyAppointments(Long empId);
    public String unsubAppointment(List<Appointment> lstAppointment);
}
