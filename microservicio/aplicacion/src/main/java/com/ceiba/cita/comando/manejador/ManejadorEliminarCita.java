package com.ceiba.cita.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.cita.servicio.ServicioEliminarCita;
import com.ceiba.manejador.ManejadorComando;

@Component
public class ManejadorEliminarCita implements ManejadorComando<Long> {

	private final ServicioEliminarCita servicioEliminarCita;
	
	public ManejadorEliminarCita(ServicioEliminarCita servicioEliminarCita) {
		this.servicioEliminarCita = servicioEliminarCita;
	}

	public void ejecutar(Long idCita) {
		this.servicioEliminarCita.ejecutar(idCita);
	}
}
