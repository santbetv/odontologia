package com.ceiba.persona.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import com.ceiba.persona.servicio.testdatabuilder.PersonaTestDataBuilder;

public class ServicioCrearPersonaTest {

	@Test
	public void validarCitaPreviaTest() {
		// arrange

		Persona persona = new PersonaTestDataBuilder().conNumeroCelular("3146593910").build();

		RepositorioPersona repositorioPersona = Mockito.mock(RepositorioPersona.class);

		Mockito.when(repositorioPersona.existe(Mockito.anyString())).thenReturn(true);

		ServicioCrearPersona servicioCrearPersona = new ServicioCrearPersona(repositorioPersona);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearPersona.ejecutar(persona), ExcepcionDuplicidad.class,
				"La persona con este celular ya existe en el sistema");
	}
}
