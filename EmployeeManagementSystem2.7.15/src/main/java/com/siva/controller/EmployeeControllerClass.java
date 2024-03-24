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
import com.siva.entity.LeaveRequest;
import com.siva.entity.Manager;
import com.siva.entity.ProjectStatus;
import com.siva.initBinders.LocalDateBinder;
import com.siva.model.EmpLogin;
import com.siva.model.HelpDeskModel;
import com.siva.model.LeaveRequestModel;
import com.siva.model.PaySlipInfo;
import com.siva.model.ProjectStatusModel;
import com.siva.model.ViewProjectDetails;
import com.siva.service.IEmpMgmtService;

@Controller
@RequestMapping("/emp")
public class EmployeeControllerClass {

	@Autowired
	private IEmpMgmtService empService;

	@Autowired
	private ServletContext sc;

	@GetMapping("/home")
	public String showEmpPage() {
		return "emp_home";
	}

	@GetMapping("/emp_login")
	public String showLogin(@ModelAttribute("emp") EmpLogin emp) {
		return "emp_login";
	}

	@InitBinder
	public void myInitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(LocalDate.class, new LocalDateBinder());
	}

	@PostMapping("/emp_login")
	public String doLogin(@ModelAttribute("emp") Employee emp, RedirectAttributes attri, HttpSession ses) {
		Optional<Employee> emps = empService.fetchEmpDetails(emp.getEmail(), emp.getPassword());
		attri.addFlashAttribute("message", "Invalid Crediantials");
		if (emps.isEmpty()) {
			return "redirect:emp_login";
		} else {
			Employee employee = emps.get();
			ses.setAttribute("emp", employee);
			return "redirect:emp_dashboard";
		}
	}

	@GetMapping("/emp_dashboard")
	public String displayEmployeeDashBoard(HttpSession ses, Map<String, Object> map) {
		Employee empl = (Employee) ses.getAttribute("emp");
		map.put("emp_info", empl);
		return "emp_dashboard";
	}

	@GetMapping("show_emp_info")
	public String showEmployeeProfile(HttpSession ses, Map<String, Object> map) {
		Employee emp1 = (Employee) ses.getAttribute("emp");
		map.put("empInfo", emp1);
		return "emp_profile";
	}

	@GetMapping("/logout")
	public String employeeLogout(HttpSession ses) {
		ses.invalidate();
		return "redirect:home";
	}

	@GetMapping("/project_details")
	public String displayProjectDetails(HttpSession ses, Map<String, Object> map) {
		Employee emp = (Employee) ses.getAttribute("emp");
		List<ViewProjectDetails> fetchProjectDetails = empService.fetchProjectDetails(emp.getEmpId());
		map.put("project_info", fetchProjectDetails);
		return "emp_view_project_details";
	}

	@GetMapping("/check_project_status")
	public String seeProjectStatusManager(HttpSession ses, @ModelAttribute("status") ProjectStatusModel projStatus,
			Map<String, Object> map) {
		Employee empl = (Employee) ses.getAttribute("emp");
		Manager mgr = empService.fetchManagerByEmployeeId(empl.getEmpId());
		map.put("empId", empl.getEmpId());
		map.put("manager", mgr);
		List<ProjectStatus> messages = empService.fetchProjectStatus(empl.getEmpId());
		map.put("messages", messages);
		return "check_project_status";
	}

	@PostMapping("/send_project_status")
	public String sendProjectStatus(@ModelAttribute("status") ProjectStatusModel projStatus, RedirectAttributes attri) {

		String message = empService.sendMessageToManager(projStatus);
		attri.addFlashAttribute("message", message);
		return "redirect:check_project_status";
	}

	@GetMapping("/leave_apply")
	public String displayLeaveForm(@ModelAttribute("leave") LeaveRequestModel request, HttpSession ses) {
		Employee empl = (Employee) ses.getAttribute("emp");
		LeaveRequestModel requestContent = empService.fetchRequiredEmpByEmpId(empl.getEmpId());
		BeanUtils.copyProperties(requestContent, request);
		return "apply_leave";
	}

	@PostMapping("/leave_apply")
	public String sendLeaveRequest(@ModelAttribute("leave") LeaveRequestModel requestModel, RedirectAttributes attri) {
		String request = empService.sendLeaveRequestToManager(requestModel);
		attri.addFlashAttribute("message", request);
		return "redirect:show_leave_status";
	}

	@GetMapping("/show_leave_status")
	public String displayLeaveDetails(Map<String, Object> map, HttpSession ses) {
		Employee empl = (Employee) ses.getAttribute("emp");
		List<LeaveRequest> listOfRequests = empService.fetchAllLeaveRequestByEmployeeId(empl.getEmpId());
		map.put("leaves", listOfRequests);
		return "emp_leave_status";
	}

	@GetMapping("/send_query")
	public String showQueryForm(HttpSession ses, @ModelAttribute("help") HelpDeskModel help) {
		Employee empl = (Employee) ses.getAttribute("emp");
		HelpDeskModel hdm = empService.fetchRequiredEmpInfoById(empl.getEmpId());
		BeanUtils.copyProperties(hdm, help);
		return "emp_query_form";
	}

	@PostMapping("/send_query")
	public String sendQueryToAdmin(@ModelAttribute("help") HelpDeskModel help, RedirectAttributes attri) {

		String message = empService.sendQueryToAdminUsingModel(help);
		attri.addFlashAttribute("message", message);
		return "redirect:show_emp_query_status";
	}

	@GetMapping("/show_emp_query_status")
	public String showEmployeeQueryStatus(Map<String, Object> map, HttpSession ses) {
		Employee empl = (Employee) ses.getAttribute("emp");
		List<HelpDeskModel> fetchHelpQuery = empService.fetchHelpQuery(empl.getEmpId());
		map.put("query_status", fetchHelpQuery);
		return "emp_admin_query_status";
	}

	@GetMapping("/pay_slip")
	public String showEmpPaySlip(HttpSession ses, Map<String, Object> map) {
		Employee empl = (Employee) ses.getAttribute("emp");

		List<PaySlipInfo> details = empService.fetchEmpPayslipInfoById(empl.getEmpId());
		map.put("slip_info", details);
		return "emp_pay_slip_info";
	}

	@SuppressWarnings("resource")
	@GetMapping("/download_emp_pay_slip")
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
