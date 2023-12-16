package com.example.javademo.services;

import com.example.javademo.models.Doctor;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    List<Doctor> obtenerDoctores();

    ResponseEntity<?> obtenterDoctorByCedula(int cedula);

    ResponseEntity<?> createDoctor(Doctor doctor);

    Optional<Doctor> obtenerDoctorPorId(String id);
}
