package com.ceiba.cita.modelo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoCita {
	
	private Long id;
	private String nombre;
	private String odontologo;
	private Integer valor;
	private LocalDate fechaCreacion;
	private Long idPersona;
	private String mensajeRespuesta;

}
