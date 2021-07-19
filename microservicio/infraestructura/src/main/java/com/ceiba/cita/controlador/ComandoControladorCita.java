package com.ceiba.cita.controlador;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cita.comando.ComandoCita;
import com.ceiba.cita.comando.manejador.ManejadorCrearCita;
import com.ceiba.cita.comando.manejador.ManejadorEliminarCita;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/citas")
@Api(tags = { "Controlador comando cita" })
public class ComandoControladorCita {

	private final ManejadorCrearCita manejadorCrearCita;
	private final ManejadorEliminarCita manejadorEliminarCita;

	public ComandoControladorCita(ManejadorCrearCita manejadorCrearCita, ManejadorEliminarCita manejadorEliminarCita) {
		this.manejadorCrearCita = manejadorCrearCita;
		this.manejadorEliminarCita = manejadorEliminarCita;
	}

	@PostMapping
	@ApiOperation("Crear Cita")
	public ComandoRespuesta<Long> crear(@RequestBody ComandoCita comandoCita) {
		return manejadorCrearCita.ejecutar(comandoCita);
	}

	@DeleteMapping(value = "/{id}")
	@ApiOperation("Eliminar Usuario")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarCita.ejecutar(id);
	}

}
