package com.nt.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="ms_ipl_player")
@NoArgsConstructor
@AllArgsConstructor
public class IPLPlayer {

	@Id
	@SequenceGenerator(name="gen1",sequenceName="player_id_seq",initialValue=100,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer pid;
	@Column(length=20)
	private String pname;
	private Integer jersyno;
	@Column(length=20)
	private String role;
	@ManyToOne(targetEntity =IPLTeam.class,fetch=FetchType.EAGER,cascade=CascadeType.MERGE)
	@JoinColumn(name="team_id",referencedColumnName = "teamId")
	private IPLTeam team;
}
