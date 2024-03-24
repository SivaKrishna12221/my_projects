package com.siva.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name="emp_proj_employee2")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data

@SQLDelete(sql = "update emp_proj_employee set status='deleted' where emp_id=? ")
@Where(clause= "status <> 'deleted'")
public class Employee {

	@Id
	@SequenceGenerator(name="emp_gen2",sequenceName = "emp_seq2",initialValue=500,allocationSize=1)
	@GeneratedValue(generator="emp_gen2",strategy=GenerationType.SEQUENCE)
	private Integer empId;
	@Column(length=30)
	@NonNull
	private String name;
	
	private LocalDate dob;
	private Long mobileNo;
	
	@Column(length=40,unique =true,nullable = false)
	@NonNull
	private String email;
	@NonNull	
	@Column(length=40,unique = true,nullable= false)
	private String password;
	@Column(length = 40)
	private String confirmPassword;
	@Column(length = 30)
	private String address;
	
	@Column(length = 20)
	private String city;
	@Column(length = 20)
	private String state;
	private Long pincode;
	@Column(length = 20)
	private String role ;
	@Column(length = 20)
	private String status = "active";
	@Column(length = 30)
	private String managerAssign = "Not assign";
	@Column(length=30)
	private String managerAssignAction="assign";
	@ManyToOne(targetEntity=Manager.class,fetch=FetchType.EAGER,cascade =CascadeType.ALL)
	@JoinColumn(name="mgr_id",referencedColumnName="mgrId")
	private Manager manager;
	
	@ManyToOne(targetEntity=Admin.class,fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="admin_id",referencedColumnName ="adminId")
	private Admin admin;
	
	/*@OneToMany(targetEntity=Project.class,fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="emp_id",referencedColumnName ="empId")
	private List<Project> project;
	
	@OneToMany(targetEntity=ProjectStatus.class,fetch=FetchType.EAGER,cascade=CascadeType.ALL)//if we want to save the child data through parent we have to write here other wise not requierd it is two way binding
	@JoinColumn(name="emp_id",referencedColumnName = "empId")//here emp_id is stored in project status table that referes to parent 
	private List<ProjectStatus> projectStatus;
	
	@OneToMany(targetEntity=LeaveRequest.class,fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="emp_id",referencedColumnName="empId")
	private List<LeaveRequest> leaveRequest;*/
}

	



