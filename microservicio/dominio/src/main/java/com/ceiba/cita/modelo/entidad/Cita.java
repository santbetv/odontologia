package com.ceiba.cita.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.DayOfWeek;
import java.time.LocalDate;

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
	private LocalDate fechaCreacion;
	private Long idPersona;
	private HolidayUtil diaFestivo ;

	public Cita(Long id, String nombre, String odontologo, 
			Integer valor, LocalDate fechaCreacion, Long idPersona) {

		this.diaFestivo = new HolidayUtil(fechaCreacion.getYear());
		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_CITA);
		validarObligatorio(odontologo, SE_DEBE_INGRESAR_EL_NOMBRE_ODONTOLOGO);
		validarObligatorio(valor, SE_DEBE_INGRESAR_VALOR);
		validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);
		validarObligatorio(idPersona, SE_DEBE_INGRESAR_LA_RELACION_PERSONA);
		validarHorario(fechaCreacion, SE_DEBE_INGRESAR_EL_SIGUIENTE_HORARIO_LUNES_A_VIERNES, valor);
		
		
		this.id = id;
		this.nombre = nombre;
		this.odontologo = odontologo;
		this.valor=valor;
		this.fechaCreacion = asignacionFecha(fechaCreacion,1);
		this.idPersona = idPersona;
	}

	private void validarHorario(LocalDate fecha, String mensaje, Integer valor) {
		boolean validarFestivo = this.diaFestivo.isHoliday(fecha.getMonthValue(), fecha.getDayOfMonth());
		if (validarFestivo) {
			throw new ExcepcionValorInvalido(mensaje + " Dia festivo tiene un valor de: " + (valor*2) );
		}else {
			validarFinesDeSemana(fecha, 1, mensaje);
		}
	}
	
	
	public void validarFinesDeSemana(LocalDate date, int days, String mensaje) {
		LocalDate result = date;
		int addedDays = 0;
		while (addedDays < days) {
			result = result.plusDays(1);
			if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
				++addedDays;
			}else {
				throw new ExcepcionValorInvalido(mensaje);
			}
		}
	}

	
	
	public LocalDate asignacionFecha(LocalDate date, int days) {
		LocalDate result = date;
		int addedDays = 0;
		while (addedDays < days) {
			result = result.plusDays(1);
			if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
				++addedDays;
			}
		}
		return result;
	}

}
