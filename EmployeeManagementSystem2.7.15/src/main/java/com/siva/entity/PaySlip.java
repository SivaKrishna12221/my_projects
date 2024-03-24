package com.siva.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="emp_proj_pay_slip2")
@Data
public class PaySlip {

	@Id
	@SequenceGenerator(name="pay_gen2",sequenceName ="slip_seq2",initialValue=2500,allocationSize=1)
	@GeneratedValue(generator="pay_gen2",strategy=GenerationType.SEQUENCE)
	private Integer slipId;
	private LocalDate ld;

	private String filePath;
	
	@ManyToOne(targetEntity=Employee.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="emp_id",referencedColumnName="empId")
	private Employee emp;
	@ManyToOne(targetEntity=Manager.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="mgr_id",referencedColumnName="mgrId")
	private Manager mgr;
	
}
