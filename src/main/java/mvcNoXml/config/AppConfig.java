package mvcNoXml.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan(basePackages= {"mvcNoXml.dao", "mvcNoXml.service", "mvcNoXml.exception"})
public class AppConfig {
	@Autowired
	private Environment env;
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		
		Properties props = new Properties();
		props.setProperty("hibernate.connection.driver_class", env.getProperty("mysql.driver"));
        props.setProperty("hibernate.connection.url", env.getProperty("mysql.url"));
        props.setProperty("hibernate.connection.username", env.getProperty("mysql.username"));
        props.setProperty("hibernate.connection.password", env.getProperty("mysql.password"));
        props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        props.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        props.setProperty("hibernate.c3p0.min_size", env.getProperty("hibernate.c3p0.min_size"));
        props.setProperty("hibernate.c3p0.max_size", env.getProperty("hibernate.c3p0.max_size"));
        props.setProperty("hibernate.c3p0.timeout", env.getProperty("hibernate.c3p0.timeout"));
        props.setProperty("hibernate.c3p0.max_statements", env.getProperty("hibernate.c3p0.max_statements"));
        props.setProperty("hibernate.c3p0.acquire_increment", env.getProperty("hibernate.c3p0.acquire_increment"));
        props.setProperty("hibernate.c3p0.idle_test_period", env.getProperty("hibernate.c3p0.idle_test_period"));
        
        sessionFactoryBean.setHibernateProperties(props);
        sessionFactoryBean.setPackagesToScan("mvcNoXml.model");
		return sessionFactoryBean;
	}
	
	@Bean
	public HibernateTransactionManager getTxManager() {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(getSessionFactory().getObject());
		return txManager;
	}
}
