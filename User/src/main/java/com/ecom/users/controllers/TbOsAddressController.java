package com.ecom.users.controllers;

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

import com.ecom.users.externalService.RatingService;
import com.ecom.users.models.TbOsAdrsModel;
import com.ecom.users.models.TbOsCityModel;
import com.ecom.users.models.TbOsColonyModdel;
import com.ecom.users.models.TbOsContryModdel;
import com.ecom.users.models.TbOsDelegModel;
import com.ecom.users.models.TbOsPostalModel;
import com.ecom.users.models.TbOsStateModel;
import com.ecom.users.services.TbOsAddressService;

@RestController
@CrossOrigin
@RequestMapping("/Address")
public class TbOsAddressController {
	
	
	@Autowired
	private TbOsAddressService tbOsAddressService;
	
	@Autowired
	private RatingService ratingService;
	
	
	
	
	//list Country
	@RequestMapping(value = "/getAllcontry", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbOsContryModdel>> getAll()
	{
		List<TbOsContryModdel> result = new ArrayList<TbOsContryModdel>();
		
		result =tbOsAddressService.listCountry();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
	
	
	
	//list State
	@RequestMapping(value = "/getAllState", method =RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbOsStateModel>> listState()
	{
		List<TbOsStateModel> response = new ArrayList<TbOsStateModel>();
		
		response = tbOsAddressService.listState();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(response);
	}
	
	//list of City
	@RequestMapping(value = "/getAllCity", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbOsCityModel>> getCityList()
	{
		List<TbOsCityModel> response = new ArrayList<TbOsCityModel>();
		
		response = tbOsAddressService.getAllCity();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(response);
	}
	
	//list Of Dele
	@RequestMapping(value = "/getAllDele", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbOsDelegModel>> getDeleList()
	{
		List<TbOsDelegModel> result = new ArrayList<TbOsDelegModel>();
		result = tbOsAddressService.getDele();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
	
	// list of Colony
	@RequestMapping(value = "/getAllColony", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbOsColonyModdel>> getAllColony()
	{
		List<TbOsColonyModdel> result = new ArrayList<TbOsColonyModdel>();
		result = tbOsAddressService.getAllColony();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
	
	//get All Postal
	@RequestMapping(value = "/getAllPostal", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbOsPostalModel>> getAllPostal()
	{
		List<TbOsPostalModel> result = new ArrayList<TbOsPostalModel>();
		result = tbOsAddressService.getAllPoatal();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
	
	
	//get All Address
	@RequestMapping(value = "/getAllAddress", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbOsAdrsModel>> getAllAddress()
	{
		List<TbOsAdrsModel> result = new ArrayList<TbOsAdrsModel>();
		result = tbOsAddressService.getAllAddress();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}

}
