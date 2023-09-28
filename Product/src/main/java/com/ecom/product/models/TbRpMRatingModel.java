package com.ecom.product.models;

public class TbRpMRatingModel {
	
	
			private Long id;
			private Long userId;
			private Long productId;
			private Long ratings;
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
			public Long getRatings() {
				return ratings;
			}
			public void setRatings(Long ratings) {
				this.ratings = ratings;
			}
			public String getFeedback() {
				return feedback;
			}
			public void setFeedback(String feedback) {
				this.feedback = feedback;
			}
			
			
			
			

}
