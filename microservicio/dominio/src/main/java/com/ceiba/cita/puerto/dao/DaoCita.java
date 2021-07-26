package com.ceiba.cita.puerto.dao;

import java.util.List;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.cita.modelo.entidad.Cita;

public interface DaoCita {

	List<DtoCita> listar();
	
	DtoCita listarCita(Long id);
}
