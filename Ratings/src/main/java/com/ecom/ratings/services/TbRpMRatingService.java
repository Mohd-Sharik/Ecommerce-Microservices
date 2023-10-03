package com.ecom.ratings.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.ratings.Persistance.TbRpMRatingPersistance;
import com.ecom.ratings.entities.TbRpMRatingEntity;
import com.ecom.ratings.models.TbRpMRatingModel;

@Service
public class TbRpMRatingService {
	
	
	@Autowired
	private TbRpMRatingPersistance tbRpMRatingPersistance;
	
	
	
	
	
	
	//get By ProductId
	public List<TbRpMRatingModel> findByProductId(Long id)
	{
		List<TbRpMRatingModel> response = new ArrayList<TbRpMRatingModel>();
		if(id == null)
			return null;
		List<TbRpMRatingEntity> entities = tbRpMRatingPersistance.findByProductId(id);
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
	//get by Userid
	public List<TbRpMRatingModel> ratingByUserId(Long id)
	{
		List<TbRpMRatingModel> response = new ArrayList<TbRpMRatingModel>();
		if(id == null)
			return null;
		List<TbRpMRatingEntity> entities = tbRpMRatingPersistance.findByUserId(id);
		
		for(TbRpMRatingEntity entity : entities)
		{
			TbRpMRatingModel model = new TbRpMRatingModel();
			
			model.setId(entity.getId());
			model.setProductId(entity.getProductId());
			model.setUserId(entity.getUserId());
			model.setRatings(entity.getRating());
			model.setFeedback(entity.getFeedback());
			
			response.add(model);
		}
		return response;
	}
	
	
	
	
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
	
	// add or update rating
	public TbRpMRatingModel addOrUpdate(TbRpMRatingModel model)
	{
		//TbRpMRatingModel response = rating;
		Long id = model.getId();
		
		if(id != null)
		{
			Optional<TbRpMRatingEntity> reting = tbRpMRatingPersistance.findById(model.getId());
			if(reting.isPresent())
			{
				TbRpMRatingEntity entity = reting.get();
				
				entity.setId(model.getId() != null ? model.getId() : null );
				entity.setUserId(model.getUserId() != null ?  model.getUserId() : null);
				entity.setProductId(model.getProductId() != null ? model.getProductId() : null);
				entity.setRating(model.getRatings() != null ? model.getRatings() : null);
				entity.setFeedback(model.getFeedback() != null ? model.getFeedback() : null);
				
				tbRpMRatingPersistance.save(entity);
			}
		}
		else
		{
			TbRpMRatingEntity entity = new TbRpMRatingEntity();
			
			entity.setId( null );
			entity.setUserId(model.getUserId() != null ?  model.getUserId() : entity.getUserId());
			entity.setProductId(model.getProductId() != null ? model.getProductId() : entity.getProductId());
			entity.setRating(model.getRatings() != null ? model.getRatings() : entity.getRating());
			entity.setFeedback(model.getFeedback() != null ? model.getFeedback() : entity.getFeedback());
			
			tbRpMRatingPersistance.save(entity);
		}		
		return model;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
