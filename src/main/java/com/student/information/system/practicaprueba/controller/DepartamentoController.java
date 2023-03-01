package com.student.information.system.practicaprueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.information.system.practicaprueba.entity.Departamento;
import com.student.information.system.practicaprueba.service.IDepartamentoService;

@RestController
@RequestMapping("/api/departamento")
public class DepartamentoController {

	@Autowired
	IDepartamentoService departamentoService;

	@GetMapping("/listar")
	public ResponseEntity<List<Departamento>> listarDepartamento() {
		return new ResponseEntity<>(departamentoService.findByAll(), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<Departamento> crearDepartamento(@RequestBody Departamento p) {
		return new ResponseEntity<>(departamentoService.save(p), HttpStatus.CREATED);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Departamento> actualizarDepartamento(@PathVariable Long id, @RequestBody Departamento p) {
		Departamento depa = departamentoService.findById(id);
		if (depa == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				depa.setNombre(p.getNombre());
				depa.setDirector(p.getDirector());
				depa.setDescripcion(p.getDescripcion());

				return new ResponseEntity<>(departamentoService.save(p), HttpStatus.OK);
			} catch (DataAccessException e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Departamento> eliminarDepartamento(@PathVariable Long id) {
		departamentoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
