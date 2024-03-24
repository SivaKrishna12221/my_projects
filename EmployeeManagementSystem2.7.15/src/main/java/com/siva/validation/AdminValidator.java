package com.siva.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.siva.entity.Admin;
@Component
public class AdminValidator implements Validator{
	 
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(Admin.class);
	}
	@Override
	public void validate(Object target, Errors errors) {
		Admin admin=(Admin)target;
		if(admin.getName()==null||admin.getName().isBlank())
		{
			errors.rejectValue("name","admin.name.required");
		}
		else if(admin.getName().length()<5|| admin.getName().length()>20)
		{
			errors.rejectValue("name","admin.name.length");
		}
		if(admin.getPassword()==null||admin.getPassword().isBlank())
		{
			errors.rejectValue("password","admin.password.required");
		}
		else if(admin.getPassword().length()<10|| admin.getPassword().length()>20)
		{
			errors.rejectValue("password","admin.password.length");
		}if(admin.getUsername()==null||admin.getUsername().isBlank())
		{
			errors.rejectValue("username","admin.username.required");
		}
		else if(admin.getUsername().length()<5|| admin.getUsername().length()>20)
		{
			errors.rejectValue("username","admin.username.length");
		}
	}
}
