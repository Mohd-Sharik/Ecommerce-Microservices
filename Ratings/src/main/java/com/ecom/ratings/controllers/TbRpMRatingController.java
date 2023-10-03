package com.ecom.ratings.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	//add or Update Rating
	@RequestMapping(value = "/addOrUpdareRating", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public TbRpMRatingModel addOrUpdate(@RequestBody TbRpMRatingModel entity)
	{
		TbRpMRatingModel result;
		result = tbRpMRatingService.addOrUpdate(entity);
		
		return result;
	}
	
	//find by productId
	@RequestMapping(value = "/findByProductId/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TbRpMRatingModel> findByProductId(@PathVariable("productId") Long productId)
	{
		List<TbRpMRatingModel> result = new ArrayList<TbRpMRatingModel>();
		
		result = tbRpMRatingService.findByProductId(productId);
		
		return result;
	}
	
	
	//find by userId 
	@RequestMapping(value = "/findByUserIdRating/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TbRpMRatingModel> findRatingByUserId(@PathVariable("id") Long id)
	{
		List<TbRpMRatingModel> result = new ArrayList<TbRpMRatingModel>();
		result = tbRpMRatingService.ratingByUserId(id);
		return result; //ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
	//get All List of Rating
	@RequestMapping(value = "/ratingList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbRpMRatingModel>> getAllRating()
	{
		List<TbRpMRatingModel> result = new ArrayList<TbRpMRatingModel>();
		
		result = tbRpMRatingService.getAllRating();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}

}
