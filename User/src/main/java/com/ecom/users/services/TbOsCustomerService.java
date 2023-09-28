package com.ecom.users.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecom.users.commonUtil.CommonConstant;
import com.ecom.users.commonUtil.CommonUtilityHelper;
import com.ecom.users.entites.TbOsCustomerEntity;
import com.ecom.users.externalService.RatingService;
import com.ecom.users.models.TbOsCustomerModel;
import com.ecom.users.models.TbRpMRatingModel;
import com.ecom.users.persistance.TbOsCustmerPersistance;

@Service
public class TbOsCustomerService {
	
	
	Logger logger = LoggerFactory.getLogger(TbOsCustomerService.class);
	
	
	@Autowired
	TbOsCustmerPersistance tbOsCustmerPersistance;
	@Autowired
	RatingService ratingService;
	
	
	
	
	public List<TbOsCustomerModel> getAllCustomer()
	{
		List<TbOsCustomerModel> response = new ArrayList<TbOsCustomerModel>();
		
		List<TbOsCustomerEntity> entities = tbOsCustmerPersistance.findAll();
		for(TbOsCustomerEntity entity : entities)
		{
			TbOsCustomerModel model = new TbOsCustomerModel();
			
			
			 model.setId(entity.getId() != null ? entity.getId() : null);
			 model.setRefId(entity.getRefId() != null ? entity.getRefId() : null);
			 model.setPswd(entity.getPswd() != null ? entity.getPswd() : null);
			 model.setFullName(entity.getFullName() != null ? entity.getFullName() : null);
			 model.setDislayName(entity.getDislayName() != null ? entity.getDislayName() :null);
			 model.setEmail(entity.getEmail() != null ? entity.getEmail() : null);
			 model.setContactInfo(entity.getContactInfo() != null ? entity.getContactInfo() : null);
			 model.setContactNumber(entity.getContactNumber() != null ? entity.getContactNumber() : null);
			 model.setDsgn(entity.getDsgn() != null ? entity.getDsgn() : null);
			 model.setLocation(entity.getLocation() != null ? entity.getLocation() : null);
			 model.setFldLgnCnt(entity.getFldLgnCnt() != null ? entity.getFldLgnCnt() : null);
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
			 model.setCrtTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getCrtTs(),CommonConstant.dateFormate.DD_MMM_YYYY_HHMMSS_SSS_A));
			 model.setUpdTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getUpdTs(), CommonConstant.dateFormate.DD_MMM_YYYY_HHMMSS_SSS_A));
			 model.setDltTsString(CommonUtilityHelper.Dateutil.getStringFormatDate(entity.getDltTs(), CommonConstant.dateFormate.DD_MMM_YYYY_HHMMSS_SSS_A));
			
			 List<TbRpMRatingModel> ratings =   ratingService.findRatingByUserId(entity.getId());				
			 model.setRatings(ratings);
			 
			 response.add(model);
		}
		
		return response;
	}

}
