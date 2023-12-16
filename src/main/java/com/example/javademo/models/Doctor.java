package com.example.javademo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "doctors")
public class Doctor {
    @Id
    private String id;
    private String name;
    private String lastName;
    private String speciality;
    private String email;
    private int cedula;
    private int office;

    public Doctor(String id, String name, String lastName, String speciality, int cedula, int office, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.speciality = speciality;
        this.cedula = cedula;
        this.office = office;
        this.email = email;
    }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public int getOffice() { return office; }
    public void setOffice(int office) { this.office = office; }
    public String getId() {
        return id;
    }
    public String getSpeciality() {
        return speciality;
    }
    public int getCedula() {
        return cedula;
    }
    public void setDoctorName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }



}
