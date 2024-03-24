package com.siva.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="emp_proj_admin2")
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Admin {

	@Id
	@SequenceGenerator(name="admin_gen02",sequenceName ="admin_seq02",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator="admin_gen02",strategy=GenerationType.SEQUENCE)
	private Integer adminId;
	@NonNull
	@Column(length=25)
	private String name;
	@Column(length=30)
	private String username;
	@Column(length=40)
	private String password;
	
	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,targetEntity=Employee.class)// This Property is required only if you want to save the data through admin other wise not required
	@JoinColumn(name="admin_id",referencedColumnName = "adminId")//here admin_id column will be create in child table That referes to parent primary key
	private List<Employee> emp;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity=Manager.class)
	@JoinColumn(name="admin_id",referencedColumnName = "adminId")
	private List<Manager> mgr;*/
	
	
}
