package com.ceiba.cita.servicio.testdatabuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ceiba.cita.modelo.entidad.Cita;

public class CitaTestDataBuilder {

	private String nombre;
	private String odontologo;
	private Integer valor;
	private String fechaCreacion;
	private Long idPersona;

	public CitaTestDataBuilder() {
		nombre = "valoracion";
		odontologo = "julian";
		valor = 100000;
		fechaCreacion = LocalDate.of(2021, 7, 12).toString();
		idPersona = 1L;
	}

	public CitaTestDataBuilder conNombreCita(String nombreCita) {
		this.nombre = nombreCita;
		return this;
	}

	public CitaTestDataBuilder conFecha(LocalDate fecha) {
		this.fechaCreacion = conversionDefechaACaracter(fecha);
		return this;
	}
	
	public CitaTestDataBuilder conValor(Integer valor) {
		this.valor = valor;
		return this;
	}

	public Cita build() {
		return new Cita(nombre, odontologo, valor, fechaCreacion, idPersona);
	}
	
	public String conversionDefechaACaracter(LocalDate date) {
		LocalDate localDate = date;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedString = localDate.format(formatter);
		return formattedString;
	}
}
