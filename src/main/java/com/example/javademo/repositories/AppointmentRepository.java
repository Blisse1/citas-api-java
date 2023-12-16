package com.example.javademo.repositories;

import com.example.javademo.models.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, String> {
    // Definir consultas personalizadas si es necesario
    boolean existsByCedulaAndSpecialityAndDate(int cedula, String speciality, String date);

}