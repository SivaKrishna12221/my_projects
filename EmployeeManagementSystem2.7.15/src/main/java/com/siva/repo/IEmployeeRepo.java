package com.siva.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.siva.entity.Employee;
import com.siva.model.ViewProjectDetails;


public interface IEmployeeRepo extends JpaRepository<Employee,Integer>{

	public Optional<Employee> findByEmailAndPassword(String email,String password);
	@Query(value="select * from emp_proj_employee2 e where e.mgr_id=:id",nativeQuery=true)
	public List<Employee> fetchEmpDetailsByMgrId(@Param("id") Integer id);
	@Query("select new com.siva.model.ViewProjectDetails(e.empId,e.name,m.mgrId,m.name,m.mobileNo,m.email,p.projName) from Employee e inner join Project p on e.empId=p.employees.empId inner join Manager m on p.manager.mgrId=m.mgrId where p.employees.empId=:id")
	//here model class constructor parameters should follow order and child class property names 
	public List<ViewProjectDetails> fetchProjectDetailsById(@Param("id")Integer id);
	
	
}
