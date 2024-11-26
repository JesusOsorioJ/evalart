package com.miempresa.franquicia.repository;

import com.miempresa.franquicia.model.Franquicia;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FranquiciaRepository extends MongoRepository<Franquicia, String> {
}
