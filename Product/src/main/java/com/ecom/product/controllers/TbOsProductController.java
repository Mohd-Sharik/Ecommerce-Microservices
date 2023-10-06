package com.ecom.product.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.product.models.TbOSProductModel;
import com.ecom.product.models.TbOsCatagoryModel;
import com.ecom.product.models.TbOsInvntoryModel;
import com.ecom.product.services.TbOsProductService;
//import com.ecom.users.services.TbOsCustomerService;
import com.onlineShop.example.commonModel.ServiceOperationResult;
import com.onlineShop.example.commonUtilMethods.FilterParameter;
import com.onlineShop.example.exception.BusinessException;
import com.onlineShop.example.exception.DatabaseException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class TbOsProductController {
	
//Logger logger = LoggerFactory.getLogger(TbOsProductController.class);
	
	@Autowired
	private TbOsProductService tbOsProductService;
	
	
	
	//list Catagory
	@RequestMapping(value = "/catagoryList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ServiceOperationResult<List<TbOsCatagoryModel>> findAllCatagory(@RequestBody FilterParameter filter)
	{
		ServiceOperationResult<List<TbOsCatagoryModel>> result = new ServiceOperationResult<List<TbOsCatagoryModel>>();
		try
		{
			result = tbOsProductService.getAllCatagory(filter);
		}
		catch(DatabaseException ex)
		{
			throw new BusinessException(ex);
		}
		
		return result;
	}
	
	//List Inventory
	@RequestMapping(value = "/inventoryList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbOsInvntoryModel>> findAllInventory()
	{
		List<TbOsInvntoryModel> result = new ArrayList<TbOsInvntoryModel>();
		result = tbOsProductService.getAllInventory();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
	
	//List Product
	@RequestMapping(value = "/productList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallbackmethod")
	public ServiceOperationResult<List<TbOSProductModel>> getAllProduct(@RequestBody FilterParameter filter)
	{
		
		ServiceOperationResult<List<TbOSProductModel>> result = new ServiceOperationResult<List<TbOSProductModel>>();
		try
		{
			result = tbOsProductService.getAllProduct(filter);
			
		}
		catch(DatabaseException ex)
		{
			throw new BusinessException(ex);
		}
		
		return result;
	}
	
	public ServiceOperationResult<TbOSProductModel> fallbackmethod(Exception e)
	{
		ServiceOperationResult<TbOSProductModel> response = new ServiceOperationResult<TbOSProductModel>();
		System.out.println("execute fallbac method because service is down : "+e);
		TbOSProductModel model = new TbOSProductModel();
		
		model.setProductName("failedName");
		model.setBrand("DummyBrand");
		model.setColor("NetworFailed");
		model.setCatagoryDescr("nothing is there because method failed");
		
		response.setResponse(model);
		
		return response;
	}

}
