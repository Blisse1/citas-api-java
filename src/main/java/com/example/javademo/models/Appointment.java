package com.example.javademo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "appointments")
public class Appointment {
    @Id
    private String id;
    private String speciality;
    private int cedula;
    private String date;

    public Appointment(String id, String speciality, int cedula, String date) {
        this.id = id;
        this.speciality = speciality;
        this.cedula = cedula;
        this.date = date;
    }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public int getCedula() {
        return cedula;
    }
    public String getSpeciality() {
        return speciality;
    }
    public String getDate() {
        return date;
    }

}
