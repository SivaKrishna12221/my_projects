package com.siva.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.siva.entity.EmployeeManagerHelpDesk;
import com.siva.model.HelpDeskModel;

public interface IHelpDeskRepo extends JpaRepository<EmployeeManagerHelpDesk,Integer> {
		
	@Query("select new com.siva.model.HelpDeskModel(e.name,e.email,h.message,h.status) from EmployeeManagerHelpDesk h inner join Employee e on h.emp.empId=e.empId where h.emp.empId=:empId")
	public List<HelpDeskModel> fetchAllEmpsQueries(@Param("empId") Integer empid);
	
	@Query("select new com.siva.model.HelpDeskModel(m.name,m.email,h.message,h.status) from EmployeeManagerHelpDesk h inner join Manager m on h.mgr.mgrId=m.mgrId where h.mgr.mgrId=:empId")
	public List<HelpDeskModel> fetchAllmgrsQueries(@Param("empId") Integer empid);
	
	@Query("select new com.siva.model.HelpDeskModel(e.empId,e.name,e.email,e.mobileNo,h.message,h.status,h.helpId) from EmployeeManagerHelpDesk h inner join Employee e on h.emp.empId=e.empId inner join Admin a on h.admin.adminId=a.adminId where h.admin.adminId=:id ")
	public List<HelpDeskModel> fetchAllEmpsQueriesByAdminId(@Param("id") Integer id);
	
	@Query("update EmployeeManagerHelpDesk set status=:status where helpId=:msgId ")
	@Transactional
	@Modifying
	public void updateStatusOfEmpQueryUsingId(@Param("status")String status,@Param("msgId")Integer msgId);

		
	@Query("select new com.siva.model.HelpDeskModel(m.mgrId,m.name,m.email,m.mobileNo,h.message,h.status,h.helpId) from EmployeeManagerHelpDesk h inner join Manager m on h.mgr.mgrId=m.mgrId inner join Admin a on h.admin.adminId=a.adminId where h.admin.adminId=:id ")
	public List<HelpDeskModel> fetchAllmgrsQueriesByAdminId(@Param("id") Integer id);
	
	@Query("update EmployeeManagerHelpDesk set status=:status where helpId=:msgId ")
	@Transactional
	@Modifying
	public void updateStatusOfMgrQueryUsingId(@Param("status")String status,@Param("msgId")Integer msgId);


}

