package com.ecom.users.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		
		// get
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


}
