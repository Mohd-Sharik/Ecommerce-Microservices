package com.ecom.product.Persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.product.dao.TbOsCatagoryDao;
import com.ecom.product.entities.TbOsCatagoryEntity;

@Component
@Transactional(readOnly = true)
public class TbOSCatagoryPersistance {
	
	@Autowired
	private TbOsCatagoryDao tbOsCatagoryDao;
	
	
	//find by id
	public Optional<TbOsCatagoryEntity> findById(Long id)
	{
		return tbOsCatagoryDao.findById(id);
	}
	
	//save record
	@Transactional
	public TbOsCatagoryEntity save(TbOsCatagoryEntity entity)
	{
		return tbOsCatagoryDao.save(entity);
	}
	//get All Record by Pagination
	public List<TbOsCatagoryEntity> findAll(Specification<TbOsCatagoryEntity> speci, Pageable page)
	{
		return tbOsCatagoryDao.findAll(speci, page).getContent();
	}
	//get All record
	public List<TbOsCatagoryEntity> findAll()
	{
		return tbOsCatagoryDao.findAll();
	}
	//count record
	public Long count(Specification<TbOsCatagoryEntity> entity)
	{
		return tbOsCatagoryDao.count(entity);
	}

}
