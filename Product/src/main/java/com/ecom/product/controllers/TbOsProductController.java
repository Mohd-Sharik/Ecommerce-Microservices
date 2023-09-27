package com.ecom.product.controllers;

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

import com.ecom.product.models.TbOSProductModel;
import com.ecom.product.models.TbOsCatagoryModel;
import com.ecom.product.models.TbOsInvntoryModel;
import com.ecom.product.services.TbOsProductService;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class TbOsProductController {
	
	@Autowired
	private TbOsProductService tbOsProductService;
	
	
	
	//list Catagory
	@RequestMapping(value = "/catagoryList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbOsCatagoryModel>> findAllCatagory()
	{
		List<TbOsCatagoryModel> result = new ArrayList<TbOsCatagoryModel>();
		result = tbOsProductService.getAllCatagory();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
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
	public ResponseEntity<List<TbOSProductModel>> getAllProduct()
	{
		List<TbOSProductModel> result = new ArrayList<TbOSProductModel>();
		result = tbOsProductService.getAllProduct();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
				
	}

}