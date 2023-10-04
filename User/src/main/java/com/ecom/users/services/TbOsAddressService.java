package com.ecom.users.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.users.commonUtil.CommonConstant;
import com.ecom.users.commonUtil.CommonUtilityHelper;
import com.ecom.users.entites.TbOsAdrssEntity;
import com.ecom.users.entites.TbOsCityEntity;
import com.ecom.users.entites.TbOsColonyEntity;
import com.ecom.users.entites.TbOsCountryEntity;
import com.ecom.users.entites.TbOsDelegEntity;
import com.ecom.users.entites.TbOsPostalEntity;
import com.ecom.users.entites.TbOsStateEntity;
import com.ecom.users.models.TbOsAdrsModel;
import com.ecom.users.models.TbOsCityModel;
import com.ecom.users.models.TbOsColonyModdel;
import com.ecom.users.models.TbOsContryModdel;
import com.ecom.users.models.TbOsDelegModel;
import com.ecom.users.models.TbOsPostalModel;
import com.ecom.users.models.TbOsStateModel;
import com.ecom.users.persistance.TbOsAdrsPersistance;
import com.ecom.users.persistance.TbOsCityPersistance;
import com.ecom.users.persistance.TbOsColonyPersistance;
import com.ecom.users.persistance.TbOsCountryPersistance;
import com.ecom.users.persistance.TbOsDelePersistance;
import com.ecom.users.persistance.TbOsPostalPersistance;
import com.ecom.users.persistance.TbOsStatePersistance;

@Service
public class TbOsAddressService {
	
	
	
	
	@Autowired
	private TbOsCountryPersistance tbOsCountryPersistance;
	
	@Autowired
	private TbOsStatePersistance tbOsStatePersistance;
	
	@Autowired
	private TbOsCityPersistance tbOsCityPersistance;
	
	@Autowired
	private TbOsDelePersistance tbOsDelePersistance;
	
	@Autowired
	private TbOsColonyPersistance  tbOsColonyPersistance;
	
	@Autowired
	private TbOsPostalPersistance tbOsPostalPersistance;
	
	@Autowired
	private TbOsAdrsPersistance tbOsAdrsPersistance;
	
	
	// get All List of Country
	public List<TbOsContryModdel>  listCountry()
	{
		List<TbOsCountryEntity> response = new ArrayList<>();
		List<TbOsContryModdel> list = new ArrayList<TbOsContryModdel>();
		
		response = tbOsCountryPersistance.findAll();
		for(TbOsCountryEntity entity : response)
		{
			TbOsContryModdel model = new TbOsContryModdel();
			
			model.setId(entity.getId() != null ? entity.getId() : null);
			model.setName(entity.getName() != null ? entity.getName() : null);
			model.setNumCode(entity.getNumCode());// != null)// ? entity.getNumCode() : null);
			model.setAlphaCd2(entity.getAlphaCd2() != null ? entity.getAlphaCd2() : null);
			model.setAlphaCd3(entity.getAlphaCd3() != null ? entity.getAlphaCd3() : null);
			model.setUpdBy(entity.getUpdBy() != null ? entity.getUpdBy() : null);
			model.setUpdTs(entity.getUpdTs() != null ? entity.getUpdTs() : null);
			model.setUpddTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getUpdTs(), CommonConstant.dateFormate.DD_MMM_YYYY_HHMMSS_SSS_A));
			
			list.add(model);
		}
		
		return list;
	}
	
	// add or update Country
	public TbOsContryModdel addOrUpdateCountry(TbOsContryModdel model)
	{
		
		try
		{
			Long id = model.getId();
			if(id != null)
			{
				Optional<TbOsCountryEntity> getData = tbOsCountryPersistance.findById(id);
				if(getData.isPresent())
				{
					TbOsCountryEntity entity = getData.get();
					
					entity.setId(model.getId() != null ? model.getId() : entity.getId());
					entity.setName(model.getName() != null ? model.getName() : entity.getName());
					entity.setNumCode(model.getNumCode());
					entity.setAlphaCd2(model.getAlphaCd2() != null ? model.getAlphaCd2() : entity.getAlphaCd2());
					entity.setAlphaCd3(model.getAlphaCd3() != null ? model.getAlphaCd3() : entity.getAlphaCd3());
					entity.setUpdTs(new Date());
					entity.setUpdBy("SYSTEM");
					
					tbOsCountryPersistance.save(entity);
				}
			}
			else
			{
				TbOsCountryEntity entity  = new TbOsCountryEntity();
				
				entity.setId(null);
				entity.setName(model.getName() != null ? model.getName() : entity.getName());
				entity.setNumCode(model.getNumCode());
				entity.setAlphaCd2(model.getAlphaCd2() != null ? model.getAlphaCd2() : entity.getAlphaCd2());
				entity.setAlphaCd3(model.getAlphaCd3() != null ? model.getAlphaCd3() : entity.getAlphaCd3());
				
				
				tbOsCountryPersistance.save(entity);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exeception occure inside Add or Update Country "+e);
		}
		return model;
	}
	
	//get All State List
		public List<TbOsStateModel> listState()
		{
			List<TbOsStateModel> result = new ArrayList<TbOsStateModel>();
			
			List<TbOsStateEntity> lists = tbOsStatePersistance.findAll();
			
			for(TbOsStateEntity entity : lists)
			{
				TbOsStateModel model = new TbOsStateModel();
				
				model.setId(entity.getId() != null ? entity.getId() : null);
				if(entity.getTbOsCountry() != null)
				{
					model.setCountryName(entity.getTbOsCountry().getName());
				}
				model.setCd(entity.getCd() != null ? entity.getCd() : null);
				model.setNm(entity.getNm() != null ? entity.getNm() : null);
				model.setUpdBy(entity.getUpdBy() != null ? entity.getUpdBy() : null);
				model.setUpdTs(entity.getUpdTs() != null ? entity.getUpdTs() : null);
				model.setUpdTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getUpdTs(), CommonConstant.dateFormate.DD_MMM_YYYY_HHMMSS_SSS_A));
				
				result.add(model);
			}
			return result;
		}
		
		//add or Updare State
		public TbOsStateModel addOrUpdateState(TbOsStateModel model)
		{
			
			try
			{
				Long id = model.getId();
				if(id != null)
				{
					Optional<TbOsStateEntity> data = tbOsStatePersistance.findById(id);
					if(data.isPresent())
					{
						TbOsStateEntity entity = data.get();
						
						entity.setId(model.getId() != null ? model.getId() : entity.getId());
						Long cid = null;
						if(entity.getTbOsCountry() != null)
						{
							cid = entity.getTbOsCountry().getId();
						}
						if(cid != null)
						{
							entity.setTbOsCountry(tbOsCountryPersistance.findById(cid).get());
						}
						entity.setCd(model.getCd() != null ? model.getCd() : entity.getCd());
						entity.setNm(model.getNm() != null ? model.getNm() : entity.getNm());
						entity.setUpdBy("SYSTEM");
						entity.setUpdTs(new Date());
						
						tbOsStatePersistance.save(entity);
					}
				}
				else
				{
					
					TbOsStateEntity entity = new TbOsStateEntity();
					
					entity.setId(null);
					Long cid = null;
					if(entity.getTbOsCountry() != null)
					{
						cid = entity.getTbOsCountry().getId();
					}
					if(cid != null)
					{
						entity.setTbOsCountry(tbOsCountryPersistance.findById(cid).get());
					}
					
					entity.setCd(model.getCd() != null ? model.getCd() : entity.getCd());
					entity.setNm(model.getNm() != null ? model.getNm() : entity.getNm());
					
					tbOsStatePersistance.save(entity);
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception occur inside add or Update Satate Service method "+e);
			}
			return model;
		}
		
		// get City
		public List<TbOsCityModel> getAllCity()
		{
			List<TbOsCityModel> result = new ArrayList<TbOsCityModel>();
			
			List<TbOsCityEntity> entities = tbOsCityPersistance.findAll();
			
			for(TbOsCityEntity entity : entities)
			{
				TbOsCityModel model = new TbOsCityModel();
				
				model.setId(entity.getId() != null ? entity.getId() : null);
				model.setCd(entity.getCd() != null ? entity.getCd() : null);
				model.setNm(entity.getNm() != null ? entity.getNm() : null);
				
				model.setStateName(entity.getTbOsState().getNm());
				model.setCountryName(entity.getTbOsState().getTbOsCountry().getName());
				
				model.setUpdBy(entity.getUpdBy() != null ? entity.getUpdBy() : null);
				model.setUpdTs(entity.getUpdTs() != null ? entity.getUpdTs() : null);
				model.setUpdTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getUpdTs(), CommonConstant.dateFormate.DD_MMM_YYYY_HHMMSS_SSS_A));

				result.add(model);
			}
			
			return result;
		}
		
		
		// add or Update City
		public TbOsCityModel addOrUpdateCit(TbOsCityModel model)
		{
			
			try
			{
				Long id = model.getId();
				if(id != null)
				{
					Optional<TbOsCityEntity> data = tbOsCityPersistance.findById(id);
					if(data.isPresent())
					{
						TbOsCityEntity entity = data.get();
						
						entity.setId(id);
						Long sId = null;
						if(entity.getTbOsState() != null)
						{
							sId = entity.getTbOsState().getId();
						}
						if(sId != null)
						{
							entity.setTbOsState(tbOsStatePersistance.findById(sId).get());
						}
						entity.setCd(model.getCd() != null ? model.getCd() : entity.getCd());
						entity.setNm(model.getNm() != null ? model.getNm() : entity.getNm());
						entity.setUpdBy("SYSTEM");
						entity.setUpdTs(new Date());
						
						tbOsCityPersistance.save(entity);
					}
				}
				else
				{
					TbOsCityEntity entity = new TbOsCityEntity();
					entity.setId(null);
					Long sId = null;
					if(entity.getTbOsState() != null)
					{
						sId = entity.getTbOsState().getId();
					}
					if(sId != null)
					{
						entity.setTbOsState(tbOsStatePersistance.findById(sId).get());
					}
					entity.setCd(model.getCd() != null ? model.getCd() : entity.getCd());
					entity.setNm(model.getNm() != null ? model.getNm() : entity.getNm());
					
					tbOsCityPersistance.save(entity);
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception occure inside Add or Update city Service Method : "+e);
			}
			return model;
		}
		
		//get All Dele
		public List<TbOsDelegModel> getDele()
		{
			List<TbOsDelegModel> response = new ArrayList<TbOsDelegModel>();
			
			List<TbOsDelegEntity> entities = tbOsDelePersistance.findAll();
			for(TbOsDelegEntity entity : entities)
			{
				TbOsDelegModel model = new TbOsDelegModel();
				
				model.setId(entity.getId()!= null ? entity.getId() : null);
				model.setNm(entity.getNm() != null ? entity.getNm() : null);
				model.setCd(entity.getCd() != null ? entity.getCd() : null);
				model.setCityName(entity.getTbOsCity()!= null ? entity.getTbOsCity().getNm() : null);
				model.setStateName(entity.getTbOsCity() != null ? entity.getTbOsCity().getTbOsState().getNm() : null);
				model.setCountryName(entity.getTbOsCity() != null ? entity.getTbOsCity().getTbOsState().getTbOsCountry().getName() : null);
				model.setUpdBy(entity.getUpdBy() != null ? entity.getUpdBy() : null);
				model.setUpdTs(entity.getUpdTs() != null ? entity.getUpdTs() : null);
				model.setUpdTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getUpdTs(), CommonConstant.dateFormate.DD_MMM_YYYY_HHMMSS_SSS_A));
				
				response.add(model);
			}
			
			return response;
		}
		
		
		//Add or Update Deleg
		public TbOsDelegModel addOrUpdateDeleg(TbOsDelegModel model)
		{
			try
			{
				Long id = model.getId();
				if(id != null)
				{
					Optional<TbOsDelegEntity> data = tbOsDelePersistance.findById(id);
					if(data.isPresent())
					{
						TbOsDelegEntity entity = data.get();
						
						entity.setId(id);
						
						Long cId = null;
						if(entity.getTbOsCity() != null)
						{
							cId = entity.getTbOsCity().getId();
						}
						if(cId != null)
						{
							entity.setTbOsCity(tbOsCityPersistance.findById(cId).get());
						}
						entity.setCd(model.getCd() != null ? model.getCd() : entity.getCd());
						entity.setNm(model.getNm() != null? model.getNm() : entity.getNm());
						entity.setUpdBy("SYSTEM");
						entity.setUpdTs(new Date());
						
						tbOsDelePersistance.save(entity);
					}
				}
				else
				{
					TbOsDelegEntity entity = new TbOsDelegEntity();
					
					entity.setId(null);
					
					Long cId = null;
					if(entity.getTbOsCity() != null)
					{
						cId = entity.getTbOsCity().getId();
					}
					if(cId != null)
					{
						entity.setTbOsCity(tbOsCityPersistance.findById(cId).get());
					}
					entity.setCd(model.getCd() != null ? model.getCd() : entity.getCd());
					entity.setNm(model.getNm() != null? model.getNm() : entity.getNm());
					
					tbOsDelePersistance.save(entity);
					
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception occure Inside add or Update Service Method : "+e);
			}
			
			return model;
		}
		
		public List<TbOsColonyModdel> getAllColony()
		{
			List<TbOsColonyModdel> response = new ArrayList<TbOsColonyModdel>();
			List<TbOsColonyEntity> entities = tbOsColonyPersistance.findAll();
			
			
			for(TbOsColonyEntity entity : entities)
			{
				TbOsColonyModdel model = new TbOsColonyModdel();
				
				model.setId(entity.getId() != null ? entity.getId() : null);
				model.setCd(entity.getCd() != null ? entity.getCd() : null);
				model.setNm(entity.getNm() != null ? entity.getNm() : entity.getNm());
				model.setDeleName(entity.getTbOsDeleg() != null ? entity.getTbOsDeleg().getNm() : null);
				model.setCityName(entity.getTbOsDeleg() != null ? entity.getTbOsDeleg().getTbOsCity().getNm() : null);
				model.setStateName(entity.getTbOsDeleg() != null ? entity.getTbOsDeleg().getTbOsCity().getTbOsState().getNm() : null);
				model.setCountryName(entity.getTbOsDeleg() != null ? entity.getTbOsDeleg().getTbOsCity().getTbOsState().getTbOsCountry().getName() : null);
				model.setUpdBy(entity.getUpdBy() != null ? entity.getUpdBy(): null);
				model.setUpdTs(entity.getUpdTs() != null ? entity.getUpdTs() : null);
				model.setUpdTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getUpdTs(), CommonConstant.dateFormate.DD_MMM_YYYY_HHMMSS_SSS_A));
				
				response.add(model);
			}
			
			return response;
		}
		
		
		// Add or update Colony
		public TbOsColonyModdel addOrUpdateColony(TbOsColonyModdel model)
		{
			
			try
			{
				Long id  = model.getId();
				if(id !=null)
				{
					Optional<TbOsColonyEntity> data = tbOsColonyPersistance.findById(id);
					if(data.isPresent())
					{
						TbOsColonyEntity entity = data.get();
						
						entity.setId(id);
						Long dId = null;
						if(entity.getTbOsDeleg() != null)
						{
							dId = entity.getTbOsDeleg().getId();
						}
						if(dId != null)
						{
							entity.setTbOsDeleg(tbOsDelePersistance.findById(id).get());
						}
						entity.setCd(model.getCd() != null ? model.getCd() : entity.getCd());
						entity.setNm(model.getNm() != null ? model.getNm() : entity.getNm());
						entity.setUpdBy("SYSTEM");
						entity.setUpdTs(new Date());
						
						tbOsColonyPersistance.save(entity);
					}
				}
				else
				{
					TbOsColonyEntity entity = new TbOsColonyEntity();
					
					entity.setId(id);
					Long dId = null;
					if(entity.getTbOsDeleg() != null)
					{
						dId = entity.getTbOsDeleg().getId();
					}
					if(dId != null)
					{
						entity.setTbOsDeleg(tbOsDelePersistance.findById(id).get());
					}
					entity.setCd(model.getCd() != null ? model.getCd() : entity.getCd());
					entity.setNm(model.getNm() != null ? model.getNm() : entity.getNm());
					
					tbOsColonyPersistance.save(entity);
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception occure inside Add or Update Colony Servie Method : "+e);
			}
			
			return model;
		}
		
		
		//get All Postal
		public List<TbOsPostalModel> getAllPoatal()
		{
			List<TbOsPostalModel> response = new ArrayList<TbOsPostalModel>();
			
			List<TbOsPostalEntity> entities = tbOsPostalPersistance.findAll();
			
			
			for(TbOsPostalEntity entity : entities)
			{
				TbOsPostalModel model = new TbOsPostalModel();
				
				model.setId(entity.getId() != null ? entity.getId() : null);
				model.setCd(entity.getCd() != null ? entity.getCd() : null);
				model.setNm(entity.getNm() != null ? entity.getNm() : null);
				model.setColonyName(entity.getTbOsColony() != null ? entity.getTbOsColony().getNm() : null);
				model.setDeleName(entity.getTbOsColony() != null ? entity.getTbOsColony().getTbOsDeleg().getNm() : null);
				model.setCityName(entity.getTbOsColony() != null ? entity.getTbOsColony().getTbOsDeleg().getTbOsCity().getNm() : null);
				model.setStateName(entity.getTbOsColony() != null ? entity.getTbOsColony().getTbOsDeleg().getTbOsCity().getTbOsState().getNm() : null);
				model.setCountryName(entity.getTbOsColony() != null ? entity.getTbOsColony().getTbOsDeleg().getTbOsCity().getTbOsState().getTbOsCountry().getName() : null);
				model.setUpdBy(entity.getUpdBy() != null ? entity.getUpdBy() : null);
				model.setUpdTs(entity.getUpdTs()!= null ? entity.getUpdTs() : null);
				model.setUpdTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getUpdTs(), CommonConstant.dateFormate.DD_MMM_YYYY_HHMMSS_SSS_A));
				
				response.add(model);	
			}
			return response;
		}
		
		
		// add or Update Postal
		public TbOsPostalModel addOrUpdatePostal(TbOsPostalModel model)
		{
			
			try
			{
				Long id = model.getId();
				if(id != null)
				{
					Optional<TbOsPostalEntity> data = tbOsPostalPersistance.findById(id);
					if(data.isPresent())
					{
						TbOsPostalEntity entity = new TbOsPostalEntity();
						
						entity.setId(id);
						Long cId = null;
						if(entity.getTbOsColony() != null)
						{
							cId = entity.getTbOsColony().getId();
						}
						if(cId != null)
						{
							entity.setTbOsColony(tbOsColonyPersistance.findById(cId).get());
						}
						entity.setCd(model.getCd() != null ? model.getCd() : entity.getCd());
						entity.setNm(model.getNm() != null ? model.getNm() : entity.getNm());
						entity.setUpdBy("SYSTEM");
						entity.setUpdTs(new Date());
						
						tbOsPostalPersistance.save(entity);
						
					}
				}
				else
				{
					
					TbOsPostalEntity entity = new TbOsPostalEntity();
					entity.setId(null);
					Long cId = null;
					if(entity.getTbOsColony() != null)
					{
						cId = entity.getTbOsColony().getId();
					}
					if(cId != null)
					{
						entity.setTbOsColony(tbOsColonyPersistance.findById(cId).get());
					}
					entity.setCd(model.getCd() != null ? model.getCd() : entity.getCd());
					entity.setNm(model.getNm() != null ? model.getNm() : entity.getNm());
					
					tbOsPostalPersistance.save(entity);
			
				}
			}
			catch(Exception e)
			{
				System.out.println("Exeption occure inside Add or Update Postal service methods : "+e);
			}
			
			return model;
		}
		
		// get All Address
		public List<TbOsAdrsModel> getAllAddress()
		{
			List<TbOsAdrsModel> response = new ArrayList<TbOsAdrsModel>();
			
			List<TbOsAdrssEntity> entities = tbOsAdrsPersistance.findAll();
			
			
			for(TbOsAdrssEntity entity : entities)
			{
				TbOsAdrsModel model = new TbOsAdrsModel();
				
				model.setId(entity.getId() != null ? entity.getId() : null);
				model.setHouseNo(entity.getHouseNo() != null ? entity.getHouseNo() : null);
				model.setStreeNo(entity.getStreeNo() != null ? entity.getStreeNo() : null);
				model.setColonyName(entity.getTbOsColony() != null ? entity.getTbOsColony().getNm() : null);
				model.setPostalName(entity.getTbOsPostal() != null ? entity.getTbOsPostal().getNm() : null);
				model.setPostalCode(entity.getTbOsPostal() != null ? entity.getTbOsPostal().getCd() : null);
				model.setDeleName(entity.getTbOsDeleg() != null ? entity.getTbOsDeleg().getNm() : null);
				model.setCityName(entity.getTbOsCity() != null ? entity.getTbOsCity().getNm() : null);
				model.setStateName(entity.getTbOsState() != null ? entity.getTbOsState().getNm() : null);
				model.setCountryName(entity.getTbOsCountry() != null ? entity.getTbOsCountry().getName() : null);
				model.setAddrType(entity.getAddrType() != null ? entity.getAddrType() : null);
				model.setCrtTs(entity.getCrtTs() != null ? entity.getCrtTs() : null);
				model.setCrtBy(entity.getCrtBy() != null ? entity.getCrtBy() : null);
				model.setUpdBy(entity.getUpdBy() != null ? entity.getUpdBy() : null);
				model.setUpdBy(entity.getUpdTs() != null ? entity.getUpdBy() : null);
				model.setCrtTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getCrtTs(),CommonConstant.dateFormate.DD_MMM_YYYY_HHMMSS_SSS_A));
				model.setUpdTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getUpdTs(), CommonConstant.dateFormate.DD_MMM_YYYY_HHMMSS_SSS_A));
				
				response.add(model);
			}
			
			return response;
		}
		
		// Add or Update Address
		public TbOsAdrsModel addOrUpdateAddress(TbOsAdrsModel model)
		{
			try
			{
				Long id = model.getId();
				if(id != null)
				{
					Optional<TbOsAdrssEntity> data = tbOsAdrsPersistance.findById(id);
					if(data.isPresent())
					{
						TbOsAdrssEntity entity  = data.get();
						
						entity.setId(model.getId() != null ? model.getId() : entity.getId());
						setModelToEntity(model, entity);
						entity.setUpdBy("SYSTEM");
					   	entity.setUpdTs(new Date());
						
					}
				}
				else
				{
					TbOsAdrssEntity entity = new TbOsAdrssEntity();
					
						entity.setId(null);
						setModelToEntity(model, entity);
					    entity.setCrtTs(new Date());
					    entity.setCrtBy("SYSTEM");
					    	
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception occure inside add or Update Address sevice Methods "+e);
			}
			
			
			return model;
		}
		
		private void setModelToEntity(TbOsAdrsModel model, TbOsAdrssEntity entity)
		{
			entity.setHouseNo(model.getHouseNo() != null ? model.getHouseNo() : entity.getHouseNo());
			entity.setStreeNo(model.getStreeNo() != null ? model.getStreeNo() : entity.getStreeNo());
			
			Long cid = entity.getTbOsColony().getId();
			entity.setTbOsColony(tbOsColonyPersistance.findById(cid).get());
			
			Long deId = entity.getTbOsDeleg().getId();
			entity.setTbOsDeleg(tbOsDelePersistance.findById(deId).get());
			
		    Long ctId = entity.getTbOsCity().getId();
		    entity.setTbOsCity(tbOsCityPersistance.findById(ctId).get());
		    
		    Long sId = entity.getTbOsState().getId();
		    entity.setTbOsState(tbOsStatePersistance.findById(sId).get());
		    
		    Long coId = entity.getTbOsCountry().getId();
		    entity.setTbOsCountry(tbOsCountryPersistance.findById(coId).get());
		    
		    Long pId = entity.getTbOsPostal().getId();
		    entity.setTbOsPostal(tbOsPostalPersistance.findById(pId).get());
		    
		    entity.setAddrType(model.getAddrType() != null ? model.getAddrType() : entity.getAddrType());
	
		}


}
