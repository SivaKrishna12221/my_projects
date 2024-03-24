package com.siva.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.siva.model.EmployeeModel;
@Component
public class EmployeeVaildation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(EmployeeModel.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		EmployeeModel emp = (EmployeeModel) target;

		if(emp.getAddress()==null|| emp.getAddress().isBlank())
		{
			errors.rejectValue("address","emp.address.required");//here address is field and code is error code this will be stored in the Binding result object 
		}
		else if(emp.getAddress().length()<5|| emp.getAddress().length()>30)
		{
			errors.rejectValue("address","emp.address.length");
		}
		if(emp.getCity()==null||emp.getCity().isBlank())
		{
			errors.rejectValue("city","emp.city.required");
		}
		else if(emp.getCity().length()<5|| emp.getCity().length()>20)
		{
			errors.rejectValue("city","emp.city.length");
		}
		if(emp.getConfirmPassword()==null||emp.getConfirmPassword().isBlank())
		{
			errors.rejectValue("confirmPassword","emp.confirmPassword.required");
		}
		else if(emp.getConfirmPassword().length()<10 || emp.getConfirmPassword().length()>20)
		{
			errors.rejectValue("confirmPassword","emp.confirmPassword.length");
		}
		if(emp.getEmail()==null|| emp.getEmail().isBlank())
		{
			errors.rejectValue("email","emp.email.required");//here address is field and code is error code this will be stored in the Binding result object 
		}
		else if(emp.getEmail().length()<10|| emp.getEmail().length()>40)
		{
			errors.rejectValue("email","emp.email.length");
		}
		if(emp.getFirstName()==null||emp.getFirstName().isBlank())
		{
			errors.rejectValue("firstName","emp.firstName.required");
		}
		else if(emp.getFirstName().length()<4|| emp.getFirstName().length()>15)
		{
			errors.rejectValue("firstName","emp.firstName.length");
		}
		if(emp.getLastName()==null||emp.getLastName().isBlank())
		{
			errors.rejectValue("lastName","emp.lastName.required");
		}
		else if(emp.getLastName().length()<4|| emp.getLastName().length()>15)
		{
			errors.rejectValue("lastName","emp.lastName.length");
		}
		if(emp.getPassword()==null||emp.getPassword().isBlank())
		{
			errors.rejectValue("password","emp.password.required");
		}
		else if(emp.getPassword().length()<10 ||emp.getPassword().length()>20)
		{
			errors.rejectValue("password","emp.password.length");
		}
		if(emp.getMobileNo()==null)
		{
			errors.rejectValue("mobileNo","emp.mobileNo.required");
		}
		else if(emp.getMobileNo().toString().length()!=10)
		{
		   errors.rejectValue("mobileNo", "emp.mobileNo.length");
		}
		if(emp.getPincode()==null)
		{
			errors.rejectValue("pincode", "emp.pincode.required");
		}
		else if(emp.getPincode().toString().length()!=6)
		{
			errors.rejectValue("pincode", "emp.pincode.length");
		}
		if(emp.getState()==null||emp.getState().isBlank())
		{
			errors.rejectValue("state", "emp.state.required");
		}
		if(emp.getDob()==null)
		{
			errors.rejectValue("dob","emp.dob.required");
		}
	}
}
