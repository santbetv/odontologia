package com.ceiba.persona.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;

public class ServicioCrearPersona {

	private static final String LA_PERSONA_CON_ESTE_CELULAR_YA_EXISTE_EN_EL_SISTEMA = "La persona con este celular ya existe en el sistema";

	private final RepositorioPersona repositorioPersona;

	public ServicioCrearPersona(RepositorioPersona repositorioPersona) {
		this.repositorioPersona = repositorioPersona;
	}

	public Long ejecutar(Persona persona) {
		validarExistencia(persona);
		return this.repositorioPersona.crear(persona);

	}

	private void validarExistencia(Persona persona) {
		boolean existe = this.repositorioPersona.existe(persona.getCelular());
		if (existe) {
			throw new ExcepcionDuplicidad(LA_PERSONA_CON_ESTE_CELULAR_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
}
