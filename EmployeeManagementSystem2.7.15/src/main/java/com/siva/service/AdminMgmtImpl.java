package com.siva.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.siva.entity.Admin;
import com.siva.entity.Employee;
import com.siva.entity.Manager;
import com.siva.entity.PaySlip;
import com.siva.model.EmployeeModel;
import com.siva.model.HelpDeskModel;
import com.siva.model.ManagerAssignModel;
import com.siva.model.PaySlipModel;
import com.siva.repo.IAdminRepo;
import com.siva.repo.IEmployeeRepo;
import com.siva.repo.IHelpDeskRepo;
import com.siva.repo.IManagerRepo;
import com.siva.repo.IPaySlipRepository;

@Service("admin-service")
public class AdminMgmtImpl implements IAdminMgmtService {

	@Autowired
	private Environment envi;
	@Autowired
	private IAdminRepo adminRepo;

	@Autowired
	private IManagerRepo mgrRepo;
	@Autowired
	private IEmployeeRepo empRepo;

	@Autowired
	private IHelpDeskRepo helpRepo;
	@Autowired
	private IPaySlipRepository slipRepo;
	
	@Override
	public Integer registerAdmin(Admin admin) {
		Integer adminId = adminRepo.save(admin).getAdminId();
		return adminId;
	}

	@Override
	public Optional<Admin> verifyAdminCrediantials(String username, String password) {
		return adminRepo.findByUsernameAndPassword(username, password);
	}

	@Override
	public Admin fetchAdminById(Integer Id) {
		Optional<Admin> opt = adminRepo.findById(Id);
		if (opt.isEmpty()) {
			throw new IllegalArgumentException(" Admin not found");
		} else {
			Admin admin = opt.get();
			return admin;
		}
	}

	@Override
	public Set<String> fetchListOfCities() {
		String strCities = envi.getProperty("cities.list");
		String[] cslist = strCities.split(",");
		Set<String> cities = new TreeSet<>();
		for (String city : cslist) {
			cities.add(city);
		}
		return cities;

	}

	@Override
	public Set<String> fetchListOfStates() {

		String states = envi.getProperty("states.list");
		String[] slstates = states.split(",");
		TreeSet<String> setOfStates = new TreeSet<>();
		for (String str : slstates) {
			setOfStates.add(str);
		}
		return setOfStates;
	}

	@Override
	public String registerEmployeeDetails(EmployeeModel emp) {
		Employee emp1 = new Employee();
		emp1.setAddress(emp.getAddress());
		Admin admin = adminRepo.findById(emp.getAdmId()).get();
		emp1.setAdmin(admin);
		emp1.setCity(emp.getCity());
		emp1.setConfirmPassword(emp.getConfirmPassword());
		emp1.setDob(emp.getDob());
		emp1.setEmail(emp.getEmail());
		emp1.setMobileNo(emp.getMobileNo());
		emp1.setName(emp.getFirstName() + " " + emp.getLastName());
		emp1.setPassword(emp.getPassword());
		emp1.setRole(emp.getRole());
		emp1.setState(emp.getState());
		emp1.setManagerAssign(emp.getManagerAssign());
		Integer empId = empRepo.save(emp1).getEmpId();
		return empId + " Id Employee Is Added Successfully";
	}

	@Override
	public String registerManagerDetails(EmployeeModel emp) {
		Manager mgr1 = new Manager();
		mgr1.setAddress(emp.getAddress());
		Admin admin = adminRepo.findById(emp.getAdmId()).get();
		mgr1.setAdmin(admin);
		mgr1.setCity(emp.getCity());
		mgr1.setConfirmPassword(emp.getConfirmPassword());
		mgr1.setDob(emp.getDob());
		mgr1.setEmail(emp.getEmail());
		mgr1.setMobileNo(emp.getMobileNo());
		mgr1.setName(emp.getFirstName() + " " + emp.getLastName());
		mgr1.setPassword(emp.getPassword());
		mgr1.setRole(emp.getRole());
		mgr1.setState(emp.getState());
		Integer mgrId = mgrRepo.save(mgr1).getMgrId();
		return mgrId + " Id Manager Is Added Successfully";
	}

	@Override
	public List<Employee> fetchListOfEmployees() {
		List<Employee> emps = empRepo.findAll();
		return emps;
	}

	@Override
	public List<Manager> fetchListOfManagers() {
		return mgrRepo.findAll();
	}

	@Override
	public EmployeeModel fetchEmployeeById(Integer id) {
		Optional<Employee> opt = empRepo.findById(id);
		if (opt.isEmpty()) {
			throw new IllegalArgumentException("Employee not found");
		} else {
			Employee emp = opt.get();
			System.out.println(emp.getRole());
			System.out.println("***");
			EmployeeModel em = new EmployeeModel();
			em.setEmpId(emp.getEmpId());
			String[] split = emp.getName().split(" ");
			em.setFirstName(split[0]);
			em.setLastName(split[1]);
			em.setDob(emp.getDob());
			em.setMobileNo(emp.getMobileNo());
			em.setEmail(emp.getEmail());
			em.setAddress(emp.getAddress());
			em.setCity(emp.getCity());
			em.setState(emp.getState());
			em.setPincode(emp.getPincode());
			System.out.println("************8");
			System.out.println(emp.getPassword());
            em.setConfirmPassword(emp.getConfirmPassword());
            em.setPassword(emp.getPassword());
			return em;
		}
	}

	@Override
	public Integer saveEditedEmployee(EmployeeModel emp) {

		Optional<Employee> opt = empRepo.findById(emp.getEmpId());
		if (opt.isPresent()) {
			Employee emp1 = opt.get();
			System.out.println(emp1.getRole());
			System.out.println("************");
			System.out.println(emp.getRole());
			emp1.setAddress(emp.getAddress());
			emp1.setCity(emp.getCity());
			emp1.setDob(emp.getDob());
			emp1.setEmail(emp.getEmail());
			emp1.setMobileNo(emp.getMobileNo());
			emp1.setName(emp.getFirstName() + " " + emp.getLastName());

			emp1.setState(emp.getState());
			emp1.setPincode(emp.getPincode());

			Integer empId = empRepo.save(emp1).getEmpId();
			return empId;
		} else {
			throw new IllegalArgumentException("Employee not found");
		}

	}

	@Override
	public String deleteEmployeeById(Integer id) {
		Optional<Employee> opt = empRepo.findById(id);
		if (opt.isPresent()) {
			empRepo.deleteById(id);
			return id + " Employee is deleted successfully";
		} else {
			throw new IllegalArgumentException("Employee not found");
		}
	}

	@Override
	public EmployeeModel fetchMangerById(Integer id) {
		Optional<Manager> opt = mgrRepo.findById(id);
		if (opt.isEmpty()) {
			throw new IllegalArgumentException("Manager not found");
		} else {
			Manager emp = opt.get();
			EmployeeModel em = new EmployeeModel();
			em.setEmpId(emp.getMgrId());
			String[] split = emp.getName().split(" ");
			em.setFirstName(split[0]);
			em.setLastName(split[1]);
			em.setDob(emp.getDob());
			em.setMobileNo(emp.getMobileNo());
			em.setEmail(emp.getEmail());
			em.setAddress(emp.getAddress());
			em.setCity(emp.getCity());
			em.setState(emp.getState());
			em.setPincode(emp.getPincode());
            em.setConfirmPassword(emp.getConfirmPassword());
            em.setPassword(emp.getPassword());
			return em;
		}
	}

	@Override
	public Integer saveEditedManager(EmployeeModel emp) {

		Optional<Manager> opt = mgrRepo.findById(emp.getEmpId());
		if (opt.isPresent()) {
			Manager emp1 = opt.get();
			emp1.setAddress(emp.getAddress());
			emp1.setCity(emp.getCity());
			emp1.setDob(emp.getDob());
			emp1.setEmail(emp.getEmail());
			emp1.setMobileNo(emp.getMobileNo());
			emp1.setName(emp.getFirstName() + " " + emp.getLastName());
			emp1.setPincode(emp.getPincode());
			emp1.setState(emp.getState());
			Integer empId = mgrRepo.save(emp1).getMgrId();
			return empId;
		} else {
			throw new IllegalArgumentException("Manager not found");
		}

	}

	@Override
	public String deleteManagerById(Integer id) {
		Optional<Manager> opt = mgrRepo.findById(id);
		if (opt.isPresent()) {
			mgrRepo.deleteById(id);
			return id + " Manager is deleted successfully";
		} else {
			throw new IllegalArgumentException("Manager not found");
		}
	}

	@Override
	public ManagerAssignModel fetchEmployeToAssignManager(Integer id) {
		Optional<Employee> opt = empRepo.findById(id);
		Employee emp = opt.get();
		ManagerAssignModel mgr = new ManagerAssignModel();
		mgr.setEmpId(emp.getEmpId());
		mgr.setEmpMail(emp.getEmail());

		mgr.setEmpName(emp.getName());
		return mgr;
	}

	@Override
	public Set<String> fetchListOfManagerNames() {
		return mgrRepo.fetchManagerNameList();
	}

	@Override
	public String assignManagerToEmployeeByModel(ManagerAssignModel mam) {

		Optional<Employee> opt = empRepo.findById(mam.getEmpId());
		if (opt.isPresent()) {
			Employee emp1 = opt.get();
			Manager manager = mgrRepo.findByName(mam.getManagerName());
			emp1.setManagerAssign(mam.getManagerName());
			emp1.setManagerAssignAction(mam.getAssignAction());
			emp1.setManager(manager);
			Employee e = empRepo.save(emp1);
			return e.getEmpId() + "id Manager assigned";
		} else {
			throw new IllegalArgumentException("Employee not found");
		}
	}

	@Override
	public List<HelpDeskModel> fetchAllEmpsQueryByAdminId(Integer id) {
		
		List<HelpDeskModel> empsQueries = helpRepo.fetchAllEmpsQueriesByAdminId(id);
		return empsQueries;
	}@Override
	public HelpDeskModel fetchEmpDetailsById(Integer id) {
		Employee emp = empRepo.findById(id).get();
		HelpDeskModel hdm= new HelpDeskModel();
		hdm.setEmpName(emp.getName());
		hdm.setEmail(emp.getEmail());
		hdm.setEmpId(emp.getEmpId());
		hdm.setAdminId(emp.getAdmin().getAdminId());
		return hdm;
	}
	@Override
	public String updateStatusOfEmpQueryUsingModel(HelpDeskModel help) {
	      helpRepo.updateStatusOfEmpQueryUsingId(help.getStatus(), help.getMsgId());
	      return "Send response to "+ help.getEmpName();
	}
	@Override
	public List<HelpDeskModel> fetchAllMgrsQueryByAdminId(Integer id) {
		
		List<HelpDeskModel> empsQueries = helpRepo.fetchAllmgrsQueriesByAdminId(id);
		return empsQueries;
	}@Override
	public HelpDeskModel fetchMgrDetailsById(Integer id) {
		Manager emp = mgrRepo.findById(id).get();
		HelpDeskModel hdm= new HelpDeskModel();
		hdm.setEmpName(emp.getName());
		hdm.setEmail(emp.getEmail());
		hdm.setMgrId(emp.getMgrId());
		hdm.setAdminId(emp.getAdmin().getAdminId());
		return hdm;
	}
	@Override
	public String updateStatusOfMgrQueryUsingModel(HelpDeskModel help) {
	      helpRepo.updateStatusOfEmpQueryUsingId(help.getStatus(), help.getMsgId());
	      return "Send response to "+ help.getEmpName();
	}
	@Override
	public PaySlipModel fetchPaySlipModelByEmpId(Integer id) {
		Employee employee = empRepo.findById(id).get();
		PaySlipModel slip=new PaySlipModel();
		slip.setName(employee.getName());
		slip.setId(employee.getEmpId());
		return slip;
	}
	@SuppressWarnings("resource")
	@Override
	public String savePaySlipInSystemAndPathInDb(PaySlipModel payslip)throws Exception {
	  
		File file=new File("D:/Emp_proj_pay_slips/emps");
		if(!file.exists())
		{
			file.mkdirs();
			System.out.println("directory is created");
		}
		MultipartFile filePartSlip=payslip.getFile();
		String fileName = filePartSlip.getOriginalFilename();
		
			InputStream insPaySlip = filePartSlip.getInputStream();
			System.out.println(file.getAbsolutePath()+"\\"+fileName);
		    OutputStream osPaySlip= new FileOutputStream(file.getAbsolutePath()+"/"+fileName);
		    IOUtils.copy(insPaySlip,osPaySlip);
		    insPaySlip.close();
		    osPaySlip.close();
		
		Employee employee = empRepo.findById(payslip.getId()).get();
		PaySlip payEntity = new PaySlip();
		
		payEntity.setEmp(employee);
		String dbPath=(file.getAbsolutePath()+"/"+fileName).replace("/","\\");
		payEntity.setFilePath(dbPath);
		payEntity.setLd(payslip.getLd());
		Integer id= slipRepo.save(payEntity).getSlipId();
		return payslip.getName()+" employee pay Slip uploaded";
	}
	@Override
	public PaySlipModel fetchPaySlipModelByMgrId(Integer id) {
		Manager manager = mgrRepo.findById(id).get();
		PaySlipModel psm = new PaySlipModel();
		psm.setName(manager.getName());
		psm.setId(manager.getMgrId());
		return psm;
	}
	@SuppressWarnings("resource")
	@Override
	public String saveMgrPaySlip(PaySlipModel paySlip) throws IOException {
		File file = new File("D:/Emp_proj_pay_slips/mgrs");
		if(!file.exists())
		{
			file.mkdirs();
		}
		MultipartFile paySlipFile = paySlip.getFile();
		InputStream iosPaySlip = paySlipFile.getInputStream();
		String fileName = paySlipFile.getOriginalFilename();
	     OutputStream fsOsStream = new FileOutputStream(file+"/"+fileName);
	     IOUtils.copy(iosPaySlip, fsOsStream);
	     iosPaySlip.close();fsOsStream.close();
	     PaySlip slipEntity = new PaySlip();
	     Manager manager = mgrRepo.findById(paySlip.getId()).get();
		 slipEntity.setMgr(manager);
		 slipEntity.setLd(paySlip.getLd());
		  String dbPath=(file.getAbsolutePath()+"/"+fileName).replace("/","\\");
		 slipEntity.setFilePath(dbPath);
		 Integer slipId = slipRepo.save(slipEntity).getSlipId();
		 
		return paySlip.getName()+" Manager pay Slip uploaded";
	}
	
}
