package com.siva.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.siva.entity.Employee;
import com.siva.entity.Manager;
import com.siva.entity.ProjectStatus;
import com.siva.initBinders.LocalDateBinder;
import com.siva.model.AssignProjectModel;
import com.siva.model.EmpLogin;
import com.siva.model.HelpDeskModel;
import com.siva.model.LeaveRequestModel;
import com.siva.model.PaySlipInfo;
import com.siva.model.ProjectStatusModel;
import com.siva.model.ViewProjectDetails;
import com.siva.repo.IEmployeeRepo;
import com.siva.service.IManagerService;

@RequestMapping("/manager")
@Controller
public class ManagerControllerClass {

	@Autowired
	private IEmployeeRepo empRepo;

	@Autowired
	private ServletContext sc;
	@Autowired
	private IManagerService mgrService;

	@GetMapping("/home")
	public String displayManagerHome() {
		return "manager_home";
	}

	@InitBinder
	public void myInitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(LocalDate.class, new LocalDateBinder());
	}

	@GetMapping("/manager_login")
	public String managerLoginPage(@ModelAttribute("mgr") EmpLogin mgr) {
		return "manager_login";
	}

	@PostMapping("/manager_login")
	public String loginToManagerDashBoard(@ModelAttribute("mgr") EmpLogin mgr, RedirectAttributes attri,
			HttpSession ses) {
		Optional<Manager> opt = mgrService.fetchManagerDetails(mgr.getEmail(), mgr.getPassword());
		if (opt.isPresent()) {
			Manager manager = opt.get();
			ses.setAttribute("mgr", manager);
			return "redirect:manager_dashboard";
		} else {
			String message = "Invalid Login crediantials";
			attri.addFlashAttribute("message", message);
			return "redirect:manager_login";

		}
	}

	@GetMapping("/manager_dashboard")
	public String displayManagerDashBoard(HttpSession ses, Map<String, Object> map) {
		Manager mgr = (Manager) ses.getAttribute("mgr");
		map.put("mgr_info", mgr);
		return "manager_dashboard";
	}

	@GetMapping("/show_mgr_info")
	public String displayManagerInfo(HttpSession ses,Map<String,Object> map)
	{
	Manager mgr=(Manager)ses.getAttribute("mgr");
	map.put("mgrInfo", mgr);
	return "mgr_profile";
	}
	@GetMapping("/logout")
	public String employeeLogout(HttpSession ses) {
		ses.invalidate();
		return "redirect:home";
	}

	@GetMapping("/emp_details")
	public String fetchEmployeeDetailsFromManager(Map<String, Object> map, HttpSession ses) {
		Manager mgr = (Manager) ses.getAttribute("mgr");
		List<Employee> emps = mgrService.fetchAllEmployeeDetails(mgr.getMgrId());
		map.put("empsList", emps);
		return "manager_employee_details";
	}

	@GetMapping("/emp_details_to_assign_proj")
	public String assignProjectToEmployee(@RequestParam("empId") Integer empId,
			@ModelAttribute("proj") AssignProjectModel proj) {
		AssignProjectModel empModel = mgrService.fetchEmployeeById(empId);
		BeanUtils.copyProperties(empModel, proj);
		return "assign_project";
	}

	@PostMapping("/emp_details_to_assign_proj")
	public String saveProjectToEmployee(@ModelAttribute("proj") AssignProjectModel proj, RedirectAttributes attri) {
		String message = mgrService.setProjectToEmployeeByManager(proj);
		System.out.println(message);
		attri.addFlashAttribute("message", message);
		return "redirect:emp_details";
	}

	@GetMapping("/project_details")
	public String displayProjectDetails(Map<String, Object> map, HttpSession ses) {
		Manager mgr = (Manager) ses.getAttribute("mgr");
		List<ViewProjectDetails> fetchProjectDetails = mgrService.getProjectDetailsByMgrId(mgr.getMgrId());
		map.put("project_info", fetchProjectDetails);
		return "mgr_view_project_details";
	}

	@GetMapping("/check_project_status")
	public String checkProjectStatus(HttpSession ses, @RequestParam("empId") Integer empId, Map<String, Object> map,
			@ModelAttribute("status") ProjectStatusModel projStatus) {
		Employee emp = mgrService.fetchEmployeeDetailsById(empId);
		map.put("emp_info", emp);
		List<ProjectStatus> messages = mgrService.fetchProjectStatusByEmpId(empId);
		map.put("proj_status", messages);
		return "mgr_check_project_status";
	}

	@PostMapping("/send_project_status_response")
	public String sendResponseToEmployee(@ModelAttribute("status") ProjectStatusModel projStatus,
			RedirectAttributes attri) {
		Integer empId = projStatus.getEmpId();
		String result = mgrService.sendResponseToEmployee(projStatus);
		attri.addFlashAttribute("message", result);
		return "redirect:check_project_status?empId=" + empId;
	}

	@GetMapping("/show_employee_leaves")
	public String showEmployeeLeaves(HttpSession ses, Map<String, Object> map) {
		Manager mgr = (Manager) ses.getAttribute("mgr");
		List<LeaveRequestModel> leaveRequests = mgrService.fetchAllEmpsLeaveRequestByMgrId(mgr.getMgrId());
		map.put("listOfLeaveRequest", leaveRequests);
		return "mgr_show_leave_requests";
	}

	@GetMapping("/update_emp_leave_request")
	public String updateEmployeeLeaveRequest(@RequestParam("empId") Integer empId,
			@RequestParam("response") String response, RedirectAttributes attri) {
		String message = mgrService.udpateEmployeeLeaveRequest(empId, response);
		attri.addFlashAttribute("message", message);
		return "redirect:show_employee_leaves";
	}

	@GetMapping("/send_query")
	public String showQueryForm(HttpSession ses, @ModelAttribute("help") HelpDeskModel help) {
		Manager mgr = (Manager) ses.getAttribute("mgr");
		HelpDeskModel hdm = mgrService.fetchRequiredMgrInfoById(mgr.getMgrId());
		BeanUtils.copyProperties(hdm, help);
		return "mgr_query_form";
	}

	@PostMapping("/send_query")
	public String sendQueryToAdmin(@ModelAttribute("help") HelpDeskModel help, RedirectAttributes attri) {
		String message = mgrService.sendQueryToAdminUsingModel(help);
		attri.addFlashAttribute("message", message);
		return "redirect:show_mgr_query_status";
	}

	@GetMapping("/show_mgr_query_status")
	public String showEmployeeQueryStatus(Map<String, Object> map, HttpSession ses) {
		Manager mgr = (Manager) ses.getAttribute("mgr");
		List<HelpDeskModel> fetchHelpQuery = mgrService.fetchHelpQuery(mgr.getMgrId());
		System.out.println(fetchHelpQuery.toString());
		map.put("query_status", fetchHelpQuery);
		return "mgr_admin_query_status";
	}

	@GetMapping("/show_mgr_pay_slip")
	public String showMgrPaySlip(HttpSession ses, Map<String, Object> map) {
		Manager mgr = (Manager) ses.getAttribute("mgr");
		List<PaySlipInfo> info = mgrService.fetchPaySlipInfo(mgr.getMgrId());
		map.put("slip_info", info);
		return "mgr_pay_slip_info";
	}

	@GetMapping("/download_mgr_pay_slip")
	public String downloadEmpPaySlip(@RequestParam("filePath") String path, HttpServletResponse res)
			throws IOException {
		// create java.io.File object pointing to the file to download
		File file = new File(path);
		// get the length of the file and make it as response content length
		res.setContentLengthLong(file.length());
		// get the MIME of the file to be download and make it as the response content
		// type
		String mimeType = sc.getMimeType(path);
		mimeType = mimeType != null ? mimeType : "application/octet-stream";
		res.setContentType(mimeType);
		// create inputstream pointing to the file to be downloaded

		InputStream is = new FileInputStream(file);
		// create outputStream pointing to the response object
		OutputStream os = res.getOutputStream();
		res.setHeader("Content-Disposition", "attachment;fileName=" + file.getName());
		IOUtils.copy(is, os);
		is.close();
		os.close();
		return null;
	}

}
