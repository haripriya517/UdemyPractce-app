package com.hcl.test.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ActivityData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "party_id")
	private Long partyId;
	private Date date;
	private Long productCode;
	private Long activityCode;
	private String status;
	
	public ActivityData() {
	}
	
	public ActivityData(Long partyId, Date date, Long productCode, Long activityCode, String status) {
		super();
		this.partyId = partyId;
		this.date = date;
		this.productCode = productCode;
		this.activityCode = activityCode;
		this.status = status;
	}
	public Long getPartyId() {
		return partyId;
	}
	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getProductCode() {
		return productCode;
	}
	public void setProductCode(Long productCode) {
		this.productCode = productCode;
	}
	public Long getActivityCode() {
		return activityCode;
	}
	public void setActivityCode(Long activityCode) {
		this.activityCode = activityCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
