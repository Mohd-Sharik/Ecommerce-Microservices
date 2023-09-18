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

@Table(name = "TB_OS_ADRS")
@Entity
public class TbOsAdrss implements Serializable {

	/**
	 * @author Mohd Sharik
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_OS_ADRS_GEN")
	@SequenceGenerator(name = "SEQ_OS_ADRS_GEN", sequenceName = "SEQ_OS_ADRS", allocationSize = 1)
	private Long id;
	
	@Column(name = "HOUSE_NO")
	private String houseNo;
	
	@Column(name = "STREET_NO")
	private String streeNo;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COLO_ID")
	private TbOsColony tbOsColony;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DELEG_ID")
	private TbOsDeleg tbOsDeleg;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CITY_ID")
	private TbOsCity tbOsCity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "STATE_ID")
	private TbOsState tbOsState;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COUNTRY_ID")
	private TbOsCountry tbOsCountry;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "POSTAL_ID")
	private TbOsPostal tbOsPostal;
	
	@Column(name = "ADDR_TYPE")
	private String addrType;
	
	@Column(name = "CRT_TS")
	private Date crtTs;
	
	@Column(name = "CRT_BY")
	private String crtBy;
	
	@Column(name = "UPD_TS")
	private Date updTs;
	
	@Column(name = "UPD_BY")
	private String updBy;

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

	public TbOsColony getTbOsColony() {
		return tbOsColony;
	}

	public void setTbOsColony(TbOsColony tbOsColony) {
		this.tbOsColony = tbOsColony;
	}

	public TbOsDeleg getTbOsDeleg() {
		return tbOsDeleg;
	}

	public void setTbOsDeleg(TbOsDeleg tbOsDeleg) {
		this.tbOsDeleg = tbOsDeleg;
	}

	public TbOsCity getTbOsCity() {
		return tbOsCity;
	}

	public void setTbOsCity(TbOsCity tbOsCity) {
		this.tbOsCity = tbOsCity;
	}

	public TbOsState getTbOsState() {
		return tbOsState;
	}

	public void setTbOsState(TbOsState tbOsState) {
		this.tbOsState = tbOsState;
	}

	public TbOsCountry getTbOsCountry() {
		return tbOsCountry;
	}

	public void setTbOsCountry(TbOsCountry tbOsCountry) {
		this.tbOsCountry = tbOsCountry;
	}

	public TbOsPostal getTbOsPostal() {
		return tbOsPostal;
	}

	public void setTbOsPostal(TbOsPostal tbOsPostal) {
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
	
	
	
	
	
	
	

}
