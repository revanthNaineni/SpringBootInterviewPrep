package com.springbootinterview.springbootinterview.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
@Entity
public class Plan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long planId;
	private String planName;
	private String planDescription;
	private String validity;
	private Double price;
	
	public Plan() {
		
	}
	public Plan(Long planId, String planName, String planDescription, String validity, Double price) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.planDescription = planDescription;
		this.validity = validity;
		this.price = price;
	}
	public Long getPlanId() {
		return planId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanDescription() {
		return planDescription;
	}
	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
}
