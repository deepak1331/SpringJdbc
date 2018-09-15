package edu.deepak._43_NamedParameterJdbcTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.deepak._43_NamedParameterJdbcTemplate.dao.JdbcDaoSupportImpl;
import edu.deepak._43_NamedParameterJdbcTemplate.dao.JdbcDemoImpl;

public class JdbcDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring43.xml");
		JdbcDemoImpl dao = ctx.getBean("jdbcDemoImpl", JdbcDemoImpl.class);
		JdbcDaoSupportImpl jdbcDaoSupportImpl = ctx.getBean("jdbcDaoSupportImpl",JdbcDaoSupportImpl.class);

		System.out.println("Circle Name : " + dao.getCircleNameById(1));
		System.out.println("Circle Count : " +jdbcDaoSupportImpl.getCircleCount());
	}

}
