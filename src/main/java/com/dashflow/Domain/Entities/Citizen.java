package com.dashflow.Domain.Entities;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "citizens")
public class Citizen implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String name;
    private String surname;

    private String email;
    private String password;

    private String city;
    private String state;

    private String cpf;
    private String phone;
    
    private List<Vacine> vacines;
 
    public Citizen() {
    }

    public Citizen(String id, String surname, String name, String email, String password) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Citizen(String id, String name, String surname, String email, String password, String city, String phone, String cpf, String state) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.city = city;
        this.phone = phone;
        this.cpf = cpf;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public List<Vacine> getVacines() {
        return vacines;
    }
    
    public void addVacine(Vacine vacine) {
    	this.vacines.add(vacine);
    }
    
    public void removeVacine(Vacine vacine) {
    	this.vacines.remove(vacine);
    }
}
