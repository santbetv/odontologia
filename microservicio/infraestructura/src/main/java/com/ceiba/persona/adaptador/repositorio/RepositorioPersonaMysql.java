package com.ceiba.persona.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;

@Repository
public class RepositorioPersonaMysql implements RepositorioPersona {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "persona", value = "crear")
	private static String sqlCrear;
	
	
	@SqlStatement(namespace="persona", value="existe")
    private static String sqlExiste;

	@Override
	public Long crear(Persona persona) {
		return this.customNamedParameterJdbcTemplate.crear(persona, sqlCrear);
	}

	public RepositorioPersonaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public boolean existe(String celular) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("celular", celular);
        
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
	}

	

	
}
