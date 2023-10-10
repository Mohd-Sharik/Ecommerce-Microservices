package com.ecom.pament.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.pament.models.TbOSPaymentModel;
import com.ecom.pament.services.TbOsPaymentService;
//import com.ecom.payments.models.TbOSPaymentsModel;
import com.onlineShop.example.commonModel.ServiceOperationResult;
import com.onlineShop.example.commonUtilMethods.FilterParameter;
import com.onlineShop.example.exception.BusinessException;
import com.onlineShop.example.exception.DatabaseException;

@RestController
@RequestMapping("/payment")
public class TbOsPaymentController {
	
	
	@Autowired
	TbOsPaymentService tbOsPaymentService;

	
	
	
	
	//get by order-Id
	@RequestMapping(value = "/orderId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ServiceOperationResult<TbOSPaymentModel> getByOrderId(@RequestBody TbOSPaymentModel model)
	{
		ServiceOperationResult<TbOSPaymentModel> result = new ServiceOperationResult<TbOSPaymentModel>();
		try
		{
			result = tbOsPaymentService.findByOrderId(model);
		}
		catch(DatabaseException ex)
		{
			throw new BusinessException(ex);
		}
		return result;
	}

	//do Payment
	@RequestMapping(value = "/doPayment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ServiceOperationResult<TbOSPaymentModel> doPayment(TbOSPaymentModel model)
	{
		ServiceOperationResult<TbOSPaymentModel> result = new ServiceOperationResult<TbOSPaymentModel>();
		try
		{
			result = tbOsPaymentService.doPayment(model);
		}
		catch(DatabaseException ex)
		{
			throw new BusinessException(ex);
		}
		return result;
	}
	
	
	
	//getList
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ServiceOperationResult<List<TbOSPaymentModel>> findAll(@RequestBody FilterParameter filter)
	{
		ServiceOperationResult<List<TbOSPaymentModel>> result = new ServiceOperationResult<List<TbOSPaymentModel>>();
		try
		{
			result = tbOsPaymentService.getAll(filter);
		}
		catch(DatabaseException ex)
		{
			throw new BusinessException(ex);
		}
		
		return result;
	}


}
