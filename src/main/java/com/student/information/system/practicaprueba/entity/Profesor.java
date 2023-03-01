package com.student.information.system.practicaprueba.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "profesor")
@Data
public class Profesor implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Long id_profesor;
	private Long id_departamento;
	private String nombre;

	private String direccion;

	private String telefono;


	// Relaciones
	
	private Curso curso;
}
