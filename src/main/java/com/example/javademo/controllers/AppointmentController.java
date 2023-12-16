package com.example.javademo.controllers;
import com.example.javademo.models.Appointment;
import com.example.javademo.services.AppointmentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    // Constructor
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // Obtener todas las citas
    @GetMapping
    public List<Appointment> obtenerAppointments() {
        return appointmentService.obtenerAppointments();
    }

    // Crear una cita para un usuario existente
    @PostMapping
    public ResponseEntity<?> crearCita(@RequestBody Appointment appointment) {
        return appointmentService.crearCita(appointment);
    }

    // Obtener un cita por su ID
    @GetMapping("/{id}")
    public Optional<Appointment> obtenerCitaById(@PathVariable String id) {
        return appointmentService.obtenerCitaById(id);
    }
}


