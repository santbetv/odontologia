package com.ceiba.cita.servicio;

import java.time.LocalDate;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

public class ServicioCrearCitaTest {

	
	@Test
	public void validarCitaFestivosTest() {
		// arrange
		CitaTestDataBuilder cita = new CitaTestDataBuilder().conFecha(LocalDate.of(2021, 6, 20));

		// act - assert
		BasePrueba.assertThrows(() -> cita.build(), ExcepcionValorInvalido.class,
				"Solo se permite sacar cita de lunes a viernes Dia festivo tiene un valor de: 200000");
	}
	
	
	@Test
	public void validarCitaSabadosYDomingosTest() {
		// arrange
		CitaTestDataBuilder cita = new CitaTestDataBuilder().conFecha(LocalDate.of(2021, 7, 10));

		// act - assert
		BasePrueba.assertThrows(() -> cita.build(), ExcepcionValorInvalido.class,
				"Solo se permite sacar cita de lunes a viernes");
	}

	@Test
	public void validarCitaPreviaTest() {
		// arrange
		Cita cita = new CitaTestDataBuilder().conNombreCita("periodoncia").build();

		RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);

		Mockito.when(repositorioCita.existe(Mockito.anyString())).thenReturn(true);

		ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearCita.ejecutar(cita), ExcepcionDuplicidad.class,
				"La cita ya existe en el sistema");
	}
}
