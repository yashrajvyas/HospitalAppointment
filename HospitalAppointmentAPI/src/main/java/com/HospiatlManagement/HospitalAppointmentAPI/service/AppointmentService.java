package com.HospiatlManagement.HospitalAppointmentAPI.service;

import com.HospiatlManagement.HospitalAppointmentAPI.dto.AppointmentDTO;
import com.HospiatlManagement.HospitalAppointmentAPI.entities.AppointmentEntity;
import com.HospiatlManagement.HospitalAppointmentAPI.repositories.AppointmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final ModelMapper modelMapper;

    public AppointmentService(AppointmentRepository appointmentRepository, ModelMapper modelMapper) {
        this.appointmentRepository = appointmentRepository;
        this.modelMapper = modelMapper;
    }

    public AppointmentDTO bookAppointment(AppointmentDTO appointmentDTO){
        AppointmentEntity appointmentEntity = modelMapper.map(appointmentDTO, AppointmentEntity.class);
        AppointmentEntity savedAppointment = appointmentRepository.save(appointmentEntity);
        return modelMapper.map(savedAppointment, AppointmentDTO.class);
    }

    public List<AppointmentDTO> getAllAppointments(){
        return appointmentRepository.findAll()
                .stream()
                .map(appointmentEntity -> modelMapper.map(appointmentEntity, AppointmentDTO.class))
                .collect(Collectors.toList());
    }

    public AppointmentDTO getAppointmentById(Long id){
        AppointmentEntity appointmentEntity = appointmentRepository.findById(id).orElse(null);
        return modelMapper.map(appointmentEntity, AppointmentDTO.class);
    }

    public List<AppointmentDTO> getAppointmentByDoctor(String doctorName){
        return appointmentRepository.findByDoctorName(doctorName)
                .stream()
                .map(appointmentEntity -> modelMapper.map(appointmentEntity,AppointmentDTO.class))
                .collect(Collectors.toList());
    }

    public List<AppointmentDTO> getAppointmentsByDepartment(String department) {

        return appointmentRepository.findByDepartment(department)
                .stream()
                .map(appointmentEntity -> modelMapper.map(appointmentEntity, AppointmentDTO.class))
                .collect(Collectors.toList());
    }

    public List<AppointmentDTO> getPendingAppointments(String status) {

        return appointmentRepository.findByStatus(status)
                .stream()
                .map(appointmentEntity -> modelMapper.map(appointmentEntity, AppointmentDTO.class))
                .collect(Collectors.toList());
    }

    public List<AppointmentDTO> getCheapAppointments(Double fees) {

        return appointmentRepository.findByFeesLessThanEqual(fees)
                .stream()
                .map(appointmentEntity -> modelMapper.map(appointmentEntity, AppointmentDTO.class))
                .collect(Collectors.toList());
    }
}
