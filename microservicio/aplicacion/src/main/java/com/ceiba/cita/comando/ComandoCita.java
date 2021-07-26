package com.ceiba.cita.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCita {

	private String nombre;
	private String odontologo;
	private Integer valor;
	private String fechaCreacion;
	private Long idPersona;

}
