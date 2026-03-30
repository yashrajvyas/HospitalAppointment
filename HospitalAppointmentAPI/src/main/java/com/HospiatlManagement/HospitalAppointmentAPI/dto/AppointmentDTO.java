package com.HospiatlManagement.HospitalAppointmentAPI.dto;

import java.time.LocalDate;

public class AppointmentDTO {
    private Long id;
    private String patientName;
    private String doctorName;
    private String department;
    private LocalDate appointmentDate;
    private String status;

    public AppointmentDTO(){}

    public AppointmentDTO(Long id, String patientName, String doctorName, String department, LocalDate appointmentDate, String status) {
        this.id = id;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.department = department;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


