package com.siva.service;

import java.util.List;
import java.util.Optional;

import com.siva.entity.Employee;
import com.siva.entity.LeaveRequest;
import com.siva.entity.Manager;
import com.siva.entity.ProjectStatus;
import com.siva.model.HelpDeskModel;
import com.siva.model.LeaveRequestModel;
import com.siva.model.PaySlipInfo;
import com.siva.model.ProjectStatusModel;
import com.siva.model.ViewProjectDetails;

public interface IEmpMgmtService {
    
	public Optional<Employee> fetchEmpDetails(String email,String password);
	
	public Integer registerEmployee(Employee emp);
	
	public List<Employee> showEmployees();
	
	public List<ViewProjectDetails> fetchProjectDetails(Integer id);
	
	
	public List<ProjectStatus> fetchProjectStatus(Integer id);

	public Manager fetchManagerByEmployeeId(Integer id);
	
	public String sendMessageToManager(ProjectStatusModel status);
	
	public LeaveRequestModel fetchRequiredEmpByEmpId(Integer id);
	
	public String sendLeaveRequestToManager(LeaveRequestModel requestModel);
	
	public List<LeaveRequest> fetchAllLeaveRequestByEmployeeId(Integer id);
	
	public HelpDeskModel fetchRequiredEmpInfoById(Integer id);
	
	public String  sendQueryToAdminUsingModel(HelpDeskModel model);
	
	public List<HelpDeskModel> fetchHelpQuery(Integer id);
	
	public List<PaySlipInfo> fetchEmpPayslipInfoById(Integer id);
}
