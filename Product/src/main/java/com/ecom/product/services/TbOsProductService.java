package com.ecom.product.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ctc.wstx.util.StringUtil;
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
import com.ecom.product.utility.CommonUtilityHelper;
import com.onlineShop.example.commonModel.DatabaseOperationResult;
import com.onlineShop.example.commonModel.PaginationAttribute;
import com.onlineShop.example.commonModel.ServiceOperationResult;
import com.onlineShop.example.commonUtilMethods.CommonConstant;
import com.onlineShop.example.commonUtilMethods.FilterParameter;
import com.onlineShop.example.commonUtilMethods.FilterUtil;
import com.onlineShop.example.commonUtilMethods.SearchCriteria;
import com.onlineShop.example.commonUtilMethods.SearchOperation;
import com.onlineShop.example.exception.BusinessException;
import com.onlineShop.example.exception.DatabaseException;

import ch.qos.logback.core.util.StringCollectionUtil;

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
	public ServiceOperationResult<List<TbOsCatagoryModel>> getAllCatagory(FilterParameter filter)
	{
		ServiceOperationResult<List<TbOsCatagoryModel>> response = new ServiceOperationResult<List<TbOsCatagoryModel>>();
		try
		{
			List<TbOsCatagoryModel> list = new ArrayList<TbOsCatagoryModel>();
			
			DatabaseOperationResult<List<TbOsCatagoryEntity>> entities = findCatagoryonDb(filter);
			for(TbOsCatagoryEntity entity : entities.getModelOrEntity())
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
				
				model.setCrtTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getCrtTs(),CommonConstant.DateFormat.DD_MMM_YYYY_HHMMSS_SSS_A));
				model.setUpdTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getUpdTs(), CommonConstant.DateFormat.DD_MMM_YYYY_HHMMSS_SSS_A));
				model.setDltTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getDltTs(), CommonConstant.DateFormat.DD_MMM_YYYY_HHMMSS_SSS_A));
			
				list.add(model);
			}
			response.setPageAttribute(entities.getPageAttribute());
			response.setResponse(list);
		}
		catch(DatabaseException e)
		{
			throw new BusinessException(e);
		}
		return response;
	}
	
	//get catagory from db
	public DatabaseOperationResult<List<TbOsCatagoryEntity>> findCatagoryonDb(FilterParameter filter)
	{
		DatabaseOperationResult<List<TbOsCatagoryEntity>> dbOList = new DatabaseOperationResult<List<TbOsCatagoryEntity>>();
		
		List<TbOsCatagoryEntity> dList = new ArrayList<TbOsCatagoryEntity>();
		
		//calculate pagination
		Integer recordShowOnOnePage = filter.getRecordToShowOnOnePage() != null ? filter.getRecordToShowOnOnePage() : CommonConstant.REC_PER_PG;
		Integer from = filter.getPageIndex();
		Integer to = recordShowOnOnePage;
		Long recordTotal = filter.getRecordTotal();
		
		//filter use
		String id = filter.getId();
		String brandName = filter.getBrandName();
		
		
		List<SearchCriteria> list = new ArrayList<SearchCriteria>();
		
		if(StringUtils.isNotBlank(id))
		{
			list.add(new SearchCriteria("id", id, SearchOperation.EQUAL));
		}
		
		if(StringUtils.isNotBlank(brandName))
		{
			list.add(new SearchCriteria("brandName", brandName, SearchOperation.MATCH));
		}
		
		FilterUtil<TbOsCatagoryEntity> filterUtil = new FilterUtil<>();
		
		if(recordTotal == null)
		{
			recordTotal = tbOSCatagoryPersistance.count(filterUtil.getSpecification(list));
		}
		
		if(from != null && to != null)
		{
			Pageable page = PageRequest.of(from, to,Sort.by(Sort.Direction.ASC, "id"));
			dList = tbOSCatagoryPersistance.findAll(filterUtil.getSpecification(list), page);
		}
		
		
		PaginationAttribute pagAttr = dbOList.getPageAttribute();
		pagAttr.setPageIndex(filter.getPageIndex());
		pagAttr.setTotalPages((int)Math.ceil(recordTotal.intValue() * 1.0 / recordShowOnOnePage));
		pagAttr.setFetchrecords(dList.size());
		pagAttr.setShowRecordOnOnePage(recordShowOnOnePage);
		pagAttr.setTotalRecords(recordTotal);
		dbOList.setModelOrEntity(dList);
		
		return dbOList;
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
			
			model.setCrtTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getCrtTs(), CommonConstant.DateFormat.DD_MMM_YYYY_HHMMSS_SSS_A));
			model.setUpdTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getUpdTs(), CommonConstant.DateFormat.DD_MMM_YYYY_HHMMSS_SSS_A));
			model.setDltTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getDltTs(), CommonConstant.DateFormat.DD_MMM_YYYY_HHMMSS_SSS_A));
			
			response.add(model);
		}
		
		return response;
	}
	
	//product List
	public ServiceOperationResult<List<TbOSProductModel>> getAllProduct(FilterParameter filter)
	{
		
		ServiceOperationResult<List<TbOSProductModel>> response = new ServiceOperationResult<List<TbOSProductModel>>();
		try
		{
			List<TbOSProductModel> list = new ArrayList<TbOSProductModel>();
			
			DatabaseOperationResult<List<TbOsProductEntity>> entities = getProductFromDb(filter);
			for(TbOsProductEntity entity : entities.getModelOrEntity())
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
				
				model.setCrtTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getCrtTs(), CommonConstant.DateFormat.DD_MMM_YYYY_HHMMSS_SSS_A));
				model.setUpdTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getUpdTs(), CommonConstant.DateFormat.DD_MMM_YYYY_HHMMSS_SSS_A));
				model.setDltTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getDltTs(), CommonConstant.DateFormat.DD_MMM_YYYY_HHMMSS_SSS_A));
				
				List<TbRpMRatingModel> reting  = ratingService.findByProductId(entity.getId());
				model.setRatings(reting);
				
				list.add(model);
			}
			
			response.setPageAttribute(entities.getPageAttribute());
			response.setResponse(list);
		}
		catch(DatabaseException ex)
		{
			throw new BusinessException(ex);
		}
		
		return response;
	}
	
	//getProduct from DB
	public DatabaseOperationResult<List<TbOsProductEntity>> getProductFromDb(FilterParameter filter)
	{
		DatabaseOperationResult<List<TbOsProductEntity>> dbOpList = new DatabaseOperationResult<List<TbOsProductEntity>>();
		
		List<TbOsProductEntity> modelOrEntity = new ArrayList<TbOsProductEntity>();
		
		//pagination
		Integer recordToShowOnOnePage = filter.getRecordToShowOnOnePage() == null ? CommonConstant.REC_PER_PG : filter.getRecordToShowOnOnePage();
		Integer from = filter.getPageIndex();
		Integer to = recordToShowOnOnePage;
		Long totalRecord = filter.getRecordTotal();
		
		//filters
		String id = filter.getId();
		String pname = filter.getName();
		String price = filter.getPrice();
		String cName = filter.getName();
		String cId = filter.getAplId();
		
		
		List<SearchCriteria> list = new ArrayList<SearchCriteria>();
		
		
		if(StringUtils.isNotBlank(id))
		{
			list.add(new SearchCriteria("id", id, SearchOperation.EQUAL));
		}
		
		if(StringUtils.isNotBlank(pname))
		{
			list.add(new SearchCriteria("productName", pname, SearchOperation.MATCH));
		}
		
		if(StringUtils.isNotBlank(price))
		{
			list.add(new SearchCriteria("price", price, SearchOperation.MATCH));
		}

		if(StringUtils.isNotBlank(cId))
		{
			list.add(new SearchCriteria("tbOsCatagoryEntity", "id", cId, SearchOperation.COMPOSITE));
		}
		
		if(StringUtils.isNotBlank(cName))
		{
			list.add(new SearchCriteria("tbOsCatagoryEntity", "brandName", cName, SearchOperation.COMPOSITE));
		}
		
		FilterUtil<TbOsProductEntity> filterUtil = new FilterUtil<TbOsProductEntity>();
		
		if(totalRecord == null)
		{
			totalRecord = tbOsProductPersistance.Count(filterUtil.getSpecification(list));
		}
		
		if(from != null && to != null)
		{
			Pageable page = PageRequest.of(from, to, Sort.by(Sort.Direction.DESC,"id"));
			modelOrEntity = tbOsProductPersistance.findAll(filterUtil.getSpecification(list), page);
			
		}
		
		
		PaginationAttribute pagAttr = dbOpList.getPageAttribute();
		pagAttr.setPageIndex(filter.getPageIndex());
		pagAttr.setTotalPages((int)Math.ceil(totalRecord.intValue() * 1.0 / recordToShowOnOnePage));
		pagAttr.setFetchrecords(modelOrEntity.size());
		pagAttr.setShowRecordOnOnePage(recordToShowOnOnePage);
		pagAttr.setTotalRecords(totalRecord);
		dbOpList.setModelOrEntity(modelOrEntity);
		
		return dbOpList;
	}

}
