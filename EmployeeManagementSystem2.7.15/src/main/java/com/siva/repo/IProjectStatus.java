package com.siva.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.siva.entity.ProjectStatus;

public interface IProjectStatus extends JpaRepository<ProjectStatus,Integer>{
  
  @Query(value="select * from emp_proj_project_status2 where emp_id=:empId and mgr_id=:mgrId order by ld asc ",nativeQuery=true)
  public List<ProjectStatus> fetchProjectByManagerIdAndEmpId(@Param("empId")Integer eid,@Param("mgrId") Integer mid);
}
