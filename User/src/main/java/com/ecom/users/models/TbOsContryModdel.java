package com.ecom.users.models;

import java.util.Date;

import org.apache.commons.lang.StringUtils;


public class TbOsContryModdel {
	
	
	
	
	private Long id;
	private String name;
	private int numCode;
	private String alphaCd2;
	private String alphaCd3;
	private String updBy;
	private Date updTs;
	private String upddTsString;
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
	public String getUpddTsString() {
		return upddTsString;
	}
	public void setUpddTsString(String upddTsString) {
		this.upddTsString = upddTsString;
	}
	
	
	public String validate()
	{
		StringBuilder sb = new StringBuilder();
		
		boolean flag = StringUtils.isBlank(name);
		if(flag)
		{
			sb.append("Country Name is Blank : "+flag);
		}
		
		flag = StringUtils.isBlank(alphaCd2);
		if(flag)
		{
			sb.append("Contry alphaCd2 Is Blank : "+flag);
		}
		
		flag = StringUtils.isBlank(alphaCd3);
		if(flag)
		{
			sb.append("Country alphaCd3 is Blank : "+alphaCd3);
		}
		
		
		return sb.toString();
	}
	


}
