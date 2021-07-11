package com.ceiba.persona.puerto.repositorio;

import com.ceiba.persona.modelo.entidad.Persona;

public interface RepositorioPersona {
	
	Long crear(Persona persona);
	
	boolean existe(String celular);

}
