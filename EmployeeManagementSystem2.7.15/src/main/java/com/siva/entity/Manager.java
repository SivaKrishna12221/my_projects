package com.siva.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "emp_proj_manager2")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@SQLDelete(sql = "update emp_proj_manager set status='deleted' where mgr_id=?")
@Where(clause = "status <> 'deleted'")
public class Manager {
	@Id
	@SequenceGenerator(name = "mgr_gen2", sequenceName = "mgr_seq2", initialValue = 2000, allocationSize = 1)
	@GeneratedValue(generator = "mgr_gen2", strategy = GenerationType.SEQUENCE)
	private Integer mgrId;
	@Column(length = 30)
	@NonNull
	private String name;

	private LocalDate dob;
	private Long mobileNo;

	@Column(length = 40, unique = true, nullable = false)
	@NonNull
	private String email;
	@NonNull
	@Column(length = 40, unique = true, nullable = false)
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
	private String role;
	@Column(length = 20)
	private String status = "active";
	@Column(length = 20)
	private String mangerAssign = "Not assign";
	@ManyToOne(targetEntity = Admin.class, fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "admin_id", referencedColumnName = "adminId")
	private Admin admin;
	/*@OneToMany(targetEntity = Employee.class, fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "mgr_id", referencedColumnName = "mgrId")
	private List<Employee> emp;
	*/
	
	/*@OneToMany(targetEntity=Project.class,fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="mgr_id",referencedColumnName = "mgrId")
	private List<Project> proj;
	@OneToMany(targetEntity=ProjectStatus.class,fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="mgr_id",referencedColumnName="mgrId")
	private List<ProjectStatus> projStatus;
	
	@OneToMany(targetEntity=LeaveRequest.class,fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="mgr_id",referencedColumnName="mgrId")
	private List<LeaveRequest> leaveRequest;*/
}
