package com.ecom.ratings.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.ratings.models.TbRpMRatingModel;
import com.ecom.ratings.services.TbRpMRatingService;

@RestController
@CrossOrigin
@RequestMapping("/Ratings")
public class TbRpMRatingController {
	
	
	@Autowired
	private TbRpMRatingService tbRpMRatingService;
	
	
	//get All List of Rating
	@RequestMapping(value = "/ratingList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbRpMRatingModel>> getAllRating()
	{
		List<TbRpMRatingModel> result = new ArrayList<TbRpMRatingModel>();
		
		result = tbRpMRatingService.getAllRating();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}

}
