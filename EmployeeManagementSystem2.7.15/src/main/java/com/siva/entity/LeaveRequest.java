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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "emp_proj_leave_request2")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class LeaveRequest {

	@Id
	@SequenceGenerator(name = "leave_gen2", sequenceName = "leave_seq2", initialValue = 1500, allocationSize = 1)
	@GeneratedValue(generator = "leave_gen2", strategy = GenerationType.SEQUENCE)
	private Integer leaveId;
	@NonNull
	@Column(length = 30)
	private String empName;
	@NonNull
	private LocalDate fromDate;

	@NonNull
	private LocalDate toDate;

	@NonNull
	private String reason;
	@NonNull
	private String response;
	@NonNull
	@Column(length = 20)
	private String status ="pending";
	@ManyToOne(targetEntity = Employee.class, fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "emp_id", referencedColumnName = "empId")
	private Employee emp;
	@ManyToOne(targetEntity=Manager.class, fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="mgr_id",referencedColumnName="mgrId")
	private Manager mgr;
	
}
