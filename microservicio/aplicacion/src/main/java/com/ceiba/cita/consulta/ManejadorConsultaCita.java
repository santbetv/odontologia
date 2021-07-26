package com.ceiba.cita.consulta;

import org.springframework.stereotype.Component;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.cita.puerto.dao.DaoCita;

@Component
public class ManejadorConsultaCita {

	private final DaoCita daoCita;

	public ManejadorConsultaCita(DaoCita daoCita) {
		this.daoCita = daoCita;
	}

	public DtoCita ejecutar(Long id) {
		return this.daoCita.listarCita(id);
	}

}
