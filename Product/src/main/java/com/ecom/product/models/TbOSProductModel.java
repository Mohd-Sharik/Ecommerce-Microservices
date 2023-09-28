package com.ecom.product.models;

import java.util.Date;
import java.util.List;

public class TbOSProductModel {
	
	
	
	private Long id;
	private String productName;
	private String descr;
	private Double price;
	private String catagoryName;
	private String catagoryDescr;
	private Long quantity;
	private Long discountId;
	private String material;
	private String brand;
	private String color;
	private String style;
	private List<TbRpMRatingModel> ratings;
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
	public Long getDiscountId() {
		return discountId;
	}
	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public List<TbRpMRatingModel> getRatings() {
		return ratings;
	}
	public void setRatings(List<TbRpMRatingModel> ratings) {
		this.ratings = ratings;
	}
	
	
	

	
	

}
