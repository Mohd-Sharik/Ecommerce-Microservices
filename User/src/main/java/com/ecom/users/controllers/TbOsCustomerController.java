package com.ecom.users.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Media;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.users.models.TbOsCustomerModel;
import com.ecom.users.services.TbOsCustomerService;
import com.onlineShop.example.exception.BusinessException;
import com.onlineShop.example.exception.DatabaseException;


@RestController
@CrossOrigin
@RequestMapping("/customer")
public class TbOsCustomerController {
	
	
	Logger logger = LoggerFactory.getLogger(TbOsCustomerService.class);
	
	
	@Autowired
	private TbOsCustomerService tbOsCustomerService;
	
	
	// get all user
	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbOsCustomerModel>> getAllCustomers()
	{
		List<TbOsCustomerModel> result = new ArrayList<TbOsCustomerModel>();
		
		result = tbOsCustomerService.getAllCustomer();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
	
	
	// add or Update user
	@RequestMapping(value = "/addOrUpdateUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public TbOsCustomerModel addorUpdateUser(@RequestBody TbOsCustomerModel model)
	{
		TbOsCustomerModel result =null;
		try
		{
			result = tbOsCustomerService.addOrUpdateUser(model);
		}
		catch(Exception e)
		{
			System.out.println("Exception occre inside Add or Updare User Controller : "+e);
		}
		return result;
	}
	
	
	// User Soft Delete
	@RequestMapping(value = "/userSoftDelete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public TbOsCustomerModel softDeletUser(TbOsCustomerModel model)
	{
		TbOsCustomerModel result = null;
		try
		{
			result = tbOsCustomerService.softDleteUser(model);
		}
		catch(DatabaseException e)
		{
			throw new BusinessException(e);
		}
		return result;
	}
	
	
	
	

}
