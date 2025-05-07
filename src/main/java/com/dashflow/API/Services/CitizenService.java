package com.dashflow.API.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashflow.API.Controllers.Exceptions.CitizenAlreadyExistsException;
import com.dashflow.API.Controllers.Exceptions.ObjectNotFoundException;
import com.dashflow.API.Repositories.CitizenRepository;
import com.dashflow.Domain.Entities.Citizen;
import com.dashflow.Domain.Entities.Vacine;

@Service
public class CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    //Metodos GETS
    public List<Citizen> getAllCitizens() {
        return citizenRepository.findAll();
    }

    public Citizen getCitizenById(String id) {
        return citizenRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cidadao não encontrado no banco de dados!"));
    }
    
    //Metodos Post
    public void createCitizen(Citizen newData) {
    	if (citizenRepository.findByCpf(newData.getCpf()) != null) {
    		throw new CitizenAlreadyExistsException("Cidadao Ja Registrado Com Esse CPF!");
    	}
    	
    	citizenRepository.save(newData);
    }
    
    public void addVacine(Vacine newVacineData, String id) {
    	Citizen existingCitizen = citizenRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cidadão não encontrado"));
    	existingCitizen.addVacine(newVacineData);
    	citizenRepository.save(existingCitizen);
    }
    
    //Metodos Update
    public Citizen updateCitizen(Citizen newData, String id) {
        Citizen existingCitizen = citizenRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cidadão não encontrado"));

        if (newData.getName() != null) existingCitizen.setName(newData.getName());
        if (newData.getSurname() != null) existingCitizen.setSurname(newData.getSurname());
        if (newData.getEmail() != null) existingCitizen.setEmail(newData.getEmail());
        if (newData.getPassword() != null) existingCitizen.setPassword(newData.getPassword());
        if (newData.getCity() != null) existingCitizen.setCity(newData.getCity());
        if (newData.getState() != null) existingCitizen.setState(newData.getState());
        if (newData.getCpf() != null) existingCitizen.setCpf(newData.getCpf());
        if (newData.getPhone() != null) existingCitizen.setPhone(newData.getPhone());

        return citizenRepository.save(existingCitizen);
    }
    
    //Metodos Delete
    public void deleteCitizen(String id) {
    	if (citizenRepository.findById(id) != null) {
    		citizenRepository.deleteById(id);
    	} else {
    		throw new ObjectNotFoundException("Cidadão Não Encontrado!");
    	}
    }
}
