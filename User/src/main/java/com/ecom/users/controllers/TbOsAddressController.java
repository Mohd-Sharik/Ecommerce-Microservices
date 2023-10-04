package com.ecom.users.controllers;

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

import com.ecom.users.externalService.RatingService;
import com.ecom.users.models.TbOsAdrsModel;
import com.ecom.users.models.TbOsCityModel;
import com.ecom.users.models.TbOsColonyModdel;
import com.ecom.users.models.TbOsContryModdel;
import com.ecom.users.models.TbOsDelegModel;
import com.ecom.users.models.TbOsPostalModel;
import com.ecom.users.models.TbOsStateModel;
import com.ecom.users.services.TbOsAddressService;

import io.micrometer.core.instrument.config.validate.Validated.Valid;

@RestController
@CrossOrigin
@RequestMapping("/Address")
public class TbOsAddressController {
	
	
	@Autowired
	private TbOsAddressService tbOsAddressService;	
	
	
	//list Country
	@RequestMapping(value = "/getAllcontry", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbOsContryModdel>> getAll()
	{
		List<TbOsContryModdel> result = new ArrayList<TbOsContryModdel>();
		
		result =tbOsAddressService.listCountry();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
	
	//add or Update Country
	@RequestMapping(value = "/addOrUpdateContry", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public TbOsContryModdel addOrUpdateContry(@RequestBody TbOsContryModdel model)
	{
		TbOsContryModdel result = null;
		try
		{
			result = tbOsAddressService.addOrUpdateCountry(model);
		}
		catch(Exception e)
		{
			System.out.println("Exception occure inside Add or Update Contry : "+e);
		}
		
		return result;
	}
	
	
	
	//list State
	@RequestMapping(value = "/getAllState", method =RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbOsStateModel>> listState()
	{
		List<TbOsStateModel> response = new ArrayList<TbOsStateModel>();
		
		response = tbOsAddressService.listState();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(response);
	}
	
	
	// add or Update State
	@RequestMapping(value = "/addOrUpdateState", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public TbOsStateModel addOrUpdateState(@RequestBody TbOsStateModel model)
	{
		TbOsStateModel result = null;
		try
		{
			result = tbOsAddressService.addOrUpdateState(model);
		}
		catch(Exception e)
		{
			System.out.println("Exception occure inside add or Uppdate Controller Method "+e);
		}
		return result;
	}
	
	
	//list of City
	@RequestMapping(value = "/getAllCity", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbOsCityModel>> getCityList()
	{
		List<TbOsCityModel> response = new ArrayList<TbOsCityModel>();
		
		response = tbOsAddressService.getAllCity();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(response);
	}
	
	//add or Update City
	@RequestMapping(value = "/adddOrupdateCity", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public TbOsCityModel addOrUpdateCity(TbOsCityModel model)
	{
		TbOsCityModel result = null;
		try
		{
			result = tbOsAddressService.addOrUpdateCit(model);
		}
		catch(Exception e)
		{
			System.out.println("Exeption occure inside Add or Update City Controller Method : "+e);
		}
		return result;
	}
	
	//list Of Dele
	@RequestMapping(value = "/getAllDele", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbOsDelegModel>> getDeleList()
	{
		List<TbOsDelegModel> result = new ArrayList<TbOsDelegModel>();
		result = tbOsAddressService.getDele();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
	
	//add or Update Deleg
	@RequestMapping(value = "/addOrUpdateDele", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public TbOsDelegModel addOrUpdateDele(@RequestBody TbOsDelegModel model)
	{
		TbOsDelegModel result = null;
		try
		{
			result = tbOsAddressService.addOrUpdateDeleg(model);
		}
		catch(Exception e)
		{
			System.out.println("Exception Occure inside Add or Update Controller Method  : "+e);
		}
		return result;
	}
	
	// list of Colony
	@RequestMapping(value = "/getAllColony", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbOsColonyModdel>> getAllColony()
	{
		List<TbOsColonyModdel> result = new ArrayList<TbOsColonyModdel>();
		result = tbOsAddressService.getAllColony();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
	
	
	// Add or Update Colony
	@RequestMapping(value = "/addorUpdateColony", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public TbOsColonyModdel addOrUpdateColony(@RequestBody TbOsColonyModdel model)
	{
		TbOsColonyModdel result = null;
		try
		{
			result = tbOsAddressService.addOrUpdateColony(model);
		}
		catch(Exception e)
		{
			System.out.println("Exception occure inside Add or Update Colony Controller : "+e);
		}
		return result;
	}
	
	
	//get All Postal
	@RequestMapping(value = "/getAllPostal", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbOsPostalModel>> getAllPostal()
	{
		List<TbOsPostalModel> result = new ArrayList<TbOsPostalModel>();
		result = tbOsAddressService.getAllPoatal();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
	
	
	
	// add or Update Postal
	@RequestMapping(value = "/addOrUpdatePostal", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public TbOsPostalModel addOrUpdatePostal(TbOsPostalModel model)
	{
		TbOsPostalModel result = null;
		try
		{
			result = tbOsAddressService.addOrUpdatePostal(model);
		}
		catch(Exception e)
		{
			System.out.println("Exception occure inside add or Update Postal Controller : "+e);
		}
		return result;
	}
	
	
	//get All Address
	@RequestMapping(value = "/getAllAddress", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TbOsAdrsModel>> getAllAddress()
	{
		List<TbOsAdrsModel> result = new ArrayList<TbOsAdrsModel>();
		result = tbOsAddressService.getAllAddress();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
	
	//add or Update Address
	@RequestMapping(value = "/addOrUpdateAdrs", method = RequestMethod.POST, produces =  MediaType.APPLICATION_JSON_VALUE)
	public TbOsAdrsModel addOrUpdateAddrs(@RequestBody TbOsAdrsModel model)
	{
		TbOsAdrsModel result = null;
		try
		{
			result = tbOsAddressService.addOrUpdateAddress(model);
		}
		catch(Exception e)
		{
			System.out.println("Exception occure inside Add or Update Controller Method : "+e);
		}
		return result;
	}
	

}
