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
	private static final String SE_DEBE_INGRESAR_LA_RELACION_PERSONA = "ingresar la relacion persona existente";
	private static final String SE_DEBE_INGRESAR_EL_SIGUIENTE_HORARIO_LUNES_A_VIERNES = "Solo se permite sacar cita de lunes a viernes";
	private static final String DIA_FESTIVO = "Solo se permite sacar cita de lunes a viernes Dia festivo tiene un valor de: ";
	private static final String DIA_HABIL="Creada Día hábil";
	
	private String nombre;
	private String odontologo;
	private Integer valor;
	private String fechaCreacion;
	private Long idPersona;
	private Festivos diaFestivo;
	private String mensajeRespuesta;

	public Cita(String nombre, String odontologo, Integer valor, String fechaCreacion, Long idPersona) {

		this.diaFestivo = new Festivos(conversionDeFecha(fechaCreacion).getYear());
		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_CITA);
		validarObligatorio(odontologo, SE_DEBE_INGRESAR_EL_NOMBRE_ODONTOLOGO);
		validarObligatorio(valor, SE_DEBE_INGRESAR_VALOR);
		validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);
		validarObligatorio(idPersona, SE_DEBE_INGRESAR_LA_RELACION_PERSONA);
		validarFinesDeSemana(conversionDeFecha(fechaCreacion), SE_DEBE_INGRESAR_EL_SIGUIENTE_HORARIO_LUNES_A_VIERNES);
		
		this.nombre = nombre;
		this.odontologo = odontologo;
		this.valor = valor;
		this.fechaCreacion = asignacionFecha(conversionDeFecha(fechaCreacion), 1).toString();
		this.idPersona = idPersona;
		this.mensajeRespuesta = mensajeRespuesta(conversionDeFecha(this.fechaCreacion));
	}
	
	private void validarFinesDeSemana(LocalDate fechaActual, String mensaje) {
		LocalDate resultado = fechaActual;
		if (resultado.getDayOfWeek() == DayOfWeek.SATURDAY || resultado.getDayOfWeek() == DayOfWeek.SUNDAY) {
			throw new ExcepcionValorInvalido(mensaje);
		}
	}

	private LocalDate asignacionFecha(LocalDate fechaActual, int diasAumenta) {
		LocalDate result = fechaActual;
		int diasAgregados = 0;
		while (diasAgregados < diasAumenta) {
			result = result.plusDays(1);
			if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
				++diasAgregados;
			}
		}
		return result;
	}

	private String mensajeRespuesta(LocalDate result) {
		String respuesta = "";
		boolean validarFestivo = this.diaFestivo.esFestivo(result.getMonthValue(), result.getDayOfMonth());
		if (validarFestivo) {
			this.valor = (valor * 2);
			respuesta = DIA_FESTIVO + this.valor;
		} else {
			respuesta = DIA_HABIL;
		}
		return respuesta;
	}

	private LocalDate conversionDeFecha(String sDate) {
		return LocalDate.parse(sDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

}
