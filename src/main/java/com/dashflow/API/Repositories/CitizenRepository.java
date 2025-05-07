package com.dashflow.API.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dashflow.Domain.Entities.Citizen;


public interface CitizenRepository extends MongoRepository<Citizen, String> {
	Citizen findByCpf(String cpf);
}
