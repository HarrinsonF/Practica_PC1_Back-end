package com.centroinformacion.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "tesis_tiene_alumno")
public class TesisHasAlumno {

	
	@EmbeddedId
	private TesisHasAlumnoPK tesisHasAlumnoPK;

	@ManyToOne
	@JoinColumn(name = "idTesis", nullable = false, insertable = false, updatable = false)
	private Tesis tesis;
	
	@ManyToOne
	@JoinColumn(name = "idAlumno", nullable = false, insertable = false, updatable = false)
	private Alumno alumno;

	
	
}
