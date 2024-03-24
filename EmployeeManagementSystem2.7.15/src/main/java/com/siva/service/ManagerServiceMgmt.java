package com.siva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siva.entity.Admin;
import com.siva.entity.Employee;
import com.siva.entity.EmployeeManagerHelpDesk;
import com.siva.entity.Manager;
import com.siva.entity.Project;
import com.siva.entity.ProjectStatus;
import com.siva.model.AssignProjectModel;
import com.siva.model.HelpDeskModel;
import com.siva.model.LeaveRequestModel;
import com.siva.model.PaySlipInfo;
import com.siva.model.ProjectStatusModel;
import com.siva.model.ViewProjectDetails;
import com.siva.repo.IEmployeeRepo;
import com.siva.repo.IHelpDeskRepo;
import com.siva.repo.ILeaveRequestRepo;
import com.siva.repo.IManagerRepo;
import com.siva.repo.IPaySlipRepository;
import com.siva.repo.IProjectRepo;
import com.siva.repo.IProjectStatus;

import lombok.NonNull;

@Service("manager-service")
public class ManagerServiceMgmt implements IManagerService {

	@Autowired
	private IManagerRepo mgrRepo;

	@Autowired
	private IEmployeeRepo empRepo;

	@Autowired
	private IProjectRepo projRepo;

	@Autowired
	private IProjectStatus projStatusRepo;
	@Autowired
	private ILeaveRequestRepo leaveRequestRepo;
	
	@Autowired
	private IHelpDeskRepo helpRepo;
	
	@Autowired
	private IPaySlipRepository slipRepo;
	@Override
	public Optional<Manager> fetchManagerDetails(String mail, String password) {

		Optional<Manager> mgr = mgrRepo.findByEmailAndPassword(mail, password);
		return mgr;
	}

	@Override
	public List<Employee> fetchAllEmployeeDetails(Integer id) {

		List<Employee> list=empRepo.fetchEmpDetailsByMgrId(id);
		return list;
	}

	@Override
	public AssignProjectModel fetchEmployeeById(Integer id) {
		AssignProjectModel proj = new AssignProjectModel();
		Optional<Employee> opt = empRepo.findById(id);
		if (opt.isPresent()) {
			Employee employee = opt.get();
			proj.setEmpId(employee.getEmpId());
			proj.setMgrId(employee.getManager().getMgrId());
			proj.setEmpName(employee.getName());
			proj.setEmail(employee.getEmail());

		}
		return proj;
	}

	@Override
	public String setProjectToEmployeeByManager(AssignProjectModel proj) {
		Optional<Employee> opt = empRepo.findById(proj.getEmpId());
		Project projEmp = new Project();
		projEmp.setProjName(proj.getProjectName());
        String pname=proj.getProjectName();
        
		
		String pename=null;
		if (opt.isPresent()) {
			Employee emp = opt.get();
			pename=emp.getName();
			projEmp.setEmployees(emp);
		
		} else {
			throw new IllegalArgumentException("Employee not found");
		}
		String pMgrName=null;
		Optional<Manager> optmgr = mgrRepo.findById(proj.getMgrId());
		if (optmgr.isPresent()) {
			Manager mgr = optmgr.get();
			pMgrName=mgr.getName();
			projEmp.setManager(mgr);
		} else {
			throw new IllegalArgumentException("Manager not found");
		}
		projRepo.save(projEmp);
	  return pname +"-Project is assigned to employee "+pename+" by manager "+pMgrName;
		
	}
	@Override
	public List<ViewProjectDetails> getProjectDetailsByMgrId(Integer id) {
		
		List<ViewProjectDetails> projDetails = mgrRepo.fetchProjectDetatilsByMgrId(id);
		return projDetails;
	}
	@Override
	public Employee fetchEmployeeDetailsById(Integer id) {
		
		Employee emp = empRepo.findById(id).get();
		return emp;
	}
	@Override
	public List<ProjectStatus> fetchProjectStatusByEmpId(Integer id) {
		Employee emp = empRepo.findById(id).get();
		Integer mgrId=emp.getManager().getMgrId();
	    List<ProjectStatus> messages = projStatusRepo.fetchProjectByManagerIdAndEmpId(id, mgrId);
		return messages;
	}
	@Override
	public String sendResponseToEmployee(ProjectStatusModel status) {
		ProjectStatus prstatus = new ProjectStatus();
		prstatus.setRespone(status.getResponse());
	    Manager mgr = mgrRepo.findById(status.getMgrId()).get();
	    prstatus.setMgr(mgr);
	    Employee emp = empRepo.findById(status.getEmpId()).get();
	    prstatus.setEmp(emp);
	    Integer stId = projStatusRepo.save(prstatus).getPstatusId();
	    return stId+" response sent successfully";
	}
	@Override
	public List<LeaveRequestModel> fetchAllEmpsLeaveRequestByMgrId(Integer id) {
		List<LeaveRequestModel> leaves = leaveRequestRepo.fetchAllEmpRequestByMgrId(id);
		return leaves;
	}
	
	@Override
	public String udpateEmployeeLeaveRequest(Integer id,String response) {
		@NonNull
		String name = empRepo.findById(id).get().getName();
		leaveRequestRepo.updateLeaveStatusByEmpId(id, response);
		return name+" leave request is updated";
	}
	@Override
	public HelpDeskModel fetchRequiredMgrInfoById(Integer id) {
		
		HelpDeskModel hdm = new HelpDeskModel();
		Manager emp = mgrRepo.findById(id).get();
		hdm.setAdminId(emp.getAdmin().getAdminId());
		hdm.setEmpId(emp.getMgrId());
		hdm.setEmpName(emp.getName());
		hdm.setEmail(emp.getEmail());
		hdm.setMobileNo(emp.getMobileNo());
		return hdm;
	}
	
	@Override
	public String sendQueryToAdminUsingModel(HelpDeskModel model) {
		
		EmployeeManagerHelpDesk hmhd=new EmployeeManagerHelpDesk();
	    Manager emp = mgrRepo.findById(model.getEmpId()).get();
	     Admin admin = emp.getAdmin();
		hmhd.setAdmin(admin);
		hmhd.setMgr(emp);
	    hmhd.setMessage(model.getMessage());
	    hmhd.setStatus(model.getStatus());
	@NonNull
	Integer helpId = helpRepo.save(hmhd).getHelpId();
	return emp.getName()+" employee send query and admin  will send response";
	}
	@Override
	public List<HelpDeskModel> fetchHelpQuery(Integer id) {
		List<HelpDeskModel> fetchAllEmpsQueries = helpRepo.fetchAllmgrsQueries(id);
		return fetchAllEmpsQueries;
	}
	@Override
	public List<PaySlipInfo> fetchPaySlipInfo(Integer id) {
		
		List<PaySlipInfo> paySlipInfo = slipRepo.fetchMgrPaySlipDetailsByMgrId(id);
		return paySlipInfo;
		}
	
}
