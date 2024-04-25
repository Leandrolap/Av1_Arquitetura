package com.example.RestAPI.repository;

import com.example.RestAPI.model.NoticiaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<NoticiaEntity, String> {
    // Métodos de CRUD já estão disponíveis
    //findAll, findById, save, deleteById

}