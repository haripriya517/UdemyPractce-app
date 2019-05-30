package com.hcl.test.dao;

public class CustomerDto {
	
	public CustomerDto() {
	}
	public CustomerDto( Long partyId, Long product_code, Long activity_code, String statusc, String provider) {
		super();
	
		this.partyId = partyId;
		this.product_code = product_code;
		this.activity_code = activity_code;
		this.statusc = statusc;
		this.provider = provider;
	}
	
	private Long partyId;
	private Long product_code;
	private Long activity_code;
	private String statusc;
	private String provider;
	public Long getPartyId() {
		return partyId;
	}
	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}
	public Long getProduct_code() {
		return product_code;
	}
	public void setProduct_code(Long product_code) {
		this.product_code = product_code;
	}
	public Long getActivity_code() {
		return activity_code;
	}
	public void setActivity_code(Long activity_code) {
		this.activity_code = activity_code;
	}
	public String getStatusc() {
		return statusc;
	}
	public void setStatus(String statusc) {
		this.statusc = statusc;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	

}
