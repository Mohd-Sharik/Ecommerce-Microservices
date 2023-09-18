package com.ecom.users.models;

import java.util.Date;


public class TbOsErrModel {
	
	
	private Long id;
	private String refCode;
	private String errCode;
	private String errMsg;
	private String refNm;
	private String crtBy;
	private Date crtTs;
	
	private String crtTsString;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRefCode() {
		return refCode;
	}

	public void setRefCode(String refCode) {
		this.refCode = refCode;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getRefNm() {
		return refNm;
	}

	public void setRefNm(String refNm) {
		this.refNm = refNm;
	}

	public String getCrtBy() {
		return crtBy;
	}

	public void setCrtBy(String crtBy) {
		this.crtBy = crtBy;
	}

	public Date getCrtTs() {
		return crtTs;
	}

	public void setCrtTs(Date crtTs) {
		this.crtTs = crtTs;
	}

	public String getCrtTsString() {
		return crtTsString;
	}

	public void setCrtTsString(String crtTsString) {
		this.crtTsString = crtTsString;
	}
	
	
	


}
