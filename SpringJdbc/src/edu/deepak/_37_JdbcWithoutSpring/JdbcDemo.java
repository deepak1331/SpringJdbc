package edu.deepak._37_JdbcWithoutSpring;

import edu.deepak._37_JdbcWithoutSpring.dao.JdbcDemoImpl;
import edu.deepak._37_JdbcWithoutSpring.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		JdbcDemoImpl jdbcImpl = new JdbcDemoImpl();
		Circle circle = jdbcImpl.getCircle(1);
		System.out.println(circle.toString());
		
		System.out.println( jdbcImpl.getCircle(2));
	}
}
