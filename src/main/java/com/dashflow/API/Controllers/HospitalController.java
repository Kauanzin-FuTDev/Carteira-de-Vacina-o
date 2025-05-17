package com.dashflow.API.Controllers;

import com.dashflow.API.Services.HospitalsService;
import com.dashflow.Domain.Entities.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    @Autowired
    private HospitalsService hospitalsService;


    public HospitalController(HospitalsService hospitalsService) {
        this.hospitalsService = hospitalsService;
    }



    //Get
    @GetMapping
    public ResponseEntity<List<Hospital>> getAllHospitals(){
        return ResponseEntity.ok().body(hospitalsService.getAllHospitals());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospital> getHospitalById(@PathVariable String id){
        return ResponseEntity.ok().body(hospitalsService.getHospitalById(id));
    }



    //POST
    @PostMapping
    public ResponseEntity<Void> createHospital(@RequestBody Hospital newData){
        hospitalsService.createHospital(newData);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{hospitalId}/citizens/{citizenId}")
    public ResponseEntity<Void> addCitizen(@PathVariable String hospitalId ,@PathVariable String citizenId){
        hospitalsService.addCitizen(hospitalId,citizenId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //Update
    @PatchMapping("/{id}")
    public ResponseEntity<Hospital> updateHospital(@RequestBody Hospital newData, @PathVariable String id){
        return ResponseEntity.ok().body(hospitalsService.updateHospital(newData ,id));
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHospital(@PathVariable String id){
        hospitalsService.deleteHospital(id);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }

    @DeleteMapping("/{hospitalId}/citizen/{citizenid}")
    public ResponseEntity<Void> deleteCitizenFromHospital(@PathVariable String hospitalId, @PathVariable String citizenid){
        hospitalsService.deleteCitizenFromHospital(hospitalId, citizenid);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }

}
