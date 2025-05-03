package com.dashflow.API.Services;

import com.dashflow.API.Repositories.CitizenRepository;
import com.dashflow.Domain.Entities.Citizen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    public List<Citizen> getAllCitizens() {
        return  citizenRepository.findAll();
    }
}
