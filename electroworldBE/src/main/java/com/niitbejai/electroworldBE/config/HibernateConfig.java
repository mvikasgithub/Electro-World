package com.niitbejai.electroworldBE.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager; // make sure this is 5 and not 4 (default picks 4)
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder; // make sure this is 5 and not 4 (default picks 4)
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.niitbejai.electroworldBE.dto"})
@EnableTransactionManagement 
public class HibernateConfig {

	// The below values are database specific and will change if we change the DBMS
	
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/electroworld";
	private final static String DATABASE_DRIVER ="org.h2.Driver";
	private final static String DATABASE_DIALECT = 	"org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "sa";
	
	// Creating datasource bean
	@Bean("dataSource")
	public DataSource getDataSource()
	{
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}
	
	// Creating sessionFactory bean
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.niitbejai.electroworldBE.dto");
		
		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() 
	{
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		return properties;
	}
	
	//Creating Transaction Manager Bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sesionFactory)
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sesionFactory);
		
		return transactionManager;
	}
	
	
}
