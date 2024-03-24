package com.siva.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.siva.entity.PaySlip;
import com.siva.model.PaySlipInfo;

public interface IPaySlipRepository extends JpaRepository<PaySlip,Integer>{

	@Query("select new com.siva.model.PaySlipInfo(e.empId,e.name,e.email,e.mobileNo,p.filePath) from Employee e inner join PaySlip p on p.emp.empId=e.empId where p.emp.empId=:id")
	public List<PaySlipInfo> fetchEmpPaySlipDetailsByEmpId(@Param("id")Integer id);
	@Query("select new com.siva.model.PaySlipInfo(m.mgrId,m.name,m.email,m.mobileNo,p.filePath) from Manager m inner join PaySlip p on p.mgr.mgrId=m.mgrId where p.mgr.mgrId=:id")
	public List<PaySlipInfo> fetchMgrPaySlipDetailsByMgrId(@Param("id") Integer id);
}
