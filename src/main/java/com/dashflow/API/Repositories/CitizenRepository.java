package com.dashflow.API.Repositories;

import com.dashflow.Domain.Entities.Citizen;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CitizenRepository extends MongoRepository<Citizen, String> {
}
