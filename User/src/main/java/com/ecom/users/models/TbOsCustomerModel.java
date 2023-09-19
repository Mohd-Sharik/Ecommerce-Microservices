package com.ecom.users.models;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.ecom.users.entites.TbOsAdrssEntity;

public class TbOsCustomerModel {
	
	
	
	private Long id;
	private String refId;
	private String pswd;
	private String fullName;
	private String dislayName;
	private String email;
	private String comtactInfo;
	private String contactNumber;
	private String dsgn;
	private String location;
	private Long fldLgnCnt;
	private Date lastLgnTs;
	private Date exprTs;
	private String pswdCrtBy;
	private TbOsAdrssEntity tbOsAdrss;
	private String serState;
	private String sessionId;
	private String ldaAuth;
	private String skipInactie;
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
	public String getComtactInfo() {
		return comtactInfo;
	}
	public void setComtactInfo(String comtactInfo) {
		this.comtactInfo = comtactInfo;
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
	public TbOsAdrssEntity getTbOsAdrss() {
		return tbOsAdrss;
	}
	public void setTbOsAdrss(TbOsAdrssEntity tbOsAdrss) {
		this.tbOsAdrss = tbOsAdrss;
	}
	public String getSerState() {
		return serState;
	}
	public void setSerState(String serState) {
		this.serState = serState;
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
