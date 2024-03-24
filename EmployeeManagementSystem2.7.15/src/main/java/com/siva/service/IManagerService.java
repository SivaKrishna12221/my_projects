package com.siva.service;

import java.util.List;
import java.util.Optional;

import com.siva.entity.Employee;
import com.siva.entity.Manager;
import com.siva.entity.ProjectStatus;
import com.siva.model.AssignProjectModel;
import com.siva.model.HelpDeskModel;
import com.siva.model.LeaveRequestModel;
import com.siva.model.PaySlipInfo;
import com.siva.model.ProjectStatusModel;
import com.siva.model.ViewProjectDetails;

public interface IManagerService {

	public Optional<Manager> fetchManagerDetails(String mail, String password);

	public List<Employee> fetchAllEmployeeDetails(Integer id);

	public AssignProjectModel fetchEmployeeById(Integer id);

	public String setProjectToEmployeeByManager(AssignProjectModel proj);

	public List<ViewProjectDetails> getProjectDetailsByMgrId(Integer id);

	public Employee fetchEmployeeDetailsById(Integer id);

	public List<ProjectStatus> fetchProjectStatusByEmpId(Integer id);

	public String sendResponseToEmployee(ProjectStatusModel status);

	public List<LeaveRequestModel> fetchAllEmpsLeaveRequestByMgrId(Integer id);

	public String udpateEmployeeLeaveRequest(Integer id, String response);

	
	public HelpDeskModel fetchRequiredMgrInfoById(Integer id);

	public String sendQueryToAdminUsingModel(HelpDeskModel model);

	public List<HelpDeskModel> fetchHelpQuery(Integer id);

	public List<PaySlipInfo> fetchPaySlipInfo(Integer id);
}
