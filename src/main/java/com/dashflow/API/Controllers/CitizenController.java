package com.dashflow.API.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dashflow.API.Services.CitizenService;
import com.dashflow.Domain.Entities.Citizen;
import com.dashflow.Domain.Entities.Vacine;

@RestController
@RequestMapping("/citizens")
public class CitizenController {

    @Autowired
    private CitizenService citizenService;

    //Get Functions
    @GetMapping
    public ResponseEntity<List<Citizen>> getAllCitizens() {
        return ResponseEntity.ok().body(citizenService.getAllCitizens());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Citizen> getCitizenById(@PathVariable String id) {
        return ResponseEntity.ok().body(citizenService.getCitizenById(id));
    }
    
    @GetMapping("/{id}/vacines")
    public ResponseEntity<List<Vacine>> getAllCitizenVacines(@PathVariable String id) {
        return ResponseEntity.ok().body(citizenService.getAllCitizenVacines(id));
    }
    
    @GetMapping("/{citizenId}/vacines/{vacineId}")
    public ResponseEntity<Vacine> getAllCitizenVacines(@PathVariable String citizenId, @PathVariable String vacineId) {
        return ResponseEntity.ok().body(citizenService.getCitizenVacineById(citizenId, vacineId));
    }
    
    //Post Functions
    @PostMapping
    public ResponseEntity<Void> createCitizen(@RequestBody Citizen newData) {
    	citizenService.createCitizen(newData);
    	return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PostMapping("/{id}/vacines")
    public ResponseEntity<Void> addVacineToCitizen(@RequestBody Vacine vacine, @PathVariable String id) {
    	citizenService.addVacine(vacine, id);
    	return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    //Update Functions
    @PatchMapping("/{id}")
    public ResponseEntity<Citizen> updateCitizen(@RequestBody Citizen newData, @PathVariable String id) {
    	return ResponseEntity.ok().body(citizenService.updateCitizen(newData, id));
    }
    
    //Delete Functions
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCitizen(@PathVariable String id) {
    	citizenService.deleteCitizen(id);
    	return ResponseEntity.status(HttpStatus.GONE).build();
    }
    
    @DeleteMapping("/{citizenId}/vacines/{vacineId}")
    public ResponseEntity<Void> deleteVacineById(@PathVariable String citizenId, @PathVariable String vacineId) {
    	citizenService.deleteVacineById(citizenId, vacineId);
    	return ResponseEntity.status(HttpStatus.GONE).build();
    }
}