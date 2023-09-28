package com.ecom.product.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.product.Persistance.TbOSCatagoryPersistance;
import com.ecom.product.Persistance.TbOsInventoryPersistance;
import com.ecom.product.Persistance.TbOsProductPersistance;
import com.ecom.product.entities.TbOSInventoryEntity;
import com.ecom.product.entities.TbOsCatagoryEntity;
import com.ecom.product.entities.TbOsProductEntity;
import com.ecom.product.externalService.RatingService;
import com.ecom.product.models.TbOSProductModel;
import com.ecom.product.models.TbOsCatagoryModel;
import com.ecom.product.models.TbOsInvntoryModel;
import com.ecom.product.models.TbRpMRatingModel;
import com.ecom.product.utility.CommonConstant;
import com.ecom.product.utility.CommonUtilityHelper;

@Service
public class TbOsProductService {
	
	
	@Autowired
	private TbOSCatagoryPersistance tbOSCatagoryPersistance;
	@Autowired
	private TbOsInventoryPersistance tbOsInventoryPersistance;
	@Autowired
	private TbOsProductPersistance tbOsProductPersistance;
	@Autowired
	private RatingService ratingService;
	
	
	
	//get All record of Catagory
	public List<TbOsCatagoryModel> getAllCatagory()
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
	
	// get all record of Inventory
	public List<TbOsInvntoryModel> getAllInventory()
	{
		List<TbOsInvntoryModel> response = new ArrayList<TbOsInvntoryModel>();
		List<TbOSInventoryEntity> entities = tbOsInventoryPersistance.findAll();
		for(TbOSInventoryEntity entity : entities)
		{
			TbOsInvntoryModel model = new TbOsInvntoryModel();
			
			model.setId(entity.getId() != null ? entity.getId() : null);
			model.setQuantity(entity.getQuantity() != null ? entity.getQuantity() : null);
			model.setCrtTs(entity.getCrtTs() != null ? entity.getCrtTs() : null);
			model.setCrtBy(entity.getCrtBy() != null ? entity.getCrtBy() : null);
			model.setUpdTs(entity.getUpdTs() != null ? entity.getUpdTs() : null);
			model.setUpdBy(entity.getUpdBy() != null ? entity.getUpdBy() : null);
			model.setDeltTs(entity.getDltTs() != null ? entity.getDltTs() :  null);
			model.setDeltBy(entity.getDltBy() != null ? entity.getDltBy() : null);
			
			model.setCrtTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getCrtTs(), CommonConstant.dateFormate.DD_MMM_YYYY_HHMMSS_SSS_A));
			model.setUpdTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getUpdTs(), CommonConstant.dateFormate.DD_MMM_YYYY_HHMMSS_SSS_A));
			model.setDltTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getDltTs(), CommonConstant.dateFormate.DD_MMM_YYYY_HHMMSS_SSS_A));
			
			response.add(model);
		}
		
		return response;
	}
	
	//product List
	public List<TbOSProductModel> getAllProduct()
	{
		List<TbOSProductModel> response = new ArrayList<TbOSProductModel>();
		List<TbOsProductEntity> entities = tbOsProductPersistance.findAll();
		
		for(TbOsProductEntity entity : entities)
		{
			TbOSProductModel model = new TbOSProductModel();
			
			model.setId(entity.getId() != null ? entity.getId() : null);
			model.setProductName(entity.getProductName() != null ? entity.getProductName() : null);
			model.setDescr(entity.getDesr() != null ? entity.getDesr() : null);
			model.setPrice(entity.getPrice() != null ? entity.getPrice() : null);
			model.setCatagoryName(entity.getTbOsCatagoryEntity() != null ? entity.getTbOsCatagoryEntity().getBrandName() : null);
			model.setCatagoryDescr(entity.getTbOsCatagoryEntity() != null ? entity.getTbOsCatagoryEntity().getDescr() : null);
			model.setQuantity(entity.getTbOSInventoryEntity() != null ? entity.getTbOSInventoryEntity().getQuantity() : null);
			model.setDiscountId(entity.getDiscountId() != null ? entity.getDiscountId() : null);
			model.setMaterial(entity.getMaterial() != null ? entity.getMaterial() : null);
			model.setBrand(entity.getBrand() != null ? entity.getBrand() : null);
			model.setColor(entity.getColor() != null ? entity.getColor() : null);
			model.setStyle(entity.getStyle() != null ? entity.getStyle() : null);
			model.setCrtTs(entity.getCrtTs() != null ? entity.getCrtTs() : null);
			model.setCrtBy(entity.getCrtBy() != null ? entity.getCrtBy() : null);
			model.setUpdTs(entity.getUpdTs() != null ? entity.getUpdTs() : null);
			model.setUpdBy(entity.getUpdBy() != null ? entity.getUpdBy() : null);
			model.setDeltTs(entity.getDltTs() != null ? entity.getDltTs() : null);
			model.setDeltBy(entity.getDltBy() != null ? entity.getDltBy() : null);
			
			model.setCrtTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getCrtTs(), CommonConstant.dateFormate.DD_MMM_YYYY_HHMMSS_SSS_A));
			model.setUpdTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getUpdTs(), CommonConstant.dateFormate.DD_MMM_YYYY_HHMMSS_SSS_A));
			model.setDltTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getDltTs(), CommonConstant.dateFormate.DD_MMM_YYYY_HHMMSS_SSS_A));
			
			List<TbRpMRatingModel> reting  = ratingService.findByProductId(entity.getId());
			model.setRatings(reting);
			
			response.add(model);
		}
		
		return response;
	}

}
