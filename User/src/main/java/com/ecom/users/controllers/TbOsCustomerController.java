package com.ecom.users.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.users.models.TbOsCustomerModel;
import com.ecom.users.services.TbOsCustomerService;


@RestController
@CrossOrigin
@RequestMapping("/customer")
public class TbOsCustomerController {
	
	
	Logger logger = LoggerFactory.getLogger(TbOsCustomerService.class);
	
	
	@Autowired
	private TbOsCustomerService tbOsCustomerService;
	
	
	
	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbOsCustomerModel>> getAllCustomers()
	{
		List<TbOsCustomerModel> result = new ArrayList<TbOsCustomerModel>();
		
		result = tbOsCustomerService.getAllCustomer();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}

}
