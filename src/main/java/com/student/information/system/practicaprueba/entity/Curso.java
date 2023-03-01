package com.student.information.system.practicaprueba.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "curso")
@Data
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Long id_curso;
	private Long id_profesor;
	private String nombre;

	private String nivel;
	private String descripcion;

}
