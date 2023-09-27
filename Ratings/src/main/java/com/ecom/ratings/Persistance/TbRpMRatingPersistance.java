package com.ecom.ratings.Persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.ratings.dao.TbRpMRatingDao;
import com.ecom.ratings.entities.TbRpMRatingEntity;

@Component
@Transactional(readOnly = true)
public class TbRpMRatingPersistance {
	
	@Autowired
	private TbRpMRatingDao tbRpMRatingDao;
	
	//find By id
	public Optional<TbRpMRatingEntity> findById(Long id)
	{
		return tbRpMRatingDao.findById(id);
	}
	//save
	public TbRpMRatingEntity save(TbRpMRatingEntity entity)
	{
		return tbRpMRatingDao.save(entity);
	}
	//count
	public Long cont(Specification<TbRpMRatingEntity> speci)
	{
		return tbRpMRatingDao.count(speci);
	}
	//get All List Of Rating By Pagination
	public List<TbRpMRatingEntity> getAll(Specification<TbRpMRatingEntity> speci, Pageable page)
	{
		return tbRpMRatingDao.findAll(speci, page).getContent();
	}
	//get All List of Rating
	public List<TbRpMRatingEntity> getAll()
	{
		return tbRpMRatingDao.findAll();
	}

}
