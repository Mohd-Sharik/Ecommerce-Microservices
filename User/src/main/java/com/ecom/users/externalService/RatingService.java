package com.ecom.users.externalService;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecom.users.configuration.MyConfig;
import com.ecom.users.models.TbRpMRatingModel;


@Service
@FeignClient(name = "RATINGS-SERVICE") //, url = "http://localhost:9996") ResponseEntity<List<TbRpMRatingModel>>
public interface RatingService {
	
	@GetMapping("/Ratings/findByUserIdRating/{id}")
	List<TbRpMRatingModel> findRatingByUserId(@PathVariable("id") Long id);
}
