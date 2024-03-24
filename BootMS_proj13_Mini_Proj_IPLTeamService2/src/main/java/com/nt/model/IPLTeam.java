package com.nt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="ms_ipl_team_list")
@NoArgsConstructor
@AllArgsConstructor
public class IPLTeam {

	@Id
	@SequenceGenerator(name="gen1",sequenceName="seq_ipl_teamid",initialValue=1000,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer teamId;
	@Column(length=20)
	private String tname;
	@Column(length=20)
	private String towner;
	@Column(length=20)
	private String tcaptain;
	@Column(length=20)
	private String tlocation;
}
