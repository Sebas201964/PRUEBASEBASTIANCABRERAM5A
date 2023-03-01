package com.student.information.system.practicaprueba.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.student.information.system.practicaprueba.entity.Departamento;

public interface IDepartamentoRepository extends MongoRepository<Departamento, Long> {

}
