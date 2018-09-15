package edu.deepak._39_JdbcTemplateAndObject;

import java.util.Iterator;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.deepak._39_JdbcTemplateAndObject.dao.JdbcDemoImpl;
import edu.deepak._39_JdbcTemplateAndObject.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring39.xml");
		JdbcDemoImpl dao = ctx.getBean("jdbcDemoImpl", JdbcDemoImpl.class);

		System.out.println("Circle Count : " + dao.getCircleCount());
		System.out.println("Circle Name : " + dao.getCircleNameById(1));
		System.out.println("Circle Info : " + dao.getCircleById(2));
		System.out.println("All Circle Info : ");
		Iterator<Circle> itr = dao.getAllCircle().iterator();
		while (itr.hasNext())
			System.out.println(itr.next());

		System.out.println("Records Deleted : " + dao.deleteCircleById(4));
		itr = dao.getAllCircle().iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
		// Scanner sc = new Scanner(System.in);
		// System.out.println("Enter Circle Name & Id");
		//
		// String name = sc.nextLine();
		// int id = sc.nextInt();
		// System.out.println("No. of Record Updated : " +dao.insertCircle(new
		// Circle(id, name)));
		// System.out.println("Total records after insertion : " +
		// dao.getAllCircle());

	}
}
