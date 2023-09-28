package com.ecom.product.externalService;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecom.product.models.TbRpMRatingModel;

@Service
@FeignClient(name = "RATINGS-SERVICE")
public interface RatingService {

	@GetMapping("/Ratings/findByProductId/{productId}")
	List<TbRpMRatingModel> findByProductId(@PathVariable("productId") Long productId);
	
	
}
