package com.ceiba.persona.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.persona.consulta.ManejadorListarPersonas;
import com.ceiba.persona.modelo.dto.DtoPersona;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/personas")
@Api(tags = { "Controlador consulta persona" })
public class ConsultaControladorPersona {

	private final ManejadorListarPersonas manejadorListarPersonas;

	public ConsultaControladorPersona(ManejadorListarPersonas manejadorListarPersonas) {
		this.manejadorListarPersonas = manejadorListarPersonas;
	}

	@GetMapping
	@ApiOperation("Listar Personas")
	public List<DtoPersona> listar() {
		return this.manejadorListarPersonas.ejecutar();
	}

}
