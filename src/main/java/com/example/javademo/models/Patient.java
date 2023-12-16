package com.example.javademo.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "patients")
public class Patient {
    @Id
    private String id;
    private String name;
    private String lastName;
    private int cedula;
    private int age;
    private int phone;

    public Patient(String id, String name, String lastName, int cedula, int age, int phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.cedula = cedula;
        this.age = age;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.name = String.valueOf(age);
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.name = String.valueOf(phone);
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }



    public Number getCedula() {
        return cedula;
    }




}
