package cn.tedu.spring;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("jdbc.properties")
@Configuration
@MapperScan("cn.tedu.spring")
public class SpringConfig {
	@Value("${mysql.url}")
	private String url;
	@Value("${mysql.driver}")
	private String driver;
	@Value("${mysql.username}")
	private String username;
	@Value("${mysql.password}")
	private String password;
	
	@Value("${mysql.initialSize}")
	private Integer initialSize;
	@Value("${mysql.maxTotal}")
	private Integer maxTotal;
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driver);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setInitialSize(initialSize);
		dataSource.setMaxTotal(maxTotal);
		return dataSource;
		
	}
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() {
		SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
		bean.setDataSource(dataSource());
		return bean;
	}
}
