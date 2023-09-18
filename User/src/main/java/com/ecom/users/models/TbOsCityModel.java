package com.ecom.users.models;

import java.util.Date;


import com.ecom.users.entites.TbOsStateEntity;

public class TbOsCityModel {
	
	
	
	
	
    private Long id;
	private TbOsStateEntity tbOsState;
	private String cd;
	private String nm;
	private String updBy;
	private Date updTs;
	private String updTsString;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TbOsStateEntity getTbOsState() {
		return tbOsState;
	}
	public void setTbOsState(TbOsStateEntity tbOsState) {
		this.tbOsState = tbOsState;
	}
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public String getUpdBy() {
		return updBy;
	}
	public void setUpdBy(String updBy) {
		this.updBy = updBy;
	}
	public Date getUpdTs() {
		return updTs;
	}
	public void setUpdTs(Date updTs) {
		this.updTs = updTs;
	}
	public String getUpdTsString() {
		return updTsString;
	}
	public void setUpdTsString(String updTsString) {
		this.updTsString = updTsString;
	}
	
	
	
	
	
	

}
