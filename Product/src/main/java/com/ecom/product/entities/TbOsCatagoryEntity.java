package com.ecom.product.entities;

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
public class TbOsCatagoryEntity {
	
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
	
	
	
	

}
