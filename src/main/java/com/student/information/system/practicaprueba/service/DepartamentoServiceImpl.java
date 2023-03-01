package com.student.information.system.practicaprueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.student.information.system.practicaprueba.entity.Departamento;
import com.student.information.system.practicaprueba.repository.IDepartamentoRepository;

@Service
public class DepartamentoServiceImpl extends GenericServiceImpl<Departamento, Long> implements IDepartamentoService {

	@Autowired
    IDepartamentoRepository departamentoRepository;

	@Override
	public CrudRepository<Departamento, Long> getDao() {

		return departamentoRepository;
	}

}
