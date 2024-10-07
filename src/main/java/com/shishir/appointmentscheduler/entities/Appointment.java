package com.shishir.appointmentscheduler.entities;

import java.time.LocalDateTime;
import java.util.List;

public class Appointment {

    private Long aptId;
    private String aptTitle;
    private String aptDescription;
    private LocalDateTime start;
    private LocalDateTime end;
    private String aptStatus;
    private Long ownerEmpId;
    private List<Employees> EmployeeList;

    public Appointment() {
    }

    public Appointment(Long aptId, String aptTitle, String aptDescription, LocalDateTime start, LocalDateTime end, String aptStatus, Long ownerEmpId, List<Employees> employeeList) {
        this.aptId = aptId;
        this.aptTitle = aptTitle;
        this.aptDescription = aptDescription;
        this.start = start;
        this.end = end;
        this.aptStatus = aptStatus;
        this.ownerEmpId = ownerEmpId;
        EmployeeList = employeeList;
    }

    public Long getAptId() {
        return aptId;
    }

    public void setAptId(Long aptId) {
        this.aptId = aptId;
    }

    public String getAptTitle() {
        return aptTitle;
    }

    public void setAptTitle(String aptTitle) {
        this.aptTitle = aptTitle;
    }

    public String getAptDescription() {
        return aptDescription;
    }

    public void setAptDescription(String aptDescription) {
        this.aptDescription = aptDescription;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getAptStatus() {
        return aptStatus;
    }

    public void setAptStatus(String aptStatus) {
        this.aptStatus = aptStatus;
    }

    public List<Employees> getEmployeeList() {
        return EmployeeList;
    }

    public void setEmployeeList(List<Employees> employeeList) {
        EmployeeList = employeeList;
    }

    public Long getOwnerEmpId() {
        return ownerEmpId;
    }

    public void setOwnerEmpId(Long ownerEmpId) {
        this.ownerEmpId = ownerEmpId;
    }

}
