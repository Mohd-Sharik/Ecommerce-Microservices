package com.ecom.product.entities;

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
@Table(name = "TB_OS_CATAGORY")
public class TbOsCatagoryEntity implements Serializable {
	
	
	
	
	/**
	 * @author Mohd Sharik
	 */
	private static final long serialVersionUID = 1L;

	

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_OS_CATAGORY_GEN")
	@SequenceGenerator(name = "SEQ_OS_CATAGORY_GEN" ,sequenceName = "SEQ_OS_CATAGORy" , allocationSize = 1)
	private Long id;
	
	@Column(name = "NAME")
	private String brandName;
	
	@Column(name = "DESCR")
	private String descr;
	
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	

}
