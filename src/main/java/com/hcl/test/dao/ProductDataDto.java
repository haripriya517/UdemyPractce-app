package com.hcl.test.dao;

import java.util.Date;

public class ProductDataDto {
	private Long id;
	private Long  productCode;
	private Long activityCode;
	private Date startDate;
	private Date endDate;
	private String subject;
	private Double amountTobePaid;
	
	public ProductDataDto() {
	}
	public ProductDataDto(Long id, Long productCode, Long activityCode, Date startDate, Date endDate, String subject,
			Double amountTobePaid) {
		super();
		this.id = id;
		this.productCode = productCode;
		this.activityCode = activityCode;
		this.startDate = startDate;
		this.endDate = endDate;
		this.subject = subject;
		this.amountTobePaid = amountTobePaid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Double getAmountTobePaid() {
		return amountTobePaid;
	}
	public void setAmountTobePaid(Double amountTobePaid) {
		this.amountTobePaid = amountTobePaid;
	}
	
	
	

}
