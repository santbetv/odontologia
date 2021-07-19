package com.ceiba.cita.servicio;

import com.ceiba.cita.puerto.repositorio.RepositorioCita;

public class ServicioEliminarCita {

	private final RepositorioCita repositoriocita;

	public ServicioEliminarCita(RepositorioCita repositoriocita) {
		this.repositoriocita = repositoriocita;
	}

	public void ejecutar(Long id) {

		this.repositoriocita.eliminar(id);
	}
}
