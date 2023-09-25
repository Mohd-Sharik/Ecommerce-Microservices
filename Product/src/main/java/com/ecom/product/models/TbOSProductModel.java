package com.ecom.product.models;

import java.util.Date;

public class TbOSProductModel {
	
	
	
	private Long id;
	private String productName;
	private String descr;
	private Double price;
	private String catagoryName;
	private String catagoryDescr;
	private Long quantity;
	private Date crtTs;
	private String crtBy;
	private Date updTs;
	private String updBy;
	private Date deltTs;
	private String deltBy;
	
	private String crtTsString;
	private String updTsString;
	private String dltTsString;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCatagoryName() {
		return catagoryName;
	}
	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}
	public String getCatagoryDescr() {
		return catagoryDescr;
	}
	public void setCatagoryDescr(String catagoryDescr) {
		this.catagoryDescr = catagoryDescr;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
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
	public Date getDeltTs() {
		return deltTs;
	}
	public void setDeltTs(Date deltTs) {
		this.deltTs = deltTs;
	}
	public String getDeltBy() {
		return deltBy;
	}
	public void setDeltBy(String deltBy) {
		this.deltBy = deltBy;
	}
	public String getCrtTsString() {
		return crtTsString;
	}
	public void setCrtTsString(String crtTsString) {
		this.crtTsString = crtTsString;
	}
	public String getUpdTsString() {
		return updTsString;
	}
	public void setUpdTsString(String updTsString) {
		this.updTsString = updTsString;
	}
	public String getDltTsString() {
		return dltTsString;
	}
	public void setDltTsString(String dltTsString) {
		this.dltTsString = dltTsString;
	}
	


}
