package edu.deepak._39_JdbcTemplateAndObject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import edu.deepak._39_JdbcTemplateAndObject.model.Circle;

@Component
public class JdbcDemoImpl {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	String sql = null;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		// this.dataSource = dataSource;
		// Initialize jdbcTemplate here, and use @Autowired annotation, so that
		// Compiler uses
		// setter method to initialize DataSource
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getCircleCount() {
		sql = "SELECT COUNT(*) FROM CIRCLE";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public String getCircleNameById(int circleId) {
		sql = "SELECT NAME FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, String.class);
	}
	
	public Circle getCircleById(int circleId) {
		sql = "SELECT * FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, new CircleMapper());
	}
	
	public List<Circle> getAllCircle() {
		sql = "SELECT * FROM CIRCLE";
		return jdbcTemplate.query(sql,  new CircleMapper());
	}
	
	public static final class CircleMapper implements RowMapper<Circle>{

		@Override
		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Circle circle = new Circle(rs.getInt("id"), rs.getString("name"));
			return circle;			
		}
		
	}
	
//	public JdbcTemplate getJdbcTemplate() {
//		return jdbcTemplate;
//	}
//
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}

//	public Circle getCircle(int circleId) {
//
//		Circle circle = null;
//		Connection conn = null;
//		try {
//			conn = dataSource.getConnection();
//			PreparedStatement ps = conn.prepareStatement("Select * from circle where id = ?");
//			ps.setInt(1, circleId);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				circle = new Circle(circleId, rs.getString("name"));
//			}
//			rs.close();
//			ps.close();
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return circle;
//	}
}
