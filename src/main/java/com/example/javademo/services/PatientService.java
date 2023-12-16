package com.example.javademo.services;

import com.example.javademo.models.Patient;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<Patient> obtenerPatients();

    Optional<Patient> obtenerPatientById(String id);

    Optional<Patient> obtenerPatientByCedula(int cedula);

    ResponseEntity<?> crearPaciente(Patient patient);

    ResponseEntity<?> deletePatientById(String id);
}
