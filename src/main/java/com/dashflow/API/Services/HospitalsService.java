package com.dashflow.API.Services;


import com.dashflow.API.Controllers.Exceptions.CitizenAlreadyExistsException;
import com.dashflow.API.Controllers.Exceptions.ObjectNotFoundException;
import com.dashflow.API.Repositories.HospitalRepository;
import com.dashflow.Domain.Entities.Citizen;
import com.dashflow.Domain.Entities.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class HospitalsService {
    @Autowired
    private CitizenService citizenService;
    @Autowired
    private HospitalRepository hospitalRepository;

        // Constructor injection (recomendado)
        public HospitalsService(HospitalRepository hospitalRepository,
                                CitizenService citizenService) {
            this.hospitalRepository = hospitalRepository;
            this.citizenService = citizenService;
        }

    //metodos get
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    public Hospital getHospitalById(String id) {
        return hospitalRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Hospital nao encontrado!"));
    }


    //metodos post

    public void createHospital(Hospital newData) {
        if(hospitalRepository.existsByCNPJ(newData.getCNPJ())) {
            throw new CitizenAlreadyExistsException("Hospital Ja existe");
        }
        hospitalRepository.save(newData);
    }

    public void addCitizen(String hospitalid, String citizenId) {
        Hospital existingHospital = hospitalRepository.findById( hospitalid).orElseThrow(() -> new ObjectNotFoundException("Hospital nao encontrado!"));
        Citizen newCitizenData = citizenService.getCitizenById(citizenId);
        existingHospital.addCitizen(newCitizenData);
        hospitalRepository.save(existingHospital);
    }

    //Metodos Update
    public Hospital updateHospital(Hospital newData, String id) {
        Hospital existingHospital = hospitalRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Hospital nao encontrado!"));

        if (newData.getName() != null) existingHospital.setName(newData.getName());
        if (newData.getCNPJ() != null) existingHospital.setCNPJ(newData.getCNPJ());
        if (newData.getAddress() != null) existingHospital.setAddress(newData.getAddress());
        if (newData.getEmail() != null) existingHospital.setEmail(newData.getEmail());
        if (newData.getPassword() != null) existingHospital.setPassword(newData.getPassword());
        if (newData.getPhone() != null) existingHospital.setPhone(newData.getPhone());

        return hospitalRepository.save(existingHospital);
    }

    //Metodos Deleted
    public void deleteHospital(String id) {
        if (hospitalRepository.findById(id) != null) {
            hospitalRepository.deleteById(id);
        } else {
            throw new ObjectNotFoundException("Hospital nao encontrado!");
        }
    }

    public void deleteCitizenFromHospital(String id, String citizenId) {
        Hospital existingHospital = hospitalRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Hospital nao encontrado!"));
        Citizen existingCitizen = citizenService.getCitizenById(citizenId);

        if(existingHospital.getCitizens().contains(existingCitizen) == false){
            throw new ObjectNotFoundException(" paciente nao esta registrado neste hospital");
        }

        existingHospital.removeCitizen(existingCitizen);
        hospitalRepository.save(existingHospital);
    }
}

