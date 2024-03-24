package com.siva.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.siva.entity.Admin;
import com.siva.entity.Employee;
import com.siva.entity.Manager;
import com.siva.model.EmployeeModel;
import com.siva.model.HelpDeskModel;
import com.siva.model.ManagerAssignModel;
import com.siva.model.PaySlipModel;

public interface IAdminMgmtService {

	public Integer registerAdmin(Admin admin);
	
	public Optional<Admin> verifyAdminCrediantials(String username,String password);
	
	public Admin fetchAdminById(Integer Id);
	
	public Set<String> fetchListOfCities();
	
	public Set<String> fetchListOfStates();
	
	public String registerEmployeeDetails(EmployeeModel emp);
	
	public String registerManagerDetails(EmployeeModel emp);
	
	public List<Employee> fetchListOfEmployees();
	
	public List<Manager> fetchListOfManagers();
	
	public EmployeeModel fetchEmployeeById(Integer id);
	
	public Integer saveEditedEmployee(EmployeeModel emp);
	
	public String deleteEmployeeById(Integer id);
	
	public EmployeeModel fetchMangerById(Integer id);
	
	public Integer saveEditedManager(EmployeeModel emp);
	
	public String deleteManagerById(Integer id);
	
    public ManagerAssignModel fetchEmployeToAssignManager(Integer id);
	
    public Set<String> fetchListOfManagerNames();
    
    public String assignManagerToEmployeeByModel(ManagerAssignModel mam);
    
    public List<HelpDeskModel> fetchAllEmpsQueryByAdminId(Integer id);
    
    public HelpDeskModel fetchEmpDetailsById(Integer id);
    
    public String updateStatusOfEmpQueryUsingModel(HelpDeskModel help);
    
public List<HelpDeskModel> fetchAllMgrsQueryByAdminId(Integer id);
    
    public HelpDeskModel fetchMgrDetailsById(Integer id);
    
    public String updateStatusOfMgrQueryUsingModel(HelpDeskModel help);

    public PaySlipModel fetchPaySlipModelByEmpId(Integer id);
    
    public String savePaySlipInSystemAndPathInDb(PaySlipModel payslip)throws Exception;
    
    public PaySlipModel fetchPaySlipModelByMgrId(Integer id);
    
    public String saveMgrPaySlip(PaySlipModel paySlip)throws IOException ;
}
