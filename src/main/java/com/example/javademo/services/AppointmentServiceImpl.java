package com.example.javademo.services;

import com.example.javademo.ErrorResponse;
import com.example.javademo.models.Appointment;
import com.example.javademo.models.Doctor;
import com.example.javademo.models.Patient;
import com.example.javademo.repositories.AppointmentRepository;
import com.example.javademo.repositories.PatientRepository;
import com.example.javademo.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Appointment> obtenerAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public ResponseEntity<?> crearCita(Appointment appointment) {
        // Verificar si la especialidad y el paciente existen en sus respectivos repositorios
        if (!doctorRepository.existsBySpeciality(appointment.getSpeciality())) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("La especialidad no existe.")
            );
        }
        if (!patientRepository.existsByCedula(appointment.getCedula())) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("El paciente no existe.")
            );
        }

        // Verificar si ya existe una cita para el mismo paciente, con la misma especialidad y fecha
        boolean existingAppointment = appointmentRepository.existsByCedulaAndSpecialityAndDate(
                appointment.getCedula(),
                appointment.getSpeciality(),
                appointment.getDate()
        );


        if (existingAppointment) {
            // Ya existe una cita para el mismo paciente, especialidad y fecha
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("El paciente ya tiene una cita asignada para esa fecha y especialidad.")
            );
        }

        // Obtener el doctor y el paciente de doctorRepository y patientRepository
        Doctor doctor = doctorRepository.findBySpeciality(appointment.getSpeciality()).orElse(null);
        Patient patient = patientRepository.findByCedula(appointment.getCedula()).orElse(null);

        if (doctor != null && patient != null) {
            // Registrar la cita en la base de datos
            Appointment createdAppointment = appointmentRepository.save(appointment);

            return ResponseEntity.ok(createdAppointment);
        }

        // No se encontró la especialidad o el paciente
        return ResponseEntity.badRequest().body("No se encontró la especialidad o el paciente.");
    }

    @Override
    public Optional<Appointment> obtenerCitaById(String id) {
        return appointmentRepository.findById(id);
    }
}
