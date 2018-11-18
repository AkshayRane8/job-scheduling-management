////http://localhost:8080/RESTJerseySpringService/rest/application.wadl
//http://www.baeldung.com/securing-a-restful-web-service-with-spring-security
package com.yashcreations.services.spring.app;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import com.yashcreations.services.jsm.customer.dao.model.Customer;

public class RestApplicationContext implements ApplicationContextAware, BeanNameAware{

	private ApplicationContext applicationContext;

	@Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("setApplicationContext Called........................, and the application Context Object is :" + applicationContext);

        this.applicationContext = applicationContext;
        System.out.println("this.applicationContext = applicationContext,::::::::::::::::::" + this.applicationContext.getBean("customer"));
    }
	@Override
	 public void setBeanName(String beanName)
	 {
		System.out.println("Bean name is: "+beanName);
	 }

	public ApplicationContext getApplicationContext(){
		return applicationContext;
	}
	public void getCustomerDetails(){

		Customer trac = (Customer)this.applicationContext.getBean("customer");

	}

}

