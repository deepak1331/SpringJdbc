package edu.deepak._38_JdbcWithSpring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.deepak._38_JdbcWithSpring.model.Circle;

@Component
public class JdbcDemoImpl {

	@Autowired
	private DataSource dataSource;

	public Circle getCircle(int circleId) {

		Circle circle = null;
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("Select * from circle where id = ?");
			ps.setInt(1, circleId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				circle = new Circle(circleId, rs.getString("name"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return circle;
	}

}
