package edu.deepak._43_NamedParameterJdbcTemplate.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class JdbcDemoImpl {

	private DataSource dataSource;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	String sql = null;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
			this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public String getCircleNameById(int circleId) {
		sql = "SELECT NAME FROM CIRCLE WHERE ID = :id";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource("id", circleId);
		return namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource,String.class);
	}
}
