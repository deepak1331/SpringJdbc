package edu.deepak._39_JdbcTemplateAndObject;

import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.deepak._39_JdbcTemplateAndObject.dao.JdbcDemoImpl;
import edu.deepak._39_JdbcTemplateAndObject.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring39.xml");
		JdbcDemoImpl dao = ctx.getBean("jdbcDemoImpl", JdbcDemoImpl.class);
		
//		Circle circle = dao.getCircle(2);
//		System.out.println(circle);
		
		System.out.println("Circle Count : "+dao.getCircleCount());
		System.out.println("Circle Name : "+dao.getCircleNameById(1));
		System.out.println("Circle Info : "+dao.getCircleById(2));
		System.out.println("All Circle Info : ");
		Iterator<Circle> itr = dao.getAllCircle().iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
	}
}
