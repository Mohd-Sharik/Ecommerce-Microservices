package com.ecom.users.models;

import java.util.Date;


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
	private TbOsColonyEntity tbOsColony;
	private TbOsDelegEntity tbOsDeleg;
	private TbOsCityEntity tbOsCity;
	private TbOsStateEntity tbOsState;
	private TbOsCountryEntity tbOsCountry;
	private TbOsPostalEntity tbOsPostal;
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
	public TbOsColonyEntity getTbOsColony() {
		return tbOsColony;
	}
	public void setTbOsColony(TbOsColonyEntity tbOsColony) {
		this.tbOsColony = tbOsColony;
	}
	public TbOsDelegEntity getTbOsDeleg() {
		return tbOsDeleg;
	}
	public void setTbOsDeleg(TbOsDelegEntity tbOsDeleg) {
		this.tbOsDeleg = tbOsDeleg;
	}
	public TbOsCityEntity getTbOsCity() {
		return tbOsCity;
	}
	public void setTbOsCity(TbOsCityEntity tbOsCity) {
		this.tbOsCity = tbOsCity;
	}
	public TbOsStateEntity getTbOsState() {
		return tbOsState;
	}
	public void setTbOsState(TbOsStateEntity tbOsState) {
		this.tbOsState = tbOsState;
	}
	public TbOsCountryEntity getTbOsCountry() {
		return tbOsCountry;
	}
	public void setTbOsCountry(TbOsCountryEntity tbOsCountry) {
		this.tbOsCountry = tbOsCountry;
	}
	public TbOsPostalEntity getTbOsPostal() {
		return tbOsPostal;
	}
	public void setTbOsPostal(TbOsPostalEntity tbOsPostal) {
		this.tbOsPostal = tbOsPostal;
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
	
	
	
	
	
	

	

}
