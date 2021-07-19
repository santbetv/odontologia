package com.ceiba.cita.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

import lombok.Getter;

@Getter
public class Cita {

	private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de cita";
	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_ODONTOLOGO = "Se debe ingresar la nombre del odontologo";
	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_CITA = "Se debe ingresar de la cita";
	private static final String SE_DEBE_INGRESAR_VALOR = "Se debe ingresar el valor de cita";
	private static final String SE_DEBE_INGRESAR_EL_SIGUIENTE_HORARIO_LUNES_A_VIERNES = "Solo se permite sacar cita de lunes a viernes";
	private static final String SE_DEBE_INGRESAR_LA_RELACION_PERSONA = "ingresar la realcion persona existente";

	private Long id;
	private String nombre;
	private String odontologo;
	private Integer valor;
	private String fechaCreacion;
	private Long idPersona;
	private Festivos diaFestivo;

	public Cita(Long id, String nombre, String odontologo, Integer valor, String fechaCreacion, Long idPersona) {

		this.diaFestivo = new Festivos(conversionDeFecha(fechaCreacion).getYear());
		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_CITA);
		validarObligatorio(odontologo, SE_DEBE_INGRESAR_EL_NOMBRE_ODONTOLOGO);
		validarObligatorio(valor, SE_DEBE_INGRESAR_VALOR);
		validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);
		validarObligatorio(idPersona, SE_DEBE_INGRESAR_LA_RELACION_PERSONA);
		validarHorario(conversionDeFecha(fechaCreacion), SE_DEBE_INGRESAR_EL_SIGUIENTE_HORARIO_LUNES_A_VIERNES, valor);

		this.id = id;
		this.nombre = nombre;
		this.odontologo = odontologo;
		this.valor = valor;
		this.fechaCreacion = asignacionFecha(conversionDeFecha(fechaCreacion), 1).toString();
		this.idPersona = idPersona;
	}

	private void validarHorario(LocalDate fecha, String mensaje, Integer valor) {
		boolean validarFestivo = this.diaFestivo.esFestivo(fecha.getMonthValue(), fecha.getDayOfMonth());
		if (validarFestivo) {
			throw new ExcepcionValorInvalido(mensaje + " Dia festivo tiene un valor de: " + (valor * 2));
		} else {
			validarFinesDeSemana(fecha, mensaje);
		}
	}

	public void validarFinesDeSemana(LocalDate fechaActual, String mensaje) {
		LocalDate resultado = fechaActual;
		if (resultado.getDayOfWeek() == DayOfWeek.SATURDAY || resultado.getDayOfWeek() == DayOfWeek.SUNDAY) {
			throw new ExcepcionValorInvalido(mensaje);
		}
	}

	public LocalDate asignacionFecha(LocalDate fechaActual, int diasAumenta) {
		LocalDate result = fechaActual;
		int diasAgregados = 0;

		while (diasAgregados < diasAumenta) {
			result = result.plusDays(1);
			boolean validarFestivo = this.diaFestivo.esFestivo(result.getMonthValue(), result.getDayOfMonth());
			if (validarFestivo) {
				result = result.plusDays(1);
			}
			if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
				++diasAgregados;
			}
		}
		return result;
	}

	public LocalDate conversionDeFecha(String sDate) {
		LocalDate fecha = LocalDate.parse(sDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return fecha;
	}

}
