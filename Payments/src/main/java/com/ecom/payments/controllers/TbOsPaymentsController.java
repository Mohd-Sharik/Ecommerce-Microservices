package com.ecom.payments.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.payments.models.TbOSPaymentsModel;
import com.ecom.payments.services.TbOsPamentsService;
import com.onlineShop.example.commonModel.ServiceOperationResult;
import com.onlineShop.example.commonUtilMethods.FilterParameter;
import com.onlineShop.example.exception.BusinessException;
import com.onlineShop.example.exception.DatabaseException;

@RestController
@CrossOrigin
@RequestMapping("/payment")
public class TbOsPaymentsController {
	
	
	@Autowired
	private TbOsPamentsService tbOsPamentsService;
	
	
	
	
	//getList
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ServiceOperationResult<List<TbOSPaymentsModel>> findAll(@RequestBody FilterParameter filter)
	{
		ServiceOperationResult<List<TbOSPaymentsModel>> result = new ServiceOperationResult<List<TbOSPaymentsModel>>();
		try
		{
			result = tbOsPamentsService.getAll(filter);
		}
		catch(DatabaseException ex)
		{
			throw new BusinessException(ex);
		}
		
		return result;
	}

}
