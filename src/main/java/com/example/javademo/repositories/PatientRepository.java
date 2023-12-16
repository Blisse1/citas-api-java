package com.example.javademo.repositories;

import com.example.javademo.models.Patient;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
    // Definir consultas personalizadas si es necesario
    Optional<Patient> findByCedula(int cedula);

    boolean existsByCedula(int cedula);

}