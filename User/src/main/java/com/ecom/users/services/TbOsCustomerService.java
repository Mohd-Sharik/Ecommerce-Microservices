package com.ecom.users.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ecom.users.commonUtil.SecurityHelper.MessageDiagestUtil;
import com.ecom.users.commonUtil.UtilityHelper;
import com.ecom.users.entites.TbOsCustomerEntity;
import com.ecom.users.externalService.RatingService;
import com.ecom.users.models.TbOsCustomerModel;
import com.ecom.users.models.TbRpMRatingModel;
import com.ecom.users.persistance.TbOsCustmerPersistance;
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
public class TbOsCustomerService {
	
	
	Logger logger = LoggerFactory.getLogger(TbOsCustomerService.class);
	
	
	@Autowired
	TbOsCustmerPersistance tbOsCustmerPersistance;
	@Autowired
	RatingService ratingService;
	
	
	
	
	// get all User
	public ServiceOperationResult<List<TbOsCustomerModel>> getAllCustomer(FilterParameter filter)
	{
		ServiceOperationResult<List<TbOsCustomerModel>> response = new ServiceOperationResult<List<TbOsCustomerModel>>();
		
		List<TbOsCustomerModel> list = new ArrayList<TbOsCustomerModel>();
		
		try
		{
			DatabaseOperationResult<List<TbOsCustomerEntity>> entities = getCustomerDataFromDataBase(filter);//List<TbOsCustomerEntity> entities = tbOsCustmerPersistance.findAll();
			for(TbOsCustomerEntity entity : entities.getModelOrEntity())
			{
				TbOsCustomerModel model = new TbOsCustomerModel();
				
				
				 model.setId(entity.getId() != null ? entity.getId() : null);
				 model.setRefId(entity.getRefId() != null ? entity.getRefId() : null);
				// model.setPswd(entity.getPswd() != null ? entity.getPswd() : null);
				 model.setFullName(entity.getFullName() != null ? entity.getFullName() : null);
				 model.setDislayName(entity.getDislayName() != null ? entity.getDislayName() :null);
				 model.setEmail(entity.getEmail() != null ? entity.getEmail() : null);
				 model.setContactInfo(entity.getContactInfo() != null ? entity.getContactInfo() : null);
				 model.setContactNumber(entity.getContactNumber() != null ? entity.getContactNumber() : null);
				 model.setDsgn(entity.getDsgn() != null ? entity.getDsgn() : null);
				 model.setLocation(entity.getLocation() != null ? entity.getLocation() : null);
				 model.setFldLgnCnt(entity.getFldLgnCnt() != null ? entity.getFldLgnCnt() : null);
				 model.setExprTs(entity.getExprTs() != null ? entity.getExprTs() : null);
				 model.setPswdCrtBy(entity.getPswdCrtBy() != null ? entity.getPswdCrtBy() : null);
				 model.setHouseNo(entity.getTbOsAdrss() != null ? entity.getTbOsAdrss().getHouseNo() : null);
				 model.setStreeNo(entity.getTbOsAdrss() != null ? entity.getTbOsAdrss().getStreeNo() : null);
				 model.setColonyName(entity.getTbOsAdrss() != null ? entity.getTbOsAdrss().getTbOsColony().getNm() : null);
				 model.setPostalName(entity.getTbOsAdrss() != null ? entity.getTbOsAdrss().getTbOsPostal().getNm() : null);
				 model.setPostalCode(entity.getTbOsAdrss() != null ? entity.getTbOsAdrss().getTbOsPostal().getCd() : null);
				 model.setDeleName(entity.getTbOsAdrss() != null ? entity.getTbOsAdrss().getTbOsDeleg().getNm() : null);
				 model.setCityName(entity.getTbOsAdrss() != null ? entity.getTbOsAdrss().getTbOsCity().getNm() : null);
				 model.setStateName(entity.getTbOsAdrss() != null ? entity.getTbOsAdrss().getTbOsState().getNm() : null);
				 model.setCountryName(entity.getTbOsAdrss() != null ? entity.getTbOsAdrss().getTbOsCountry().getName() : null);
				 model.setAddrType(entity.getTbOsAdrss() != null ? entity.getTbOsAdrss().getAddrType() : null);
				 model.setUserState(entity.getUserState() != null ? entity.getUserState() : null);
				 model.setSessionId(entity.getSessionId() != null ? entity.getSessionId() : null);
				 model.setLdaAuth(entity.getLdaAuth() != null ? entity.getLdaAuth() : null);
				 model.setSkipInactie(entity.getSkipInactie() != null ? entity.getSkipInactie() : null);
				 model.setCrtTs(entity.getCrtTs() != null ? entity.getCrtTs() : null);
				 model.setCrtBy(entity.getCrtBy() != null ? entity.getCrtBy() : null);
				 model.setUpdBy(entity.getUpdBy() != null ? entity.getUpdBy() : null);
				 model.setUpdBy(entity.getUpdTs() != null ? entity.getUpdBy() : null); 
				 model.setDltTs(entity.getDltTs() != null ? entity.getDltTs() : null);
				 model.setDltBy(entity.getDltBy() != null ? entity.getDltBy() : null); 
				 model.setCrtTsString(UtilityHelper.Dateutil.getStringFormatDate(entity.getCrtTs(),CommonConstant.DateFormat.DD_MMM_YYYY_HHMMSS_SSS_A));
				 model.setUpdTsString(UtilityHelper.Dateutil.getStringFormatDate(entity.getUpdTs(), CommonConstant.DateFormat.DD_MMM_YYYY_HHMMSS_SSS_A));
				 model.setDltTsString(UtilityHelper.Dateutil.getStringFormatDate(entity.getDltTs(), CommonConstant.DateFormat.DD_MMM_YYYY_HHMMSS_SSS_A));
				
				 List<TbRpMRatingModel> ratings =   ratingService.findRatingByUserId(entity.getId());				
				 model.setRatings(ratings);
				 
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
	
	//extract Data from Database for user with filter
	private DatabaseOperationResult<List<TbOsCustomerEntity>> getCustomerDataFromDataBase(FilterParameter filter)
	{
		DatabaseOperationResult<List<TbOsCustomerEntity>>  dbList = new DatabaseOperationResult<>();
		
		List<TbOsCustomerEntity> modelOrEntity = new ArrayList<TbOsCustomerEntity>();
		
		
		//pagination
		Integer showRecordOnOnePage = filter.getRecordToShowOnOnePage() != null ? filter.getRecordToShowOnOnePage()
				: CommonConstant.REC_PER_PG;
		Integer from = filter.getPageIndex();
		Integer to = showRecordOnOnePage;
		Long totalRecord = filter.getRecordTotal();

		// business Logic
		List<SearchCriteria> list = new ArrayList<>();
		SearchCriteria sc = new SearchCriteria();

		String id = filter.getId();
		String fullNm = filter.getFullNm();
		String dsplNm = filter.getDsplNm();
		String cntctNumber = filter.getContactNumber();

		if (StringUtils.isNotBlank(id)) {
			sc = new SearchCriteria("id", id, SearchOperation.EQUAL);
			list.add(sc);
		}

		if (StringUtils.isNotBlank(fullNm)) {
			sc = new SearchCriteria("fullNm", fullNm, SearchOperation.MATCH);
			list.add(sc);
		}

		if (StringUtils.isNotBlank(dsplNm)) {
			sc = new SearchCriteria("dsplNm", dsplNm, SearchOperation.MATCH);
			list.add(sc);
		}

		if (StringUtils.isNotBlank(cntctNumber)) {
			sc = new SearchCriteria("cntctNumber", cntctNumber, SearchOperation.MATCH);
			list.add(sc);
		}

		FilterUtil<TbOsCustomerEntity> filterUtil = new FilterUtil<TbOsCustomerEntity>();
		if (totalRecord == null) {
			totalRecord = tbOsCustmerPersistance.count(filterUtil.getSpecification(list));
		}

		if (to != null && from != null) {
			Pageable page = PageRequest.of(from, to, Sort.by(Sort.Direction.DESC, "id"));
			modelOrEntity = tbOsCustmerPersistance.findAll(filterUtil.getSpecification(list), page);
		}

		PaginationAttribute pageAttr = dbList.getPageAttribute();
		pageAttr.setPageIndex(filter.getPageIndex());
		pageAttr.setTotalPages((int) Math.ceil(totalRecord.intValue() * 1.0 / showRecordOnOnePage));
		pageAttr.setFetchrecords(modelOrEntity.size());
		pageAttr.setShowRecordOnOnePage(showRecordOnOnePage);
		pageAttr.setTotalRecords(totalRecord);

		dbList.setModelOrEntity(modelOrEntity);

		
		
		return dbList;
	}
	
	// add or Update User
	public ServiceOperationResult<TbOsCustomerModel> addOrUpdateUser(TbOsCustomerModel model) throws Exception
	{
		
		ServiceOperationResult<TbOsCustomerModel> response = new ServiceOperationResult<>();
		try
		{
			Long id = model.getId() != null ? model.getId() : null;
			String email = model.getEmail();
			String contact = model.getContactNumber();
			
			String valiResult = "SUCCESS";
			
			List<TbOsCustomerEntity> listUser = tbOsCustmerPersistance.findAll();
			for(TbOsCustomerEntity ent : listUser)
			{
				if(id == null)
				{
					if(email.equalsIgnoreCase(ent.getEmail()))
					{
						valiResult = "Email already Exist : "+email;
					}
				}
					else
					{
						if(id.longValue() != ent.getId().longValue() && email.equalsIgnoreCase(ent.getEmail()))
						{
							valiResult = "Email Already Exist ; "+email;
						}
					}
				
				if(id == null)
				{
					if(contact.equalsIgnoreCase(ent.getContactNumber()))
					{
						valiResult = "Contact already Exist : "+contact;
					}
				}
					else
					{
						if(id.longValue() != ent.getId().longValue() && contact.equalsIgnoreCase(ent.getContactNumber()))
						{
							valiResult = "contact Number Already Exist : "+contact;
						}
						
					}
			}
			
			
			if(valiResult == "SUCCESS")
			{	
				if(id != null)
				{
					
					TbOsCustomerEntity entity = tbOsCustmerPersistance.findById(id).get();
					
					entity.setId(id);
					setModelToEntity(model, entity);
					entity.setUpdBy(model.getCrtBy());
					entity.setUpdTs(new Date());
					
					tbOsCustmerPersistance.save(entity);
				}
				else
				{
					TbOsCustomerEntity entity = new TbOsCustomerEntity();
					entity.setId(null);
					String password = CommonUtilityHelper.getAlphaNumericString(12); //"checkPasword";//CommonUtilityHelper.getAlphaNumericString(12); //CommonUtilityHelper.getAlphaNumericString(16);
					entity.setPswd(password);
					entity.setLdaAuth(model.getLdaAuth() != null ? model.getLdaAuth() : entity.getLdaAuth());
					setModelToEntity(model, entity);
					entity.setRefId("SCRIPT_USER");
					entity.setCrtBy("SYSTE");
					entity.setFldLgnCnt(0);
					entity.setCrtTs(new Date());
					
					
					System.out.println(entity = tbOsCustmerPersistance.save(entity));
				
					if(StringUtils.equals(entity.getLdaAuth(), "N"))  //if(StringUtils.equals(entity.getLdaAuth(), CommonConstant.N))
					{
						entity.setRefId(entity.getFullName().substring(0, 2).toUpperCase()+entity.getId());
						String hashpassword = entity.getRefId()+entity.getPswd();
						entity.setPswd(MessageDiagestUtil.getHash(hashpassword));  
						entity.setPswdCrtBy(CommonConstant.SCRIPT_USER);//entity.setPswdCrtBy(CommonConstant.SCRIPT_USER);
					}
					else
						if(StringUtils.equals(entity.getLdaAuth(), "Y"))  //if(StringUtils.equals(entity.getLdaAuth(), CommonConstant.Y))
						{
							entity.setRefId(model.getRefId());
							String passw = entity.getRefId()+password;
							entity.setPswd(MessageDiagestUtil.getHash(passw)); 
							entity.setCrtBy(CommonConstant.SCRIPT_USER);
						}
					tbOsCustmerPersistance.save(entity);
					
				}
				response.setResponse(model);   
				
			}
			else
			{
				response.setSucces(false);
				response.getErrParam().setErrCode("No-Code");
				response.getErrParam().setErrDesc(valiResult);
			}			
		}
		catch(DatabaseException e)
		{
			
			throw new BusinessException(e);
		}
		return response;
	}
	
	
	// set Model to entity 
		private void setModelToEntity(TbOsCustomerModel model, TbOsCustomerEntity entity)
		{
			entity.setRefId(model.getRefId() != null ? model.getRefId() : entity.getRefId());
			entity.setPswd(model.getPswd() != null ? model.getPswd() : entity.getPswd());
			entity.setFullName(model.getFullName() != null ? model.getFullName() : entity.getFullName());
			entity.setDislayName(model.getDislayName() != null ? model.getDislayName() : entity.getDislayName());
			entity.setEmail(model.getEmail() != null ? model.getEmail() : entity.getEmail());
			entity.setContactInfo(model.getContactInfo() != null ? model.getContactInfo() : entity.getContactInfo());
			entity.setContactNumber(model.getContactNumber() != null ? model.getContactNumber() : entity.getContactNumber());
			entity.setLocation(model.getLocation() != null ? model.getLocation() : entity.getLocation());
			//entity.setLstLgnTs(model.getLstLgnCnt() != null ? model.getLstLgnCnt() : entity.getLstLgnTs());
			entity.setExprTs(model.getExprTs() != null ? model.getExprTs() : entity.getExprTs());
			entity.setPswdCrtBy(model.getPswdCrtBy() != null ? model.getPswdCrtBy() : entity.getPswdCrtBy());
			entity.setUserState(model.getUserState() != null ? model.getUserState() : entity.getUserState());
			entity.setSessionId(model.getSessionId() != null ? model.getSessionId() : entity.getSessionId());
			entity.setLdaAuth(model.getLdaAuth() != null ? model.getLdaAuth() : entity.getLdaAuth());
			entity.setSkipInactie(model.getSkipInactie() != null ? model.getSkipInactie() : entity.getSkipInactie());
			entity.setDsgn(model.getDsgn() != null ? model.getDsgn() : entity.getDsgn());
			entity.setDltBy(model.getDltBy() != null ? model.getDltBy() : entity.getDltBy());
			entity.setDltTs(model.getDltTs() != null ? model.getDltTs() : entity.getDltTs());
			//entity.setEncKeyId(model.getEncKeyId() != null ? model.getEncKeyId() : entity.getEncKeyId());
		}
	
	
	// Soft Delete user
		public ServiceOperationResult<TbOsCustomerModel>  softDleteUser(TbOsCustomerModel model)
		{
			ServiceOperationResult<TbOsCustomerModel> response = new ServiceOperationResult<>();
			Long id = model.getId();
			if(id == null)
				 throw new BusinessException("Id Must not be Null ");
			try
			{
				Optional<TbOsCustomerEntity> user = tbOsCustmerPersistance.findById(id);
				if(user.isPresent())
				{
					TbOsCustomerEntity entity = user.get();
					if(model.getDltBy() == null)
					{
						entity.setDltBy("Custom");
						entity.setDltTs(new Date());
						
					}
					else
					{
						model.setDltBy(null);
						model.setDltTs(null);
					}
					tbOsCustmerPersistance.save(entity);
				}
				else
				{
					throw new BusinessException("User Not found in Database : ");
				}
				
				response.setResponse(model);
			}
			catch(DatabaseException e)
			{
				throw new BusinessException(e);
			}
			return response;
		}
	
	
	
	
	
	
	
	
	

}
