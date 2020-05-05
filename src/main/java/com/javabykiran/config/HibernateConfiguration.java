package com.javabykiran.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.javabykiran.controller.LoginController;
import com.javabykiran.logger.LogginAspect;
import com.javabykiran.model.StateMaster;
import com.javabykiran.model.User;
import com.javabykiran.model.Users;

@Configuration
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
public class HibernateConfiguration {

	@Autowired
	private ApplicationContext context;

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
		return factoryBean;
	}
	

	   @Bean
		LogginAspect aspect(){
			return new LogginAspect();
		}
	   
	  
}
