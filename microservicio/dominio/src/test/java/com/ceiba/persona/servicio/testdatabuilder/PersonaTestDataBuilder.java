package com.ceiba.persona.servicio.testdatabuilder;

import com.ceiba.persona.modelo.entidad.Persona;

public class PersonaTestDataBuilder {

	private Long id;
	private String nombre;
	private String celular;


	public PersonaTestDataBuilder() {
		this.nombre = "Tomas";
		this.celular = "3165106361";
	}

	public PersonaTestDataBuilder conNombreCita(String nombreCita) {
		this.nombre = nombreCita;
		return this;
	}

	public PersonaTestDataBuilder conNumeroCelular(String celular) {
		this.celular = celular;
		return this;
	}
	
	public Persona build() {
		return new Persona(id, nombre, celular);
	}
}
