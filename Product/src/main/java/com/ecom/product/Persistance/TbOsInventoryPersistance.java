package com.ecom.product.Persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.product.dao.TbOsInventoryDao;
import com.ecom.product.entities.TbOSInventoryEntity;

@Component
@Transactional(readOnly = true)
public class TbOsInventoryPersistance {
	
	
	
	@Autowired
	private TbOsInventoryDao tbOsInventoryDao;
	
	
	//find by id
	public Optional<TbOSInventoryEntity> findById(Long id)
	{
		return tbOsInventoryDao.findById(id);
	}
	//save
	@Transactional
	public TbOSInventoryEntity save(TbOSInventoryEntity entity)
	{
		return tbOsInventoryDao.save(entity);
	}
	//get All recoed from database
	public List<TbOSInventoryEntity> findAll(Specification<TbOSInventoryEntity> speci, Pageable page)
	{
		return tbOsInventoryDao.findAll(speci, page).getContent();
	}
	//get All Record
	public List<TbOSInventoryEntity> findAll()
	{
		return tbOsInventoryDao.findAll();
	}
	//count record
	public Long count(Specification<TbOSInventoryEntity> speci)
	{
		return tbOsInventoryDao.count();
	}

}
