package com.siva.entity;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="emp_proj_project2")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Project {

	@Id
	@SequenceGenerator(name="proj_gen2",sequenceName = "proj_seq2",initialValue=3000,allocationSize=1)
	@GeneratedValue(generator="proj_gen2",strategy=GenerationType.SEQUENCE)
	private Integer projId;
	@NonNull
	@Column(length=30)
	private String projName;
	@Column(name="proj_status")
	private String status;
	@ManyToOne(targetEntity=Employee.class,fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="emp_id",referencedColumnName="empId")//this emp_id column is created current table it is the reference key of employee table
	private Employee employees;
	@ManyToOne(targetEntity=Manager.class,fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="mgr_id",referencedColumnName="mgrId")
	private Manager manager;
	
}
