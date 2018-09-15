package edu.deepak._43_NamedParameterJdbcTemplate.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcDaoSupportImpl extends JdbcDaoSupport {

	public int getCircleCount() {
		String sql = "SELECT count(*) FROM CIRCLE";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	public String getCircleName(int circleId) {
		String sql = "SELECT NAME FROM CIRCLE WHERE ID = ?";
		return this.getJdbcTemplate().queryForObject(sql, new Object[] { circleId }, String.class);
	}

}
