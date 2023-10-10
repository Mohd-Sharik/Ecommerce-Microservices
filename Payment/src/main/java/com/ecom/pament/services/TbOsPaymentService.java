package com.ecom.pament.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ecom.pament.entities.TbOsPaymentEntity;
import com.ecom.pament.models.TbOSPaymentModel;
import com.ecom.pament.persistance.TbOsPaymentPersistance;
//import com.ecom.payments.entities.TbOsPaymentsEntity;
//import com.ecom.payments.models.TbOSPaymentsModel;
import com.onlineShop.example.commonModel.DatabaseOperationResult;
import com.onlineShop.example.commonModel.ErrorParameter;
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
public class TbOsPaymentService {
	
	
	@Autowired
	TbOsPaymentPersistance tbOsPaymentPersistance;
	
	

	//find by orderId
	public ServiceOperationResult<TbOSPaymentModel> findByOrderId(TbOSPaymentModel model)
	{
		ServiceOperationResult<TbOSPaymentModel> response = new ServiceOperationResult<TbOSPaymentModel>();
		try
		{
			Long id = model.getOrderId();
			if(id == null)
			{
				ErrorParameter err = new ErrorParameter();
				err.setErrCode("404");
				err.setErrDesc("orderId must no be null :");
				response.setErrParam(err);
				response.setSucces(false);
				return response;
			}
			
			Optional<TbOsPaymentEntity> ent = tbOsPaymentPersistance.findByOrderId(id);
			if(ent.isPresent())
			{
				TbOsPaymentEntity entity = ent.get();
				
				model.setId(model.getId() != null ? model.getId() : entity.getId());
				model.setOrderId(model.getOrderId() != null ? model.getOrderId() : entity.getOrderId());
				model.setPaymentMode(model.getPaymentMode() != null ? model.getPaymentMode() : entity.getPaymentMode());
				model.setReferenceNumber(model.getReferenceNumber() != null ? model.getReferenceNumber() : entity.getReferenceNumber());
				model.setPaymentStatus(model.getPaymentStatus() != null ? model.getPaymentStatus() : entity.getPaymentStatus());
				model.setAmont(model.getAmont() != null ? model.getAmont() : entity.getAmont());
				model.setCrtTs(model.getCrtTs() != null ? model.getCrtTs() : entity.getCrtTs());
				model.setCrtBy(model.getCrtBy() != null ? model.getCrtBy() : entity.getCrtBy());
				
			}
			
			response.setResponse(model);
		}
		catch(DatabaseException ex)
		{
			throw new BusinessException(ex);
		}
		return response;
	}
	
	
	// do payment
	public ServiceOperationResult<TbOSPaymentModel> doPayment(TbOSPaymentModel model)
	{
		ServiceOperationResult<TbOSPaymentModel> response = new ServiceOperationResult<TbOSPaymentModel>();
		
		try
		{
			TbOsPaymentEntity entity = new TbOsPaymentEntity();
			
			entity.setId(null);
			entity.setOrderId(model.getOrderId() != null ? model.getOrderId() : null);
			entity.setPaymentMode(model.getPaymentMode() != null ? model.getPaymentMode() : null);
			entity.setReferenceNumber(model.getReferenceNumber() != null ? model.getReferenceNumber() : null); 
			entity.setPaymentStatus(model.getPaymentStatus() != null ? model.getPaymentStatus() : null);
			entity.setAmont(model.getAmont() != null ? model.getAmont() : null);
			entity.setCrtTs(new Date());
			entity.setCrtBy(CommonConstant.SCRIPT_USER);
			
			tbOsPaymentPersistance.save(entity);
			response.setResponse(model);
			
		}
		catch(DatabaseException ex)
		{
			throw new BusinessException(ex);
		}
		return response;
	}
	
	
	
	
	//get All
	public ServiceOperationResult<List<TbOSPaymentModel>> getAll(FilterParameter filter)
	{
		ServiceOperationResult<List<TbOSPaymentModel>> response = new ServiceOperationResult<List<TbOSPaymentModel>>();
		
		try
		{
			DatabaseOperationResult<List<TbOsPaymentEntity>> dbOpList = getpamentDatafromDb(filter);
			List<TbOSPaymentModel> list  = new ArrayList<TbOSPaymentModel>();
			for(TbOsPaymentEntity entity : dbOpList.getModelOrEntity())
			{
				TbOSPaymentModel model = new TbOSPaymentModel();
				
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
	public DatabaseOperationResult<List<TbOsPaymentEntity>> getpamentDatafromDb(FilterParameter filter)
	{
		DatabaseOperationResult<List<TbOsPaymentEntity>> dbopList = new DatabaseOperationResult<List<TbOsPaymentEntity>>();
		List<TbOsPaymentEntity> modelOrEntity = new ArrayList<TbOsPaymentEntity>();
		
		//pagination
		Integer showRecordOnOnePage = filter.getRecordToShowOnOnePage() == null ? CommonConstant.REC_PER_PG : filter.getRecordToShowOnOnePage();
		Integer from = filter.getPageIndex();
		Integer to = filter.getRecordToShowOnOnePage();
		Long totalReccord = filter.getRecordTotal();
		
		// use filters for find the result
		 
		String id = filter.getId();
		
		String mode = filter.getPaymentMode();
		String refNum = filter.getReferenceNumber();
		String PStatus = filter.getPaymentStatus();
		//String orderId = filter.getOrderId();
		
		
		List<SearchCriteria> list = new ArrayList<SearchCriteria>();
		
		if(StringUtils.isNoneBlank(id))
		{
			list.add(new SearchCriteria("id", id, SearchOperation.EQUAL));
		}
		
//		if(StringUtils.isNoneBlank(orderId))
//		{
//			list.add(new SearchCriteria("orderId", orderId, SearchOperation.MATCH));
//		}
		
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
		
		
		FilterUtil<TbOsPaymentEntity> filterUtil = new FilterUtil<>();
		if(totalReccord == null)
		{
			totalReccord = tbOsPaymentPersistance.count(filterUtil.getSpecification(list));
		}
		
		if(from != null && to != null)
		{
			Pageable page = PageRequest.of(from, to,Sort.by(Sort.Direction.DESC, "id"));
			
			modelOrEntity = tbOsPaymentPersistance.findAll(filterUtil.getSpecification(list), page);
			
		}
		
		
		PaginationAttribute pagAttr = dbopList.getPageAttribute();
		pagAttr.setPageIndex(filter.getPageIndex());
		pagAttr.setTotalRecords(totalReccord);
		pagAttr.setShowRecordOnOnePage(showRecordOnOnePage);
		pagAttr.setFetchrecords(modelOrEntity.size());
		pagAttr.setTotalPages((int)Math.ceil(totalReccord.intValue() * 1.0 / showRecordOnOnePage));
		dbopList.setModelOrEntity(modelOrEntity);
		
		return dbopList;
	}


}
