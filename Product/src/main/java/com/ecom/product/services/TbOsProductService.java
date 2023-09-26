package com.ecom.product.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.product.Persistance.TbOSCatagoryPersistance;
import com.ecom.product.entities.TbOsCatagoryEntity;
import com.ecom.product.models.TbOsCatagoryModel;
import com.ecom.product.utility.CommonConstant;
import com.ecom.product.utility.CommonUtilityHelper;

@Service
public class TbOsProductService {
	
	
	@Autowired
	private TbOSCatagoryPersistance tbOSCatagoryPersistance;
	
	
	
	//get All record of Catagory
	public List<TbOsCatagoryModel> getAll()
	{
		List<TbOsCatagoryModel> response = new ArrayList<TbOsCatagoryModel>();
		
		List<TbOsCatagoryEntity> entities = tbOSCatagoryPersistance.findAll();
		for(TbOsCatagoryEntity entity : entities)
		{
			TbOsCatagoryModel model = new TbOsCatagoryModel();
			
			model.setId(entity.getId() != null ? entity.getId() : null);
			model.setBrandName(entity.getBrandName() != null ? entity.getBrandName() : null);
			model.setDescr(entity.getDescr() != null ? entity.getDescr() : null);
			model.setCrtTs(entity.getCrtTs() != null ? entity.getCrtTs() : null);
			model.setCrtBy(entity.getCrtBy() != null ? entity.getCrtBy() : null);
			model.setUpdTs(entity.getUpdTs() != null ? entity.getUpdTs() : null);
			model.setUpdBy(entity.getUpdBy() != null ? entity.getUpdBy() : null);
			model.setDltTs(entity.getDltTs() != null ? entity.getDltTs() : null);
			model.setDltBy(entity.getDltBy() != null ? entity.getDltBy() : null);
			
			model.setCrtTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getCrtTs(),CommonConstant.dateFormate.DD_MMM_YYYY_HHMMSS_SSS_A));
			model.setUpdTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getUpdTs(), CommonConstant.dateFormate.DD_MMM_YYYY_HHMMSS_SSS_A));
			model.setDltTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getDltTs(), CommonConstant.dateFormate.DD_MMM_YYYY_HHMMSS_SSS_A));
			
			response.add(model);
		}
		
		
		return response;
	}

}
