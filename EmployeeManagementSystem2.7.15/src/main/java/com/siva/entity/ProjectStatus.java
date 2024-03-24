package com.siva.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="emp_proj_project_status2")
@Data
public class ProjectStatus {

	@Id
	@SequenceGenerator(name="proj_status_gen2",sequenceName="p_status_column2",initialValue=3500,allocationSize=1)
	@GeneratedValue(generator="proj_status_gen2",strategy=GenerationType.SEQUENCE)
	private Integer pstatusId;
   
	private String message;
	private String respone;
	private LocalDateTime ld=LocalDateTime.now();
	@ManyToOne(targetEntity=Employee.class)
	@JoinColumn(name="emp_id",referencedColumnName="empId")
	private Employee emp;
	@ManyToOne(targetEntity=Manager.class)
	@JoinColumn(name="mgr_id",referencedColumnName ="mgrId")
	private Manager mgr;
	
}
