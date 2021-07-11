package com.ceiba.cita.servicio.testdatabuilder;

import java.time.LocalDate;

import com.ceiba.cita.modelo.entidad.Cita;

public class CitaTestDataBuilder {

	private Long id;
	private String nombre;
	private String odontologo;
	private Integer valor;
	private LocalDate fechaCreacion;
	private Long idPersona;

	public CitaTestDataBuilder() {
		nombre = "valoracion";
		odontologo = "julian";
		valor = 100000;
		fechaCreacion = LocalDate.of(2021, 7, 12);
		idPersona = 1L;
	}

	public CitaTestDataBuilder conNombreCita(String nombreCita) {
		this.nombre = nombreCita;
		return this;
	}

	public CitaTestDataBuilder conFecha(LocalDate fecha) {
		this.fechaCreacion = fecha;
		return this;
	}
	
	public CitaTestDataBuilder conValor(Integer valor) {
		this.valor = valor;
		return this;
	}

	public Cita build() {
		return new Cita(id, nombre, odontologo, valor, fechaCreacion, idPersona);
	}
}
