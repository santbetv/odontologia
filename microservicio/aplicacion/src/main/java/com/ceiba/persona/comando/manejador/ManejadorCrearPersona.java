package com.ceiba.persona.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.persona.comando.fabrica.FabricaPersona;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.servicio.ServicioCrearPersona;

@Component
public class ManejadorCrearPersona implements ManejadorComandoRespuesta<ComandoPersona, ComandoRespuesta<Long>>  {

	private final ServicioCrearPersona servicioCrearPersona; 
	private final FabricaPersona fabricaPersona;
	
	
	public ManejadorCrearPersona(ServicioCrearPersona servicioCrearPersona, FabricaPersona fabricaPersona) {
		this.servicioCrearPersona = servicioCrearPersona;
		this.fabricaPersona = fabricaPersona;
	}

	
	@Override
	public ComandoRespuesta<Long> ejecutar(ComandoPersona comando) {
		Persona cita = this.fabricaPersona.crear(comando);
		return new ComandoRespuesta<>(this.servicioCrearPersona.ejecutar(cita));
	}

	
	
	 

	
	 
	 
}
