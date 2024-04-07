package com.centroinformacion.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class TesisHasAlumnoPK implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idTesis;
	private int idAlumno;
}
