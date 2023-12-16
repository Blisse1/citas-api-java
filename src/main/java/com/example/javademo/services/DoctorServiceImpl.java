package com.example.javademo.services;

import com.example.javademo.ErrorResponse;
import com.example.javademo.models.Doctor;
import com.example.javademo.repositories.DoctorRepository;
import com.example.javademo.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> obtenerDoctores() {
        return doctorRepository.findAll();
    }

    @Override
    public ResponseEntity<?> obtenterDoctorByCedula(int cedula) {
        Optional<Doctor> doctorOptional = doctorRepository.findByCedula(cedula);

        if (doctorOptional.isPresent()) {
            Doctor doctor = doctorOptional.get();
            return ResponseEntity.ok(doctor);
        } else {
            String errorMessage = "No se encontró un doctor con la cédula proporcionada";
            ErrorResponse errorResponse = new ErrorResponse(errorMessage);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @Override
    public ResponseEntity<?> createDoctor(Doctor doctor) {

        Optional<Doctor> doctorBySpeciality = doctorRepository.findBySpeciality(doctor.getSpeciality());
        if (doctorBySpeciality.isPresent()) {
            String errorMessage = "Ya existe un doctor con la misma especialidad";
            ErrorResponse errorResponse = new ErrorResponse(errorMessage);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        // Verificar si ya existe esa cédula
        Optional<Doctor> doctorByCedula = doctorRepository.findByCedula(doctor.getCedula());
        if (doctorByCedula.isPresent()) {
            String errorMessage = "Ya existe un doctor con la misma cédula";
            ErrorResponse errorResponse = new ErrorResponse(errorMessage);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        // Guardar el doctor en la base de datos
        doctor.setDoctorName(doctor.getName());
        doctorRepository.save(doctor);

        return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
    }

    @Override
    public Optional<Doctor> obtenerDoctorPorId(String id) {
        return doctorRepository.findById(id);
    }
}
