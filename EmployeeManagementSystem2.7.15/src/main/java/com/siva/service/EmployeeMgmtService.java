package com.siva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siva.entity.Admin;
import com.siva.entity.Employee;
import com.siva.entity.EmployeeManagerHelpDesk;
import com.siva.entity.LeaveRequest;
import com.siva.entity.Manager;
import com.siva.entity.ProjectStatus;
import com.siva.model.HelpDeskModel;
import com.siva.model.LeaveRequestModel;
import com.siva.model.PaySlipInfo;
import com.siva.model.ProjectStatusModel;
import com.siva.model.ViewProjectDetails;
import com.siva.repo.IAdminRepo;
import com.siva.repo.IEmployeeRepo;
import com.siva.repo.IHelpDeskRepo;
import com.siva.repo.ILeaveRequestRepo;
import com.siva.repo.IManagerRepo;
import com.siva.repo.IPaySlipRepository;
import com.siva.repo.IProjectStatus;

import lombok.NonNull;

@Service("emp-service")
public class EmployeeMgmtService implements IEmpMgmtService {

	@Autowired
	private IEmployeeRepo empRepo;
	@Autowired
	private ILeaveRequestRepo leaveRepo;

	@Autowired
	private IProjectStatus projStatusRepo;
	@Autowired
	private IManagerRepo mgrRepo;

	@Autowired
	private IAdminRepo adminRepo;
	@Autowired
	private IHelpDeskRepo helpRepo;
	@Autowired
	private IPaySlipRepository slipRepo;
	@Override
	public Integer registerEmployee(Employee emp) {

		Employee save = empRepo.save(emp);
		return save.getEmpId();
	}

	@Override
	public List<Employee> showEmployees() {
		// TODO Auto-generated method stub
		List<Employee> listOfEmps = empRepo.findAll();
		return listOfEmps;
	}

	@Override
	public Optional<Employee> fetchEmpDetails(String email, String password) {
		return empRepo.findByEmailAndPassword(email, password);
	}

	@Override
	public List<ViewProjectDetails> fetchProjectDetails(Integer id) {

		List<ViewProjectDetails> details = empRepo.fetchProjectDetailsById(id);

		return details;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<ProjectStatus> fetchProjectStatus(Integer id) {
		// TODO Auto-generated method stub
		Employee emp = empRepo.findById(id).get();
		Integer mgrId = emp.getManager().getMgrId();
		List<ProjectStatus> messages = projStatusRepo.fetchProjectByManagerIdAndEmpId(id, mgrId);
		messages.forEach(x->System.out.println(x.getMessage()+","+x.getRespone()));
		return messages;
	}

	@Override
	public Manager fetchManagerByEmployeeId(Integer id) {
		Integer mgrId = empRepo.findById(id).get().getManager().getMgrId();
		Manager manager = mgrRepo.findById(mgrId).get();
		return manager;
	}

	@Override
	public String sendMessageToManager(ProjectStatusModel status) {
		ProjectStatus prstatus = new ProjectStatus();
		prstatus.setMessage(status.getMessage());
		Employee emp = empRepo.findById(status.getEmpId()).get();
		prstatus.setEmp(emp);
		Manager mgr = mgrRepo.findById(status.getMgrId()).get();
		prstatus.setMgr(mgr);
		Integer stId = projStatusRepo.save(prstatus).getPstatusId();
		return stId + " status sent successfully";
	}

	@Override
	public LeaveRequestModel fetchRequiredEmpByEmpId(Integer id) {

		Employee emp = empRepo.findById(id).get();
		LeaveRequestModel request = new LeaveRequestModel();
		request.setEmpName(emp.getName());
		request.setEmail(emp.getEmail());
		request.setManagerName(emp.getManager().getName());
		request.setEmpId(emp.getEmpId());
		return request;
	}

	@Override
	public String sendLeaveRequestToManager(LeaveRequestModel reqMod) {

		LeaveRequest entReq = new LeaveRequest();
		entReq.setEmpName(reqMod.getEmpName());
		String name = reqMod.getEmpName();
		String managerName = reqMod.getManagerName();
		entReq.setFromDate(reqMod.getFromDate());
		entReq.setToDate(reqMod.getToDate());
		entReq.setReason(reqMod.getReason());
		Employee em = empRepo.findById(reqMod.getEmpId()).get();
		entReq.setEmp(em);
		Manager manager = mgrRepo.findById(em.getManager().getMgrId()).get();
		entReq.setMgr(manager);
		Integer id = leaveRepo.save(entReq).getLeaveId();
		return name + " employee send leave request to Manager " + managerName;
	}

	@Override
	public List<LeaveRequest> fetchAllLeaveRequestByEmployeeId(Integer id) {
		System.out.println("****************88"+id);
		List<LeaveRequest> listOfRequests = leaveRepo.fetchAllLeaveRequestByEmpId(id);
		listOfRequests.forEach(x -> System.out.println(x.getEmpName() + "," + x.getReason() + "," + x.getStatus()));
		return listOfRequests;

	}

	@Override
	public HelpDeskModel fetchRequiredEmpInfoById(Integer id) {
		HelpDeskModel hdm = new HelpDeskModel();
		Employee emp = empRepo.findById(id).get();
		hdm.setAdminId(emp.getAdmin().getAdminId());
		hdm.setEmpId(emp.getEmpId());
		hdm.setEmpName(emp.getName());
		hdm.setEmail(emp.getEmail());
		hdm.setMobileNo(emp.getMobileNo());
		return hdm;
	}
	@Override
	public String sendQueryToAdminUsingModel(HelpDeskModel model) {
		
		EmployeeManagerHelpDesk hmhd=new EmployeeManagerHelpDesk();
	    Employee emp = empRepo.findById(model.getEmpId()).get();
	     Admin admin = emp.getAdmin();
		hmhd.setAdmin(admin);
		hmhd.setEmp(emp);
	    hmhd.setMessage(model.getMessage());
	    hmhd.setStatus(model.getStatus());
	@NonNull
	Integer helpId = helpRepo.save(hmhd).getHelpId();
	return emp.getName()+" employee send query and admin  will send response";
	}
	@Override
	public List<HelpDeskModel> fetchHelpQuery(Integer id) {
		List<HelpDeskModel> fetchAllEmpsQueries = helpRepo.fetchAllEmpsQueries(id);
		return fetchAllEmpsQueries;
	}
	@Override
	public List<PaySlipInfo> fetchEmpPayslipInfoById(Integer id) {
		List<PaySlipInfo> slipDetails = slipRepo.fetchEmpPaySlipDetailsByEmpId(id);
		return slipDetails;
	}

}
