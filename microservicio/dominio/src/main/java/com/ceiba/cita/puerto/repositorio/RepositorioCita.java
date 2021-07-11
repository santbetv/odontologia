package com.ceiba.cita.puerto.repositorio;

import com.ceiba.cita.modelo.entidad.Cita;

public interface RepositorioCita {
	
	Long crear(Cita cita);
	
	boolean existe(String nombre);

}
