package com.guru.bharath.datajpa.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value= {"classpath:database.properties"})
@EnableJpaRepositories("com.guru.bharath.datajpa.repositories")
@ComponentScan("com.guru.bharath.datajpa")
public class HibernateConfig {
	
	private final String PROPERTY_DRIVER = "driver";
	private final String PROPERTY_URL = "url";
	private final String PROPERTY_USERNAME = "user";
	private final String PROPERTY_PASSWORD = "password";
	private final String PROPERTY_SHOW_SQL = "hibernate.show_sql";
	private final String PROPERTY_DIALECT = "hibernate.dialect";
	
	@Autowired
	private Environment environment;
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setPackagesToScan("com.guru.bharath.datajpa.model");
		em.setDataSource(dataSource());
		em.setJpaProperties(jpaProperties());
		em.setPersistenceProviderClass(HibernatePersistence.class);
		return em;
	}
	
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(environment.getRequiredProperty(PROPERTY_DRIVER));
		ds.setUrl(environment.getRequiredProperty(PROPERTY_URL));
		ds.setUsername(environment.getRequiredProperty(PROPERTY_USERNAME));
		ds.setPassword(environment.getRequiredProperty(PROPERTY_PASSWORD));
		return ds;
	}
	
	
	@Bean
	public Properties jpaProperties() {
		Properties prop = new Properties();
		prop.setProperty(PROPERTY_SHOW_SQL, environment.getRequiredProperty(PROPERTY_SHOW_SQL));
		prop.setProperty(PROPERTY_DIALECT, environment.getRequiredProperty(PROPERTY_DIALECT));
		return prop;
	} 
	
	@Bean
	@Autowired
	public JpaTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean em) {
		JpaTransactionManager tx = new JpaTransactionManager();
		tx.setEntityManagerFactory(em.getObject());
		return tx;
	}

}
