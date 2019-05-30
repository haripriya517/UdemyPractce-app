package com.hcl.test.dao;

import java.util.Date;

public class ActivityDataDto {
	private Long partyId;;
	private Date date;
	private Long productCode;
	private Long activityCode;
	private String status;
	
	public ActivityDataDto() {
	}
	
	public ActivityDataDto(Long partyId, Date date, Long productCode, Long activityCode, String status) {
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
	

}
