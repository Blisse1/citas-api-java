package com.example.javademo.services;

import com.example.javademo.ErrorResponse;
import com.example.javademo.SuccessResponse;
import com.example.javademo.models.Patient;
import com.example.javademo.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> obtenerPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> obtenerPatientById(String id) {
        return patientRepository.findById(id);
    }

    @Override
    public Optional<Patient> obtenerPatientByCedula(int cedula) {
        return patientRepository.findByCedula(cedula);
    }

    @Override
    public ResponseEntity<?> crearPaciente(Patient patient) {
        // Verificar si la cedula ya existe en otro paciente
        if (patientRepository.existsByCedula((Integer) patient.getCedula())) {
            String errorMessage = "Ya existe un paciente con la misma cédula";
            ErrorResponse errorResponse = new ErrorResponse(errorMessage);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        // Guardar el paciente en la base de datos

        patientRepository.save(patient);

        return ResponseEntity.status(HttpStatus.CREATED).body(patient);
    }

    @Override
    public ResponseEntity<?> deletePatientById(String id) {

        // Verificar si el paciente existe por su ID
        if (!patientRepository.existsById(id)) {
            String errorMessage = "No se encontró un paciente con el ID proporcionado";
            ErrorResponse errorResponse = new ErrorResponse(errorMessage);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        patientRepository.deleteById(id);

        String successMessage = "El paciente ha sido eliminado correctamente";
        SuccessResponse successResponse = new SuccessResponse(successMessage);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }
    }

