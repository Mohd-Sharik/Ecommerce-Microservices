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

import com.ecom.users.models.TbOsContryModdel;
import com.ecom.users.services.TbOsContryService;

@RestController
@CrossOrigin
@RequestMapping("/country")
public class TbOsContryController {
	
	
	@Autowired
	private TbOsContryService tbOsContryService;
	
	
	
	@RequestMapping(value = "/getAllcontry", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbOsContryModdel>> getAll()
	{
		List<TbOsContryModdel> result = new ArrayList<TbOsContryModdel>();
		
		result = tbOsContryService.getAll();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}

}
