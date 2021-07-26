package com.ceiba.cita.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.cita.consulta.ManejadorConsultaCita;
import com.ceiba.cita.consulta.ManejadorListarCitas;
import com.ceiba.cita.modelo.dto.DtoCita;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/citas")
@Api(tags = { "Controlador consulta cita" })
public class ConsultaControladorCita {

	private final ManejadorListarCitas manejadorListarCitas;
	private final ManejadorConsultaCita manejadorConsultaCita;

	public ConsultaControladorCita(ManejadorListarCitas manejadorListarCitas,
			ManejadorConsultaCita meManejadorConsultaCita) {
		this.manejadorListarCitas = manejadorListarCitas;
		this.manejadorConsultaCita = meManejadorConsultaCita;
	}

	@GetMapping
	@ApiOperation("Listar Citas")
	public List<DtoCita> listar() {
		return this.manejadorListarCitas.ejecutar();
	}

	@GetMapping(value = "/{id}")
	@ApiOperation("Consulta Cita")
	public DtoCita consultarCita(@PathVariable Long id) {
		return manejadorConsultaCita.ejecutar(id);
	}

}
