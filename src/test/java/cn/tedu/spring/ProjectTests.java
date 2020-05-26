package cn.tedu.spring;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProjectTests {
	
	MapperScannerConfigurer msc;
	SqlSessionFactoryBean ssfb;
	
	@Test
	public void contextLods() {
		System.out.println("ProjectTests.contextLods()");
	}
	
	@Test
	public void getConnection() throws SQLException {
		AnnotationConfigApplicationContext ac
			= new AnnotationConfigApplicationContext(SpringConfig.class);
		
		BasicDataSource basicDataSource
			= ac.getBean("dataSource", BasicDataSource.class);
		
		Connection conn = basicDataSource.getConnection();
		System.out.println(conn);
		
		ac.close();
	}
	
	@Test
	public void aaa() {
		AnnotationConfigApplicationContext ac=
				new AnnotationConfigApplicationContext(SpringConfig.class);
		UserMapper userMapper=ac.getBean("userMapper",UserMapper.class);
		User user=new User();
		user.setUsername("ÍõÎå");
		user.setPassword("112233");
		user.setAge(22);
		user.setPhone("13546525644");
		user.setEmail("123@qq.com");
		Integer rows=userMapper.aaa(user);
		System.out.println("rows:"+rows);
		ac.close();
	}
	
	@Test
	public void bbb() {
		AnnotationConfigApplicationContext ac=
				new AnnotationConfigApplicationContext(SpringConfig.class);
		UserMapper userMapper=ac.getBean("userMapper",UserMapper.class);
		User user=new User();
		user.setId(8);
		Integer rows=userMapper.bbb(user);
		System.out.println("rows:"+rows);
		ac.close();
	}
}
