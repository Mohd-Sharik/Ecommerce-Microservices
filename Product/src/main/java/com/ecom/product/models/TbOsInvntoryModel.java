package com.ecom.product.models;

import java.util.Date;

public class TbOsInvntoryModel {
	
	
	private Long id;
	private Long quantity;
	private Date crtTs;
	private String crtBy;
	private Date updTs;
	private String updBy;
	private Date deltTs;
	private String deltBy;
	
	private String crtTsString;
	private String updTsString;
	private String dltTsString;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Date getCrtTs() {
		return crtTs;
	}
	public void setCrtTs(Date crtTs) {
		this.crtTs = crtTs;
	}
	public String getCrtBy() {
		return crtBy;
	}
	public void setCrtBy(String crtBy) {
		this.crtBy = crtBy;
	}
	public Date getUpdTs() {
		return updTs;
	}
	public void setUpdTs(Date updTs) {
		this.updTs = updTs;
	}
	public String getUpdBy() {
		return updBy;
	}
	public void setUpdBy(String updBy) {
		this.updBy = updBy;
	}
	public Date getDeltTs() {
		return deltTs;
	}
	public void setDeltTs(Date deltTs) {
		this.deltTs = deltTs;
	}
	public String getDeltBy() {
		return deltBy;
	}
	public void setDeltBy(String deltBy) {
		this.deltBy = deltBy;
	}
	public String getCrtTsString() {
		return crtTsString;
	}
	public void setCrtTsString(String crtTsString) {
		this.crtTsString = crtTsString;
	}
	public String getUpdTsString() {
		return updTsString;
	}
	public void setUpdTsString(String updTsString) {
		this.updTsString = updTsString;
	}
	public String getDltTsString() {
		return dltTsString;
	}
	public void setDltTsString(String dltTsString) {
		this.dltTsString = dltTsString;
	}
	
	
	

}
