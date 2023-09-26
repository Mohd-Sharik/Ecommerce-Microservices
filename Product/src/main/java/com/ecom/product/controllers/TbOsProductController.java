package com.ecom.product.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.product.models.TbOsCatagoryModel;
import com.ecom.product.services.TbOsProductService;

@RestController
@RequestMapping(name = "/product")
public class TbOsProductController {
	
	@Autowired
	private TbOsProductService tbOsProductService;
	
	
	@RequestMapping(value = "/catagoryList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbOsCatagoryModel>> findAll()
	{
		List<TbOsCatagoryModel> result = new ArrayList<TbOsCatagoryModel>();
		result = tbOsProductService.getAll();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}

}
