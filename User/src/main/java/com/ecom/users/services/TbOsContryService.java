package com.ecom.users.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.users.commonUtil.CommonConstant;
import com.ecom.users.commonUtil.CommonUtilityHelper;
import com.ecom.users.entites.TbOsCountryEntity;
import com.ecom.users.models.TbOsContryModdel;
import com.ecom.users.persistance.TbOsCountryPersistance;

@Service
public class TbOsContryService {
	
	
	
	
	@Autowired
	private TbOsCountryPersistance tbOsCountryPersistance;
	
	
	
	public List<TbOsContryModdel>  getAll()
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

}
