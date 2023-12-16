package com.example.javademo.repositories;

import com.example.javademo.models.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {
    // Definir consultas personalizadas si es necesario

    Optional<Doctor> findByCedula(int cedula);
    Optional<Doctor> findBySpeciality(String speciality);
    boolean existsBySpeciality(String speciality);
}