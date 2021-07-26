package com.ceiba.cita.servicio.testdatabuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ceiba.cita.comando.ComandoCita;

public class ComandoCitaTestDataBuilder {
	
	private String nombre;
	private String odontologo;
	private Integer valor;
	private String fechaCreacion;
	private Long idPersona;

	public ComandoCitaTestDataBuilder() {
		nombre = "valoracion";
		odontologo = "julian";
		valor = 100000;
		fechaCreacion = LocalDate.of(2021, 7, 12).toString();
		idPersona = 1L;
	}

	public ComandoCitaTestDataBuilder conNombreCita(String nombreCita) {
		this.nombre = nombreCita;
		return this;
	}

	public ComandoCitaTestDataBuilder conFecha(LocalDate fecha) {
		this.fechaCreacion = conversionDefechaACaracter(fecha);
		return this;
	}
	
	public ComandoCitaTestDataBuilder conValor(Integer valor) {
		this.valor = valor;
		return this;
	}

	public ComandoCita build() {
		return new ComandoCita(nombre, odontologo, valor, fechaCreacion, idPersona);
	}
	
	public String conversionDefechaACaracter(LocalDate date) {
		LocalDate localDate = date;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedString = localDate.format(formatter);
		return formattedString;
	}
}
