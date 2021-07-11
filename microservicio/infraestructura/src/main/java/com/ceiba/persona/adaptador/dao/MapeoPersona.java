package com.ceiba.persona.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.persona.modelo.dto.DtoPersona;

public class MapeoPersona implements RowMapper<DtoPersona>, MapperResult {

	@Override
	public DtoPersona mapRow(ResultSet rs, int rowNum) throws SQLException {

		Long id = rs.getLong("id");
		String nombre = rs.getString("nombre");
		String celular = rs.getString("celular");

		return new DtoPersona(id, nombre, celular);
	}

}
