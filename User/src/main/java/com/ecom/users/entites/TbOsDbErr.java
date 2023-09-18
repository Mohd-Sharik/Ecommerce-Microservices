package com.ecom.users.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "TB_OS_DB_ERR")
public class TbOsDbErr  implements Serializable {

	/**
	 *@author Mohd Sharik 
	 */
	private static final long serialVersionUID = 5297284302866432950L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_OS_DB_ERR_GEN")
	@SequenceGenerator(name = "SEQ_OS_DB_ERR_GEN", sequenceName = "SEQ_OS_DB_ERR", allocationSize = 1)
	private Long id;
	
	@Column(name = "REF_CD")
	private String refCode;
	
	@Column(name = "ERR_CD")
	private String errCode;
	
	@Column(name = "ERR_MSG")
	private String errMsg;
	
	@Column(name = "REF_NM")
	private String refNm;
	
	@Column(name = "CRT_BY")
	private String crtBy;
	
	
	@Column(name = "CRT_TS")
	private Date crtTs;


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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	
	
	
	

}
