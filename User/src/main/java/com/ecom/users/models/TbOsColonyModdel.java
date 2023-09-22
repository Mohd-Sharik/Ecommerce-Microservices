package com.ecom.users.models;

import java.util.Date;


import com.ecom.users.entites.TbOsDelegEntity;

public class TbOsColonyModdel {
	
	
	
    private Long id;
	//private TbOsDelegEntity tbOsDeleg;
	private String cd;
	private String nm;
	private String deleName;
	private String cityName;
	private String stateName;
	private String countryName;
	private String updBy;
	private Date updTs;
	private String updTsString;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getDeleName() {
		return deleName;
	}
	public void setDeleName(String deleName) {
		this.deleName = deleName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	
	
	


}
