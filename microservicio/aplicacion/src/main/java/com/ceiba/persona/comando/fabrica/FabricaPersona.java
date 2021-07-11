package com.ceiba.persona.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.persona.modelo.entidad.Persona;

@Component
public class FabricaPersona {

	public Persona crear(ComandoPersona comandoPersona) {

		return new Persona(comandoPersona.getId(), 
				comandoPersona.getNombre(), 
				comandoPersona.getCelular());

	}
}