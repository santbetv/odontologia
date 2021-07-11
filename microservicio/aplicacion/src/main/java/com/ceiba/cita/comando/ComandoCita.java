package com.ceiba.cita.comando;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCita {

	private Long id;
	private String nombre;
	private String odontologo;
	private Integer valor;
	private LocalDate fechaCreacion;
	private Long idPersona;

}
