package com.dashflow.Domain.Entities;

import java.awt.*;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Document(collection = "hospital")
public class Hospital implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private String address;
	private String CNPJ;
	private String Email;
	private String password;
	private String phone;


	private List<Citizen> citizens = new ArrayList<>();

	public Hospital() {

	}

	public Hospital(String name, String address, String CNPJ, String Email, String password, String phone) {
		this.name = name;
		this.address = address;
		this.CNPJ = CNPJ;
		this.Email = Email;
		this.password = password;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getPassword() {
		return password;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return Email;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }

	//metodos de add citizen e remove-lo

	public void addCitizen(Citizen citizen) {
		this.citizens.add(citizen);
	}

	public void removeCitizen(Citizen citizen) {
		this.citizens.remove(citizen);
	}
}
