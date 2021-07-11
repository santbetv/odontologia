package com.ceiba.cita.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cita.comando.ComandoCita;
import com.ceiba.cita.comando.fabrica.FabricaCita;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.servicio.ServicioCrearCita;
import com.ceiba.manejador.ManejadorComandoRespuesta;

@Component
public class ManejadorCrearCita implements ManejadorComandoRespuesta<ComandoCita, ComandoRespuesta<Long>>  {

	private final ServicioCrearCita servicioCrearCita; 
	private final FabricaCita fabricaCita;
	
	
	public ManejadorCrearCita(ServicioCrearCita servicioCrearCita, FabricaCita fabricaCita) {
		this.servicioCrearCita = servicioCrearCita;
		this.fabricaCita = fabricaCita;
	}


	@Override
	public ComandoRespuesta<Long> ejecutar(ComandoCita comando) {
		Cita cita = this.fabricaCita.crear(comando);
		return new ComandoRespuesta<>(this.servicioCrearCita.ejecutar(cita));
	}

	
	
	 

	
	 
	 
}
