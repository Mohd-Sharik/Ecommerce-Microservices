package com.ecom.ratings.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.ratings.Persistance.TbRpMRatingPersistance;
import com.ecom.ratings.entities.TbRpMRatingEntity;
import com.ecom.ratings.models.TbRpMRatingModel;

@Service
public class TbRpMRatingService {
	
	
	@Autowired
	private TbRpMRatingPersistance tbRpMRatingPersistance;
	
	//getList Of Rating
	public List<TbRpMRatingModel> getAllRating()
	{
		List<TbRpMRatingModel> response = new ArrayList<TbRpMRatingModel>();
		
		List<TbRpMRatingEntity> entities = tbRpMRatingPersistance.getAll();
		
		for(TbRpMRatingEntity entity : entities)
		{
			TbRpMRatingModel model = new TbRpMRatingModel();
			
			model.setId(entity.getId() != null ? entity.getId() : null);
			model.setUserId(entity.getUserId() != null ? entity.getUserId() : null);
			model.setProductId(entity.getProductId() != null ? entity.getProductId() : null);
			model.setRatings(entity.getRating() != null ? entity.getRating() : null);
			model.setFeedback(entity.getFeedback() != null ? entity.getFeedback() : null);
			
			response.add(model);
		}
		return response;
	}

}
