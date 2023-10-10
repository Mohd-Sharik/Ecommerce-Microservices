package com.ecom.pament.models;

import java.util.Date;

public class TbOSPaymentModel {
	
	
	
	 private Long id;
	    
		private Long orderId;
		
		private String paymentMode;
		
		private String referenceNumber;
		
		private String paymentStatus;
		
		private Double amont;
		
		private Date crtTs;
		
		private String crtBy;
		
		private String crtTsString;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getOrderId() {
			return orderId;
		}

		public void setOrderId(Long orderId) {
			this.orderId = orderId;
		}

		public String getPaymentMode() {
			return paymentMode;
		}

		public void setPaymentMode(String paymentMode) {
			this.paymentMode = paymentMode;
		}

		public String getReferenceNumber() {
			return referenceNumber;
		}

		public void setReferenceNumber(String referenceNumber) {
			this.referenceNumber = referenceNumber;
		}

		public String getPaymentStatus() {
			return paymentStatus;
		}

		public void setPaymentStatus(String paymentStatus) {
			this.paymentStatus = paymentStatus;
		}

		public Double getAmont() {
			return amont;
		}

		public void setAmont(Double amont) {
			this.amont = amont;
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

		public String getCrtTsString() {
			return crtTsString;
		}

		public void setCrtTsString(String crtTsString) {
			this.crtTsString = crtTsString;
		}
		
		
		


}
