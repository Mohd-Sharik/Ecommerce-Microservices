package com.ecom.users.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_OS_CUSTMR")
public class TbOsCustomerEntity implements Serializable{

	/**
	 * @author Mhd Sharik
	 */
	private static final long serialVersionUID = -3629180619381567280L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_OS_CUSTMR_GEN")
	@SequenceGenerator(name = "SEQ_OS_CUSTMR_GEN", sequenceName = "SEQ_OS_CUSTMR", allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "REF_ID")
	private String refId;
	
	@Column(name = "PSWD")
	private String pswd;
	
	@Column(name = "FULL_NM")
	private String fullName;
	
	@Column(name = "DSPL_NM")
	private String dislayName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "CNTCT_INFO")
	private String contactInfo;
	
	@Column(name = "CNTCT_NUMBER")
	private String contactNumber;
	
	@Column(name = "DSGN")
	private String dsgn;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "FLD_LGN_CNT")
	private Integer fldLgnCnt;
	
	@Column(name = "LST_LGN_TS")
	private Date lastLgnTs;
	
	@Column(name = "EXPR_TS")
	private Date exprTs;
	
	@Column(name = "PSWD_CRT_BY")
	private String pswdCrtBy;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ADDRESS_ID")
	private TbOsAdrssEntity tbOsAdrss;
	
	@Column(name = "USER_STATE")
	private String userState;
	
	@Column(name = "SESSION_ID")
	private String sessionId;
	
	@Column(name = "LDAP_AUTH")
	private String ldaAuth;
	
	@Column(name = "SKIP_INACTVN")
	private String skipInactie;
	
	@Column(name = "CRT_TS")
	private Date crtTs;
	
	@Column(name = "CRT_BY")
	private String crtBy;
	
	@Column(name = "UPD_TS")
	private Date updTs;
	
	@Column(name = "UPD_BY")
	private String updBy;
	
	@Column(name = "DLT_TS")
	private Date dltTs;
	
	@Column(name = "DLT_BY")
	private String dltBy;

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

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
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

	

	public Integer getFldLgnCnt() {
		return fldLgnCnt;
	}

	public void setFldLgnCnt(Integer fldLgnCnt) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
