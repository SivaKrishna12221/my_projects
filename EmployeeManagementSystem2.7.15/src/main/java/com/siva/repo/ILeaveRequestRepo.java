package com.siva.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.siva.entity.LeaveRequest;
import com.siva.model.LeaveRequestModel;

public interface ILeaveRequestRepo extends JpaRepository<LeaveRequest, Integer>{

	@Query(value="select * from emp_proj_leave_request2 where emp_id=:id",nativeQuery=true)
	public List<LeaveRequest> fetchAllLeaveRequestByEmpId(@Param("id")Integer id);
	//@Query(value="select new com.siva.model.LeaveRequestModel(e.email,e.emp_id,e.name,l.from_date,l.mgr_id,l.reason,l.response,l.status,l.to_date)from emp_proj_leave_request l inner join emp_proj_employee e on e.emp_id=l.emp_id inner join emp_proj_manager m  on l.mgr_id=m.mgr_id where l.mgr_id=:id",nativeQuery=true)
	@Query("select new com.siva.model.LeaveRequestModel(e.empId,e.name,e.email,m.mgrId,m.name,l.fromDate,l.toDate,l.reason,l.response,l.status )from LeaveRequest l inner join Employee e on e.empId=l.emp.empId inner join Manager m on l.mgr.mgrId=m.mgrId where l.mgr.mgrId=:id")
	public List<LeaveRequestModel> fetchAllEmpRequestByMgrId(@Param("id") Integer id);

	@Query(value="update emp_proj_leave_request set status=:response where emp_id =:id",nativeQuery=true)
	@Modifying
	@Transactional//if we don't want keep this annotation here we can place on the top of the service class
	public void updateLeaveStatusByEmpId(Integer id,String response);
	
	
	
}
