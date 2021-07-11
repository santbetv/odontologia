package com.ceiba.persona.servicio.testdatabuilder;

import java.util.UUID;

import com.ceiba.persona.comando.ComandoPersona;

public class ComandoPersonaTestDataBuilder {

	private Long id;
	private String nombre;
	private String celular;

	public ComandoPersonaTestDataBuilder() {
		this.nombre = UUID.randomUUID().toString();
		this.celular = "3104600263";
	}

	public ComandoPersonaTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ComandoPersona build() {
		return new ComandoPersona(id, nombre, celular);
	}
}
