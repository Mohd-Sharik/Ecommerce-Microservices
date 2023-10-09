package com.ecom.payments.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ecom.payments.entities.TbOsPaymentsEntity;
import com.ecom.payments.models.TbOSPaymentsModel;
import com.ecom.payments.persistance.TbOsPaymentsPersistance;
import com.onlineShop.example.commonModel.DatabaseOperationResult;
import com.onlineShop.example.commonModel.PaginationAttribute;
import com.onlineShop.example.commonModel.ServiceOperationResult;
import com.onlineShop.example.commonUtilMethods.CommonConstant;
import com.onlineShop.example.commonUtilMethods.CommonUtilityHelper;
import com.onlineShop.example.commonUtilMethods.FilterParameter;
import com.onlineShop.example.commonUtilMethods.FilterUtil;
import com.onlineShop.example.commonUtilMethods.SearchCriteria;
import com.onlineShop.example.commonUtilMethods.SearchOperation;
import com.onlineShop.example.exception.BusinessException;
import com.onlineShop.example.exception.DatabaseException;

@Service
public class TbOsPamentsService {
	
	
	@Autowired
	private TbOsPaymentsPersistance tbOsPaymentsPersistance;
	
	
	
	public ServiceOperationResult<List<TbOSPaymentsModel>> getAll(FilterParameter filter)
	{
		ServiceOperationResult<List<TbOSPaymentsModel>> response = new ServiceOperationResult<List<TbOSPaymentsModel>>();
		
		try
		{
			DatabaseOperationResult<List<TbOsPaymentsEntity>> dbOpList = getpamentDatafromDb(filter);
			List<TbOSPaymentsModel> list  = new ArrayList<TbOSPaymentsModel>();
			for(TbOsPaymentsEntity entity : dbOpList.getModelOrEntity())
			{
				TbOSPaymentsModel model = new TbOSPaymentsModel();
				
				model.setId(entity.getId());
				model.setOrderId(entity.getOrderId());
				model.setPaymentMode(entity.getPaymentMode());
				model.setReferenceNumber(entity.getReferenceNumber());
				model.setPaymentStatus(entity.getPaymentStatus());
				model.setAmont(entity.getAmont());
				model.setCrtTs(entity.getCrtTs());
				model.setCrtBy(entity.getCrtBy());
				model.setCrtTsString(CommonUtilityHelper.DateUtil.getStringFromDate(entity.getCrtTs(), CommonConstant.DateFormat.DD_MMM_YYYY_HHMMSS));
				
				list.add(model);
				
			}
			response.setPageAttribute(dbOpList.getPageAttribute());
			response.setResponse(list);
		}
		catch(DatabaseException ex)
		{
			throw new BusinessException(ex);
		}
		
		return response;
	}
	
	//getPaymentDataFromDb
	public DatabaseOperationResult<List<TbOsPaymentsEntity>> getpamentDatafromDb(FilterParameter filter)
	{
		DatabaseOperationResult<List<TbOsPaymentsEntity>> dbopList = new DatabaseOperationResult<List<TbOsPaymentsEntity>>();
		List<TbOsPaymentsEntity> modelOrEntity = new ArrayList<TbOsPaymentsEntity>();
		
		//pagination
		Integer showRecordOnOnePage = filter.getRecordToShowOnOnePage() == null ? CommonConstant.REC_PER_PG : filter.getRecordToShowOnOnePage();
		Integer from = filter.getPageIndex();
		Integer to = filter.getRecordToShowOnOnePage();
		Long totalReccord = filter.getRecordTotal();
		
		// use filters for find the result
		 
		String id = filter.getId();
		String orderId = filter.getOrderId();
		String mode = filter.getPaymentMode();
		String refNum = filter.getReferenceNumber();
		String PStatus = filter.getPaymentStatus();
		
		
		List<SearchCriteria> list = new ArrayList<SearchCriteria>();
		
		if(StringUtils.isNoneBlank(id))
		{
			list.add(new SearchCriteria("id", id, SearchOperation.EQUAL));
		}
		
		if(StringUtils.isNoneBlank(orderId))
		{
			list.add(new SearchCriteria(orderId, orderId, SearchOperation.MATCH));
		}
		
		if(StringUtils.isNoneBlank(mode))
		{
			list.add(new SearchCriteria("paymentMode", mode, SearchOperation.MATCH));
		}
		
		if(StringUtils.isNotBlank(refNum))
		{
			list.add(new SearchCriteria("referenceNumber", refNum, SearchOperation.MATCH));
		}
		
		if(StringUtils.isNoneBlank(PStatus))
		{
			list.add(new SearchCriteria("paymentStatus", PStatus, SearchOperation.MATCH));
		}
		
		
		FilterUtil<TbOsPaymentsEntity> filterUtil = new FilterUtil<>();
		if(totalReccord == null)
		{
			totalReccord = tbOsPaymentsPersistance.count(filterUtil.getSpecification(list));
		}
		
		if(from != null && to != null)
		{
			Pageable page = PageRequest.of(from, to,Sort.by(Sort.Direction.DESC, "id"));
			
			modelOrEntity = tbOsPaymentsPersistance.findAll(filterUtil.getSpecification(list), page);
			
		}
		
		
		PaginationAttribute pagAttr = dbopList.getPageAttribute();
		pagAttr.setPageIndex(filter.getPageIndex());
		pagAttr.setTotalRecords(totalReccord);
		pagAttr.setShowRecordOnOnePage(showRecordOnOnePage);
		pagAttr.setFetchrecords(modelOrEntity.size());
		pagAttr.setTotalPages((int)Math.ceil(totalReccord.intValue() * 1.0 / showRecordOnOnePage));
		
		dbopList.setPageAttribute(pagAttr);
		
		return dbopList;
	}

}
