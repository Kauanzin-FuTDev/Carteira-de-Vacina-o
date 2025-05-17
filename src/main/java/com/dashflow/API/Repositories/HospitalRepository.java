package com.dashflow.API.Repositories;

import com.dashflow.Domain.Entities.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HospitalRepository extends MongoRepository<Hospital , String> {
    boolean existsByCNPJ(String CNPJ);
}
