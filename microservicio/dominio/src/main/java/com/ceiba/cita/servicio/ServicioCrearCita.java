package com.ceiba.cita.servicio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearCita {

	private static final String LA_CITA_YA_EXISTE_EN_EL_SISTEMA = "La cita ya existe en el sistema";

	private final RepositorioCita repositoriocita;

	public ServicioCrearCita(RepositorioCita repositoriocita) {
		this.repositoriocita = repositoriocita;
	}

	public Long ejecutar(Cita cita) {
		validarExistencia(cita);
		return this.repositoriocita.crear(cita);

	}

	private void validarExistencia(Cita cita) {
		boolean existe = this.repositoriocita.existe(cita.getNombre());
		if (existe) {
			throw new ExcepcionDuplicidad(LA_CITA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}

}
