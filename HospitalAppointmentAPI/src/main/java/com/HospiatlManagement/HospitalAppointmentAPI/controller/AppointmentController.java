package com.HospiatlManagement.HospitalAppointmentAPI.controller;

import com.HospiatlManagement.HospitalAppointmentAPI.dto.AppointmentDTO;
import com.HospiatlManagement.HospitalAppointmentAPI.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public AppointmentDTO bookAppointment(@RequestBody AppointmentDTO appointmentDTO){
        return appointmentService.bookAppointment(appointmentDTO);
    }

    @GetMapping
    public List<AppointmentDTO> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    @GetMapping({"id"})
    public AppointmentDTO appointmentDTO(@PathVariable Long id){
        return appointmentService.getAppointmentById(id);
    }

    @GetMapping({"name"})
    public List<AppointmentDTO> getAppointmentByDoctor(@RequestParam String doctorName){
        return appointmentService.getAppointmentByDoctor(doctorName);
    }

    @GetMapping({"department"})
    public List<AppointmentDTO> getAppointmentByDepartment(@RequestParam String department){
        return appointmentService.getAppointmentsByDepartment(department);
    }

    @GetMapping({"status"})
    public List<AppointmentDTO> getPendingAppointments(@RequestParam String status){
        return appointmentService.getPendingAppointments(status);
    }

    @GetMapping({"fess"})
    public List<AppointmentDTO> getCheapAppointments(@RequestParam Double fees){
        return appointmentService.getCheapAppointments(fees);
    }
}
