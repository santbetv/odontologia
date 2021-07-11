package com.ceiba.cita.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.cita.consulta.ManejadorListarCitas;
import com.ceiba.cita.modelo.dto.DtoCita;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/citas")
@Api(tags = { "Controlador consulta cita" })
public class ConsultaControladorCita {

	private final ManejadorListarCitas manejadorListarCitas;

	public ConsultaControladorCita(ManejadorListarCitas manejadorListarCitas) {
		this.manejadorListarCitas = manejadorListarCitas;
	}

	@GetMapping
	@ApiOperation("Listar Citas")
	public List<DtoCita> listar() {
		return this.manejadorListarCitas.ejecutar();
	}

}
