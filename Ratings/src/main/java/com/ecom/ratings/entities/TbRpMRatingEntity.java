package com.ecom.ratings.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_RP_M_RATING")
public class TbRpMRatingEntity  implements Serializable {

	/**
	 * @author Sharik
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_M_RATING_GEN")
	@SequenceGenerator(name = "SEQ_M_RATING_GEN", sequenceName = "SEQ_M_RATING_GEN", allocationSize = 1)
	private Long id;
	
	
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "PRODUCT_ID")
	private Long productId;
	
	@Column(name = "RATINGS")
	private Long rating;
	
	@Column(name = "FEEDBACK")
	private String feedback;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	

}
