package com.example.javademo.controllers;

import com.example.javademo.models.Patient;
import com.example.javademo.services.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    // Constructor
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // Obtener todos los pacientes
    @GetMapping
    public List<Patient> obtenerPatients() {
        return patientService.obtenerPatients();
    }

    // Obtener un paciente por su ID
    @GetMapping("/{id}")
    public Optional<Patient> obtenerPatientById(@PathVariable String id) {
        return patientService.obtenerPatientById(id);
    }

    // Obtener un paciente por su cédula
    @GetMapping("/cedula/{cedula}")
    public Optional<Patient> obtenerPatientByCedula(@PathVariable int cedula) {
        return patientService.obtenerPatientByCedula(cedula);
    }

    // Crear un paciente
    @PostMapping
    public ResponseEntity<?> crearPaciente(@RequestBody Patient patient) {
        return patientService.crearPaciente(patient);
    }

    // Eliminar un paciente por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatientById(@PathVariable String id) {
        return patientService.deletePatientById(id);
    }
}
