package com.nt.entity;

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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="MyTourist")
@NoArgsConstructor
@AllArgsConstructor
@Data
@RequiredArgsConstructor
public class Tourist {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "Tid_Seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer tid;
	@NonNull
	@Column(length = 20)
	private String tname;
	@NonNull
	@Column(length = 20)
	private String taddrs;
	@NonNull
	@Column(length = 20)
	private String plan;
	@NonNull
	private Double budget;
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTaddrs() {
		return taddrs;
	}
	public void setTaddrs(String taddrs) {
		this.taddrs = taddrs;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	
	
}
