package edu.deepak._38_JdbcWithSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.deepak._38_JdbcWithSpring.dao.JdbcDemoImpl;
import edu.deepak._38_JdbcWithSpring.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring38.xml");
		JdbcDemoImpl dao = ctx.getBean("jdbcDemoImpl", JdbcDemoImpl.class);
		
		Circle circle = dao.getCircle(2);
		System.out.println(circle);
		
	}
}
