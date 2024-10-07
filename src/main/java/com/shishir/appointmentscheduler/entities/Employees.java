package com.shishir.appointmentscheduler.entities;

public class Employees {
    private Long empId;
    private String firstName;
    private String lastname;

    public Employees() {
    }

    public Employees(Long empId, String firstName, String lastname) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
