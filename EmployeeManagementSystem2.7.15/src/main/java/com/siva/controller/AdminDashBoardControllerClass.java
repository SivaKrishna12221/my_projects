package com.siva.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.siva.entity.Admin;
import com.siva.entity.Employee;
import com.siva.entity.Manager;
import com.siva.initBinders.LocalDateBinder;
import com.siva.model.EmployeeModel;
import com.siva.model.HelpDeskModel;
import com.siva.model.ManagerAssignModel;
import com.siva.model.PaySlipModel;
import com.siva.service.IAdminMgmtService;
import com.siva.service.IEmpMgmtService;
import com.siva.validation.AdminValidator;
import com.siva.validation.EmployeeVaildation;

@Controller
@RequestMapping("/admin")
public class AdminDashBoardControllerClass {

	@Autowired
	private IEmpMgmtService empService;

	@Autowired
	private IAdminMgmtService adminService;

	@Autowired
	private EmployeeVaildation validator;

	@Autowired
	private AdminValidator adValidator;

	@InitBinder
	public void myInitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(LocalDate.class, new LocalDateBinder());
	}

	@GetMapping("/home")
	public String showAdminHome() {
		return "admin_home";
	}

	@GetMapping("/admin_register")
	public String showAdminRegister(@ModelAttribute("admin") Admin admin) {
		return "admin_register";
	}
	@PostMapping("/admin_register")
	public String saveAdminDetails(@ModelAttribute("admin") Admin admin, RedirectAttributes attri,
			BindingResult errors) {
		if (adValidator.supports(admin.getClass())) {
			adValidator.validate(admin, errors);
			if (errors.hasErrors()) {
				List<ObjectError> allErrors = errors.getAllErrors();
				allErrors.forEach(x -> System.out.println(x.toString()));
				return "admin_register";
			}

		}
		Integer id = adminService.registerAdmin(admin);
		attri.addFlashAttribute("message", id + "id  admin is registered successfully");
		return "redirect:home";
	}

	@GetMapping("/admin_login")
	public String showAdminLoginPage(@ModelAttribute("admin") Admin admin) {
		return "admin_login";
	}

	@PostMapping("/admin_login")
	public String loginAdmin(@ModelAttribute("admin") Admin admin, HttpSession session, RedirectAttributes attri) {
		Optional<Admin> opt = adminService.verifyAdminCrediantials(admin.getUsername(), admin.getPassword());
		if (opt.isPresent()) {
			Admin admin2 = opt.get();
			session.setAttribute("admin", admin2);
			return "redirect:admin_dashboard";
		} else {
			attri.addFlashAttribute("message", "Invalid login crediantials");
			return "redirect:admin_login";
		}

	}

	@GetMapping("/admin_dashboard")
	public String displayAdminDashBoard(HttpSession ses, Map<String, Object> map) {
		Admin adm = (Admin) ses.getAttribute("admin");
		System.out.println(adm.toString());
		map.put("admin", adm);
		return "admin_dashboard";
	}
	@GetMapping("/show_admin_info")
	public  String adminInfo(HttpSession ses,Map<String,Object> map)
	{
		Admin adm=(Admin)ses.getAttribute("admin");
		map.put("adminInfo",adm);
		return "admin_profile";
	}
    @GetMapping("/logout")
    public String adminLogout(HttpSession ses)
    {
    	ses.invalidate();
    	return "redirect:home";
    }
	@GetMapping("/add_employee")
	public String addNewEmployee(@ModelAttribute("emp") EmployeeModel empModel, HttpSession ses) {
		Admin adm = (Admin) ses.getAttribute("admin");
		empModel.setAdmId(adm.getAdminId());
		return "add_employee";
	}

	@PostMapping("/add_employee")
	public String saveEmployee(@ModelAttribute("emp") EmployeeModel emp, RedirectAttributes attri,
			BindingResult errors, HttpSession session) {
		Integer admId = emp.getAdmId();
		if (validator.supports(emp.getClass())) {
			validator.validate(emp, errors);
			if (errors.hasErrors()) {
				List<ObjectError> allErrors = errors.getAllErrors();
				allErrors.forEach(x -> System.out.println(x.toString()));
				return "add_employee";
			}

		}
		if (emp.getRole().equalsIgnoreCase("employee")) {
			String empSaveMessage = adminService.registerEmployeeDetails(emp);
			attri.addFlashAttribute("message", empSaveMessage);
			return "redirect:view_employee";
		} else {
			String empSaveMessage = adminService.registerManagerDetails(emp);
			attri.addFlashAttribute("message", empSaveMessage);
			return "redirect:view_manager";

		}
	}

	@GetMapping("/view_employee")
	public String showEmployeeDetails(Map<String, Object> map) {
		List<Employee> fetchListOfEmployees = adminService.fetchListOfEmployees();
		map.put("empsList", fetchListOfEmployees);
		return "view_employee";
	}
    @GetMapping("/download_emps_info")
    public String downloadEmployeeDetails(@RequestParam("file") String file,Map<String,Object> map)
    {
       if(file.equalsIgnoreCase("pdf")) {
    	List<Employee> fetchListOfEmployees = adminService.fetchListOfEmployees();
    	map.put("empsList", fetchListOfEmployees);
    	return "emp-pdf";
       }else
       {
    	   List<Employee> fetchListOfEmployees = adminService.fetchListOfEmployees();
       	map.put("empsList", fetchListOfEmployees);
       	return "emp-excel";
        
       }
    	
    }
	@GetMapping("/view_manager")
	public String showManagerDetails(Map<String, Object> map) {
		List<Manager> fetchListOfManagers = adminService.fetchListOfManagers();
		map.put("mgrsList", fetchListOfManagers);
		return "view_manager";
	}
    @GetMapping("/download_mgrs_info")
    public String downloadManagersInfo(@RequestParam("file")String file,Map<String,Object> map)
    {
    	if(file.equalsIgnoreCase("pdf"))
    	{
    		List<Manager> fetchListOfManagers = adminService.fetchListOfManagers();
    		map.put("mgrsList", fetchListOfManagers);
    		return "mgr-pdf";
    	}
    	else
    	{
    		List<Manager> fetchListOfManagers = adminService.fetchListOfManagers();
    		map.put("mgrsList", fetchListOfManagers);
    		return "mgr-excel";
    	}
    }
	@ModelAttribute("cities")
	public Set<String> displayCities() {
		Set<String> ListOfCities = adminService.fetchListOfCities();
		return ListOfCities;
	}

	@ModelAttribute("states")
	public Set<String> displayStates() {
		Set<String> setOfStates = adminService.fetchListOfStates();
		return setOfStates;
	}

	@GetMapping("/edit_emp")
	public String editEmployee(@RequestParam("empId") Integer id, @ModelAttribute("emp") EmployeeModel emp) {
		EmployeeModel empModel = adminService.fetchEmployeeById(id);
		BeanUtils.copyProperties(empModel, emp);
		return "edit_employee";
	}

	@PostMapping("/edit_emp")
	public String saveEditEmployee(@ModelAttribute("emp") EmployeeModel emp, RedirectAttributes attri,
			BindingResult errors) {
		if (validator.supports(emp.getClass())) {
			validator.validate(emp, errors);
			if (errors.hasErrors()) {
				List<ObjectError> allErrors = errors.getAllErrors();
				allErrors.forEach(x->System.out.println(x.toString()));
				return "edit_employee";
			}
		}
		Integer number = adminService.saveEditedEmployee(emp);
		String result = number + " employee edited succesfully";
		attri.addFlashAttribute("message", result);
		return "redirect:view_employee";
	}

	@GetMapping("/delete_emp")
	public String deleteEmployeeById(@RequestParam("empId") Integer id, RedirectAttributes attri) {
		String deleteMessage = adminService.deleteEmployeeById(id);
		attri.addFlashAttribute("message", deleteMessage);
		return "redirect:view_employee";
	}

	@GetMapping("/edit_mgr")
	public String editManager(@RequestParam("mgrId") Integer id, @ModelAttribute("emp") EmployeeModel emp) {
		EmployeeModel empModel = adminService.fetchMangerById(id);
		BeanUtils.copyProperties(empModel, emp);
		return "edit_manager";
	}

	@PostMapping("/edit_mgr")
	public String saveEditManager(@ModelAttribute("emp") EmployeeModel emp, RedirectAttributes attri,BindingResult errors) {
		if (validator.supports(emp.getClass())) {
			validator.validate(emp, errors);
			if (errors.hasErrors()) {
				List<ObjectError> allErrors = errors.getAllErrors();
				allErrors.forEach(x->System.out.println(x.toString()));
				return "edit_manager";
			}
		}
		Integer id = adminService.saveEditedManager(emp);
		String message = id + ": id manager Details are edited";
		attri.addFlashAttribute("message", message);
		return "redirect:view_manager";

	}

	@GetMapping("/delete_mgr")
	public String deleteManagerById(@RequestParam("mgrId") Integer id, RedirectAttributes attri) {
		String deleteMessage = adminService.deleteManagerById(id);
		attri.addFlashAttribute("message", deleteMessage);
		return "redirect:view_Manager";
	}

	@GetMapping("/manager_assign")
	public String managerAssignOperation(Map<String, Object> map) {
		List<Employee> emps = adminService.fetchListOfEmployees();
		map.put("empsList", emps);
		return "manager_assign";
	}

	@GetMapping("/assign_manager")
	public String assignManagerToEmployee(@ModelAttribute("mgr") ManagerAssignModel mgr,
			@RequestParam("empId") Integer id) {
		ManagerAssignModel empToAssign = adminService.fetchEmployeToAssignManager(id);
		BeanUtils.copyProperties(empToAssign, mgr);
		return "assign_manager";
	}

	@PostMapping("/assign_manager")
	public String saveManagerToEmployee(@ModelAttribute("mgr") ManagerAssignModel mgr, RedirectAttributes attri) {
		System.out.println(mgr.getAssignAction());
		String result = adminService.assignManagerToEmployeeByModel(mgr);
		attri.addFlashAttribute("message", result);
		return "redirect:manager_assign";
	}

	@ModelAttribute("managers")
	public Set<String> listOfManagersNames() {
		return adminService.fetchListOfManagerNames();
	}

	@GetMapping("/view_queries")
	public String showQueries(Map<String, Object> map) {
	 	return "view_all_queries";
	}

	@GetMapping("/show_all_emp_queries")
	public String displayAllEmpsQueries(HttpSession ses, Map<String, Object> map) {
		Admin adm=(Admin)ses.getAttribute("admin");
		List<HelpDeskModel> queries = adminService.fetchAllEmpsQueryByAdminId(adm.getAdminId());
		map.put("emp_queries", queries);
		return "admin_emp_queries";
	}

	@GetMapping("/send_response_to_emp_query")
	public String showResponseFormToMgr(@RequestParam("empId") Integer empId, @RequestParam("helpId") Integer helpId,
			@ModelAttribute("help") HelpDeskModel help) {
		HelpDeskModel hdm = adminService.fetchEmpDetailsById(empId);
		hdm.setMsgId(helpId);
		BeanUtils.copyProperties(hdm, help);
		return "admin_query_response";
	}

	@PostMapping("/send_response_to_emp_query")
	public String sendResponseToEmp(@ModelAttribute("help") HelpDeskModel help, RedirectAttributes attri) {
		String message = adminService.updateStatusOfEmpQueryUsingModel(help);
		attri.addFlashAttribute("message", message);
		Integer adminId = help.getAdminId();
		return "redirect:show_all_emp_queries?adminId=" + adminId;
	}

	@GetMapping("/show_all_mgr_queries")
	public String displayAllmgrsQueries(HttpSession ses, Map<String, Object> map) {
		Admin adm=(Admin)ses.getAttribute("admin");
		List<HelpDeskModel> queries = adminService.fetchAllMgrsQueryByAdminId(adm.getAdminId());
		map.put("mgr_queries", queries);
		return "admin_mgr_queries";
	}

	@GetMapping("/send_response_to_mgr_query")
	public String showResponseForm(@RequestParam("mgrId") Integer mgrId, @RequestParam("helpId") Integer helpId,
			@ModelAttribute("help") HelpDeskModel help) {
		HelpDeskModel hdm = adminService.fetchMgrDetailsById(mgrId);
		hdm.setMsgId(helpId);
		BeanUtils.copyProperties(hdm, help);
		return "admin_query_response";
	}

	@PostMapping("/send_response_to_mgr_query")
	public String sendResponseToMgr(@ModelAttribute("help") HelpDeskModel help, RedirectAttributes attri) {
		String message = adminService.updateStatusOfMgrQueryUsingModel(help);
		attri.addFlashAttribute("message", message);
		Integer adminId = help.getAdminId();
		return "redirect:show_all_mgr_queries?adminId=" + adminId;
	}

	@GetMapping("/pay_slips")
	public String paySlipUploads() {
		return "admin_pay_slip";
	}

	@GetMapping("/pay_slip_for_emp")
	public String paySlipForEmps(Map<String, Object> map) {
		List<Employee> fetchListOfEmployees = adminService.fetchListOfEmployees();
		map.put("empsList", fetchListOfEmployees);
		return "view_emp_pay_slip";
	}

	@GetMapping("/upload_emp_pay_slip")
	public String uploadPaySlipForEmp(@RequestParam("empId") Integer id,
			@ModelAttribute("pay_slip") PaySlipModel paySlip) {

		PaySlipModel slip = adminService.fetchPaySlipModelByEmpId(id);
		BeanUtils.copyProperties(slip, paySlip);
		return "upload_pay_slip_form";
	}

	@PostMapping("/upload_emp_pay_slip")
	public String sendPaySlipToEmp(@ModelAttribute("pay_slip") PaySlipModel paySlip, RedirectAttributes attri)
			throws Exception {
		String msg = adminService.savePaySlipInSystemAndPathInDb(paySlip);
		attri.addFlashAttribute("message", msg);
		return "redirect:pay_slip_for_emp";
	}

	@GetMapping("/pay_slip_for_mgr")
	public String paySlipForMgrs(Map<String, Object> map) {
		List<Manager> fetchListOfManagers = adminService.fetchListOfManagers();
		map.put("mgrsList", fetchListOfManagers);
		return "view_mgr_pay_slip";
	}

	@GetMapping("/upload_mgr_pay_slip")
	public String uploadPaySlipForMgr(@RequestParam("mgrId") Integer id,
			@ModelAttribute("pay_slip") PaySlipModel paySlip) {

		PaySlipModel slip = adminService.fetchPaySlipModelByMgrId(id);
		BeanUtils.copyProperties(slip, paySlip);
		return "upload_pay_slip_form";
	}

	@PostMapping("/upload_mgr_pay_slip")
	public String sendPaySlipToMgr(@ModelAttribute("pay_slip") PaySlipModel paySlip, RedirectAttributes attri)
			throws Exception {
		String message = adminService.saveMgrPaySlip(paySlip);
		attri.addFlashAttribute("message", message);
		return "redirect:pay_slip_for_mgr";
	}

}
