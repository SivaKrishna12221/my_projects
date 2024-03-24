package com.siva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
@SpringBootApplication
public class EmployeeManagementSystemApplication {

	@Bean("multipartFile")
	public CommonsMultipartResolver createCMResolver()
	{
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(-1);
		resolver.setMaxUploadSizePerFile(1024*1024);
		resolver.setPreserveFilename(true);
		return resolver;
	}
	@Bean("viewResolver")
	public BeanNameViewResolver createBNVResolver()
	{
		BeanNameViewResolver resolver = new BeanNameViewResolver();
		resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return resolver;
	}
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
		
	}
}
