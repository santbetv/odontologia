package com.ceiba.cita.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoCita implements RowMapper<DtoCita>, MapperResult {

	@Override
	public DtoCita mapRow(ResultSet rs, int rowNum) throws SQLException {

		Long id = rs.getLong("id");
		String nombre = rs.getString("nombre");
		String odontologo = rs.getString("odontologo");
		Integer valor = rs.getInt("valor");
		LocalDate fechaCreacion = extraerLocalDate(rs, "fecha_creacion");
		Long idPersona= rs.getLong("id_persona");
		String mensajeRespuesta=rs.getString("mensaje");

		return new DtoCita(id, nombre, odontologo, valor, fechaCreacion, idPersona,mensajeRespuesta);
	}

}
