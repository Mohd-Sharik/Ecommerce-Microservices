package com.ecom.users.controllers;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import com.ecom.users.models.TbOsCustomerModel;
import com.ecom.users.services.TbOsCustomerService;
import com.onlineShop.example.commonModel.ServiceOperationResult;
import com.onlineShop.example.commonUtilMethods.FilterParameter;
import com.onlineShop.example.exception.BusinessException;
import com.onlineShop.example.exception.DatabaseException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
@CrossOrigin
@RequestMapping("/customer")
public class TbOsCustomerController {
	
	
	Logger logger = LoggerFactory.getLogger(TbOsCustomerService.class);
	
	
	@Autowired
	private TbOsCustomerService tbOsCustomerService;
	
	
	// get all user
	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallBackUser")
	public ServiceOperationResult<List<TbOsCustomerModel>> getAllCustomers(@RequestBody FilterParameter filter)
	{
		ServiceOperationResult<List<TbOsCustomerModel>> result = new ServiceOperationResult<List<TbOsCustomerModel>>();
		
		try
		{
			result = tbOsCustomerService.getAllCustomer(filter);
			
		}
		catch(DatabaseException e)
		{
			throw new BusinessException(e);
		}
		return result;
	}
	
	//fallBacMethod
	public ServiceOperationResult<TbOsCustomerModel> fallBackUser(Exception ex)
	{
		ServiceOperationResult<TbOsCustomerModel> response = new ServiceOperationResult<TbOsCustomerModel>();
		System.out.println("Method failed because Service Down : "+ex);
		TbOsCustomerModel model = new TbOsCustomerModel();
		model.setDislayName("DummyUser");
		model.setContactNumber("90********7");
		model.setEmail("dummy@gmail.com");
		model.setAddrType("Lovalhost");
		
		response.setResponse(model);
		
		return response;
	}
	
	
	// add or Update user
	@RequestMapping(value = "/addOrUpdateUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ServiceOperationResult<TbOsCustomerModel> addorUpdateUser(@RequestBody TbOsCustomerModel model) throws Exception
	{
		ServiceOperationResult<TbOsCustomerModel> result = new ServiceOperationResult<>();
		try
		{
			result = tbOsCustomerService.addOrUpdateUser(model);
		}
		catch(DatabaseException e)
		{
			throw new BusinessException(e);
			
		}
		return result;
	}
	
	
	// User Soft Delete
	@RequestMapping(value = "/userSoftDelete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ServiceOperationResult<TbOsCustomerModel> softDeletUser(TbOsCustomerModel model)
	{
		ServiceOperationResult<TbOsCustomerModel> result = new ServiceOperationResult<TbOsCustomerModel>();
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
