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
public class TbOsAdrssEntity implements Serializable {

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
	private TbOsColonyEntity tbOsColony;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DELEG_ID")
	private TbOsDelegEntity tbOsDeleg;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CITY_ID")
	private TbOsCityEntity tbOsCity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "STATE_ID")
	private TbOsStateEntity tbOsState;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COUNTRY_ID")
	private TbOsCountryEntity tbOsCountry;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "POSTAL_ID")
	private TbOsPostalEntity tbOsPostal;
	
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
