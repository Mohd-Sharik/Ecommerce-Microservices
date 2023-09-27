package com.ecom.product.entities;

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

import com.fasterxml.jackson.core.sym.Name;

@Entity
@Table(name = "TB_OS_PRODUCTS")
public class TbOsProductEntity  implements Serializable{

	/**
	 * @author Mohd Sharik
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_OS_PRODUCTS_GEN")
	@SequenceGenerator(name = "SEQ_OS_PRODUCTS_GEN", sequenceName = "SEQ_OS_PRODUCTS" , allocationSize = 1)
	private Long id;
	
	@Column(name = "NAME")
	private String productName;
	
	@Column(name = "DESCR")
	private String desr;
	
	@Column(name = "PRICE")
	private Double price;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CATAGORY_ID")
	private TbOsCatagoryEntity tbOsCatagoryEntity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "INVENTORY_ID")
	private TbOSInventoryEntity tbOSInventoryEntity;
	
	@Column(name = "DISCOUNT_ID")
	private Long discountId;
	
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
	
	@Column(name = "MATERIAL")
	private String material;
	
	@Column(name = "BRAND")
	private String brand;
	
	@Column(name = "COLOR")
	private String color;
	
	@Column(name = "STYLE")
	private String style;

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

	public String getDesr() {
		return desr;
	}

	public void setDesr(String desr) {
		this.desr = desr;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public TbOsCatagoryEntity getTbOsCatagoryEntity() {
		return tbOsCatagoryEntity;
	}

	public void setTbOsCatagoryEntity(TbOsCatagoryEntity tbOsCatagoryEntity) {
		this.tbOsCatagoryEntity = tbOsCatagoryEntity;
	}

	public TbOSInventoryEntity getTbOSInventoryEntity() {
		return tbOSInventoryEntity;
	}

	public void setTbOSInventoryEntity(TbOSInventoryEntity tbOSInventoryEntity) {
		this.tbOSInventoryEntity = tbOSInventoryEntity;
	}

	public Long getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
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
	
	
	
	
	

}
