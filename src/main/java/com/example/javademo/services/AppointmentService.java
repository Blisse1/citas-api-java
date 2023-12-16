package com.example.javademo.services;

import com.example.javademo.models.Appointment;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    List<Appointment> obtenerAppointments();

    ResponseEntity<?> crearCita(Appointment appointment);

    Optional<Appointment> obtenerCitaById(String id);
}
