package com.example.javademo.controllers;
import com.example.javademo.services.DoctorService;
import com.example.javademo.models.Doctor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    // Constructor
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // Obtener todos los doctores
    @GetMapping
    public List<Doctor> obtenerDoctores() {
        return doctorService.obtenerDoctores();
    }

    // Obtener un doctor por su cédula
    @GetMapping("/cedula/{cedula}")
    public ResponseEntity<?> obtenterDoctorByCedula(@PathVariable int cedula) {
        return doctorService.obtenterDoctorByCedula(cedula);
    }

    // Crear un doctor
    @PostMapping
    public ResponseEntity<?> createDoctor(@RequestBody Doctor doctor) {
        return doctorService.createDoctor(doctor);
    }

    // Obtener un doctor por su ID
    @GetMapping("/{id}")
    public Optional<Doctor> obtenerDoctorPorId(@PathVariable String id) {
        return doctorService.obtenerDoctorPorId(id);
    }


}
