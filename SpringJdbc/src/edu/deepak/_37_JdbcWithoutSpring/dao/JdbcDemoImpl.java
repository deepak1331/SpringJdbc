package edu.deepak._37_JdbcWithoutSpring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import edu.deepak._37_JdbcWithoutSpring.model.Circle;

@Component
public class JdbcDemoImpl {

	public Circle getCircle(int circleId) {

		Circle circle = null;
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prep", "root", "p@ssword");
			PreparedStatement ps = conn.prepareStatement("Select * from circle where id = ?");
			ps.setInt(1, circleId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
//				System.out.println(rs.getString("name"));
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
