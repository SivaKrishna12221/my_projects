package com.siva.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="emp_proj_help_desk2")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class EmployeeManagerHelpDesk {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NonNull
	private Integer helpId;
	@NonNull
	private String message;

	@NonNull
	private String status="pending";
	
	@ManyToOne(targetEntity=Admin.class,fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="admin_id",referencedColumnName = "adminId")
	private Admin admin;
	@ManyToOne(targetEntity=Employee.class,fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="emp_id",referencedColumnName = "empId")
	
	private Employee emp;
	@ManyToOne(targetEntity=Manager.class,fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="mgr_id",referencedColumnName = "mgrId")
	
	private Manager mgr;
	
	
}
