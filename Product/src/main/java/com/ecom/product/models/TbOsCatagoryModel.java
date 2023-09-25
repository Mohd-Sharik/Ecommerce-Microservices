package com.ecom.product.models;

import java.util.Date;

public class TbOsCatagoryModel {
	
	
	
	private Long id;
	private String brandName;
	private String descr;
	private Date crtTs;
	private String crtBy;
	private Date updTs;
	private String updBy;
	private Date dltTs;
	private String dltBy;
	
	private String crtTsString;
	private String updTsString;
	private String dltTsString;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
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
	public Date getDltTs() {
		return dltTs;
	}
	public void setDltTs(Date dltTs) {
		this.dltTs = dltTs;
	}
	public String getDltBy() {
		return dltBy;
	}
	public void setDltBy(String dltBy) {
		this.dltBy = dltBy;
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
