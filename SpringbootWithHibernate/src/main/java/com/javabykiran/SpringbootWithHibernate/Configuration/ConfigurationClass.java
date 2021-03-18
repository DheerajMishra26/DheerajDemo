package com.javabykiran.SpringbootWithHibernate.Configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.javabykiran.SpringbootWithHibernate.entities.Country;
import com.javabykiran.SpringbootWithHibernate.entities.Employee;
import com.javabykiran.SpringbootWithHibernate.entities.Registration;


@Configuration
public class ConfigurationClass {

	@Autowired
	DataSource datasource;

	@Bean
	public LocalSessionFactoryBean getfatoryBean()

	{
		System.out.println("getFactoryBean");
		LocalSessionFactoryBean factorybean = new LocalSessionFactoryBean();
		factorybean.setAnnotatedClasses(Employee.class, Country.class,Registration.class);
		factorybean.setDataSource(datasource);
		return factorybean;
	}

}
