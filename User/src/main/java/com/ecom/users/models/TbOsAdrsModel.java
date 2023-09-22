package com.ecom.users.models;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.ecom.users.entites.TbOsCityEntity;
import com.ecom.users.entites.TbOsColonyEntity;
import com.ecom.users.entites.TbOsCountryEntity;
import com.ecom.users.entites.TbOsDelegEntity;
import com.ecom.users.entites.TbOsPostalEntity;
import com.ecom.users.entites.TbOsStateEntity;

public class TbOsAdrsModel {
	
	
	
	
    private Long id;
	private String houseNo;
	private String streeNo;
	private String colonyName;
	private String postalName;
	private String postalCode;
	private String deleName;
	private String cityName;
	private String stateName;
	private String countryName;
	private String addrType;
	private Date crtTs;
	private String crtBy;
	private String crtTsString;
	private Date updTs;
	private String updBy;
	private String updTsString;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreeNo() {
		return streeNo;
	}
	public void setStreeNo(String streeNo) {
		this.streeNo = streeNo;
	}
	
	public String getAddrType() {
		return addrType;
	}
	public void setAddrType(String addrType) {
		this.addrType = addrType;
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
	public String getCrtTsString() {
		return crtTsString;
	}
	public void setCrtTsString(String crtTsString) {
		this.crtTsString = crtTsString;
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
	public String getUpdTsString() {
		return updTsString;
	}
	public void setUpdTsString(String updTsString) {
		this.updTsString = updTsString;
	}
	
	
	public String getColonyName() {
		return colonyName;
	}
	public void setColonyName(String colonyName) {
		this.colonyName = colonyName;
	}
	public String getPostalName() {
		return postalName;
	}
	public void setPostalName(String postalName) {
		this.postalName = postalName;
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
	
	
	
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String validate()
	{
		StringBuilder sb = new StringBuilder();
		
		boolean flag = StringUtils.isNotBlank(addrType);
		if(flag)
		{
			sb.append("AddrsType is Blan : "+flag);
		}
		return sb.toString();
	}
	
	
	

	

}
