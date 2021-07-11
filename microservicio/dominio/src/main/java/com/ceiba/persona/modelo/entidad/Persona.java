package com.ceiba.persona.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import lombok.Getter;

@Getter
public class Persona {

	
	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_PERSONA = "Se debe ingresar de la persona";
	private static final String SE_DEBE_INGRESAR_CELULAR = "Se debe ingresar el celular de la persona";

	private Long id;
	private String nombre;
	private String celular;

	public Persona(Long id, String nombre, String celular) {

		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_PERSONA);
		validarObligatorio(celular, SE_DEBE_INGRESAR_CELULAR);
		
		this.id = id;
		this.nombre=nombre;
		this.celular = celular;
	}

}
