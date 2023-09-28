package com.ecom.users.models;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ecom.users.entites.TbOsAdrssEntity;

public class TbOsCustomerModel {
	
	
	
	private Long id;
	private String refId;
	private String pswd;
	private String fullName;
	private String dislayName;
	private String email;
	private String contactInfo;
	private String contactNumber;
	private String dsgn;
	private String location;
	private Long fldLgnCnt;
	private Date lastLgnTs;
	private Date exprTs;
	private String pswdCrtBy;
	private String userState;
	private String sessionId;
	private String ldaAuth;
	private String skipInactie;
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
	
	private List<TbRpMRatingModel> ratings;
	private Date crtTs;
	private String crtBy;
	private Date updTs;
	private String updBy;
	private Date dltTs;
	private String dltBy;
	
	private String LastLgnTsString;
	private String exprTsString;
	private String crtTsString;
	private String updTsString;
	private String dltTsString;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getDislayName() {
		return dislayName;
	}
	public void setDislayName(String dislayName) {
		this.dislayName = dislayName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getDsgn() {
		return dsgn;
	}
	public void setDsgn(String dsgn) {
		this.dsgn = dsgn;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getFldLgnCnt() {
		return fldLgnCnt;
	}
	public void setFldLgnCnt(Long fldLgnCnt) {
		this.fldLgnCnt = fldLgnCnt;
	}
	public Date getLastLgnTs() {
		return lastLgnTs;
	}
	public void setLastLgnTs(Date lastLgnTs) {
		this.lastLgnTs = lastLgnTs;
	}
	public Date getExprTs() {
		return exprTs;
	}
	public void setExprTs(Date exprTs) {
		this.exprTs = exprTs;
	}
	public String getPswdCrtBy() {
		return pswdCrtBy;
	}
	public void setPswdCrtBy(String pswdCrtBy) {
		this.pswdCrtBy = pswdCrtBy;
	}
	
	
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getLdaAuth() {
		return ldaAuth;
	}
	public void setLdaAuth(String ldaAuth) {
		this.ldaAuth = ldaAuth;
	}
	public String getSkipInactie() {
		return skipInactie;
	}
	public void setSkipInactie(String skipInactie) {
		this.skipInactie = skipInactie;
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
	public String getLastLgnTsString() {
		return LastLgnTsString;
	}
	public void setLastLgnTsString(String lastLgnTsString) {
		LastLgnTsString = lastLgnTsString;
	}
	public String getExprTsString() {
		return exprTsString;
	}
	public void setExprTsString(String exprTsString) {
		this.exprTsString = exprTsString;
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
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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
	public String getAddrType() {
		return addrType;
	}
	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}
	
	
	
	public List<TbRpMRatingModel> getRatings() {
		return ratings;
	}
	public void setRatings(List<TbRpMRatingModel> ratings) {
		this.ratings = ratings;
	}
	public String validate()
	{
		StringBuilder sb = new StringBuilder();
		
		boolean flag = StringUtils.isBlank(refId);
		
		if(flag)
		{
			sb.append("Customer refId is Blan : "+refId);
		}
		
		flag = StringUtils.isBlank(pswd);
		if(flag)
		{
			sb.append("Customer pswd is Blank : "+pswd);
		}
		
		flag = StringUtils.isBlank(fullName);
		if(flag)
		{
			sb.append("Customer fullName is Blank : "+fullName);
		}
		
		flag = StringUtils.isBlank(dislayName);
		if(flag)
		{
			sb.append("Customer dislayName is Blank : "+dislayName);
		}
		
		return sb.toString();
	}


}
