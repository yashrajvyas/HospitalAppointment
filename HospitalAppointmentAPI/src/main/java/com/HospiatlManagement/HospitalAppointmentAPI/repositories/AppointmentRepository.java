package com.HospiatlManagement.HospitalAppointmentAPI.repositories;

import com.HospiatlManagement.HospitalAppointmentAPI.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {

    List<AppointmentEntity> findByDoctorName(String doctorName);

    List<AppointmentEntity> findByDepartment(String department);

    List<AppointmentEntity> findByStatus(String status);

    List<AppointmentEntity> findByFeesLessThanEqual(Double fees);

}
