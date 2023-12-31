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
@Table(name = "TB_OS_STATE")
public class TbOsStateEntity  implements Serializable{
	
	
	/**
	 * @author Mohd Sharik
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "SEQ_OS_STATE_GEN")
	@SequenceGenerator(name = "SEQ_OS_STATE_GEN" , sequenceName = "SEQ_OS_STATE", allocationSize = 1)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COUNTRY_ID")
	private TbOsCountryEntity tbOsCountry;
	
	@Column(name = "CD")
	private String cd;
	
	@Column(name = "NM")
	private String nm;
	
	@Column(name = "UPD_BY")
	private String updBy;
	
	@Column(name = "UPD_TS")
	private Date updTs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TbOsCountryEntity getTbOsCountry() {
		return tbOsCountry;
	}

	public void setTbOsCountry(TbOsCountryEntity tbOsCountry) {
		this.tbOsCountry = tbOsCountry;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public String getUpdBy() {
		return updBy;
	}

	public void setUpdBy(String updBy) {
		this.updBy = updBy;
	}

	public Date getUpdTs() {
		return updTs;
	}

	public void setUpdTs(Date updTs) {
		this.updTs = updTs;
	}
	
	
	
	

}
