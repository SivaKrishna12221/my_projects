package com.siva.repo;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.siva.entity.Manager;
import com.siva.model.ViewProjectDetails;

public interface IManagerRepo extends JpaRepository<Manager, Integer>{

	@Query("select name from Manager")
	public Set<String> fetchManagerNameList();
	
	public Manager findByName(String name);
	
	public Optional<Manager> findByEmailAndPassword(String email,String password);
	
//	@Query(value="select new com.model.ViewProjectDetails(e.emp_id,e.name,m.name,m.email,m.mobile_no,p.proj_name) from emp_proj_project p, emp_proj_employee e ,emp_proj_manager m where e.emp_id=p.emp_id and p.mgr_id=m.mgr_id and m.mgr_id=?",nativeQuery = true)
	@Query("select new com.siva.model.ViewProjectDetails(e.empId,e.name,m.mgrId,m.name,m.mobileNo,m.email,p.projName ) from Project p inner join Employee e on e.empId=p.employees.empId inner join Manager m on p.manager.mgrId=m.mgrId where p.manager.mgrId=:id")
	  public List<ViewProjectDetails> fetchProjectDetatilsByMgrId(@Param("id")Integer id);
		
}
