package com.ceiba.persona.controlador;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.persona.comando.manejador.ManejadorCrearPersona;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/personas")
@Api(tags = { "Controlador comando persona" })
public class ComandoControladorPersona {

	private final ManejadorCrearPersona manejadorCrearPersona;

	
	public ComandoControladorPersona(ManejadorCrearPersona manejadorCrearPersona) {
		this.manejadorCrearPersona = manejadorCrearPersona;
	}

	@PostMapping
	@ApiOperation("Crear Persona")
	public ComandoRespuesta<Long> crear(@RequestBody ComandoPersona comandoPersona) {
		return manejadorCrearPersona.ejecutar(comandoPersona);
	}

}
