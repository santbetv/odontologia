package com.ceiba.cita.servicio.testdatabuilder;

import java.time.LocalDate;

import com.ceiba.cita.comando.ComandoCita;

public class ComandoCitaTestDataBuilder {

	private Long id;
	private String nombre;
	private String odontologo;
	private Integer valor;
	private LocalDate fechaCreacion;
	private Long idPersona;

	public ComandoCitaTestDataBuilder() {
		nombre = "valoracion";
		odontologo = "julian";
		valor = 100000;
		fechaCreacion = LocalDate.of(2021, 7, 12);
		idPersona = 1L;
	}

	public ComandoCitaTestDataBuilder conNombreCita(String nombreCita) {
		this.nombre = nombreCita;
		return this;
	}

	public ComandoCitaTestDataBuilder conFecha(LocalDate fecha) {
		this.fechaCreacion = fecha;
		return this;
	}
	
	public ComandoCitaTestDataBuilder conValor(Integer valor) {
		this.valor = valor;
		return this;
	}

	public ComandoCita build() {
		return new ComandoCita(id, nombre, odontologo, valor, fechaCreacion, idPersona);
	}
}
