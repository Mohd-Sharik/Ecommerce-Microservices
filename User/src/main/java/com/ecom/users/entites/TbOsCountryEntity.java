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
@Table(name = "TB_OS_COUNTRY")
public class TbOsCountryEntity implements Serializable{
	
	
	
	
	/**
	 * @author Mohd Sharik
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_OS_COUNTRY_GEN")
	@SequenceGenerator(name = "SEQ_OS_COUNTRY_GEN",sequenceName = "SEQ_OS_COUNTRY", allocationSize = 1)
	private Long id;
	
	@Column(name = "NM")
	private String name;
	
	@Column(name = "NUM_CD")
	private int numCode;
	
	@Column(name = "ALPHA_CD_2")
	private String alphaCd2;
	
	@Column(name = "ALPHA_CD_3")
	private String alphaCd3;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumCode() {
		return numCode;
	}

	public void setNumCode(int numCode) {
		this.numCode = numCode;
	}

	public String getAlphaCd2() {
		return alphaCd2;
	}

	public void setAlphaCd2(String alphaCd2) {
		this.alphaCd2 = alphaCd2;
	}

	public String getAlphaCd3() {
		return alphaCd3;
	}

	public void setAlphaCd3(String alphaCd3) {
		this.alphaCd3 = alphaCd3;
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
