package com.ecom.users.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.users.Dao.TbOsAdrsDao;
import com.ecom.users.entites.TbOsAdrssEntity;

@Component
@Transactional(readOnly = true)
public class TbOsAdrsPersistance {
	
	@Autowired
	private TbOsAdrsDao tbOsAdrsDao;
	
	
	//get by id
	public Optional<TbOsAdrssEntity> findById(Long id)
	{
		return tbOsAdrsDao.findById(id);
	}
	
	//save 
	@Transactional
	public TbOsAdrssEntity save(TbOsAdrssEntity entity)
	{
		return tbOsAdrsDao.save(entity);
	}
	
	//get List
	public List<TbOsAdrssEntity> findAll()
	{
		return tbOsAdrsDao.findAll();
	}
	
	//find All by Pagination
	public List<TbOsAdrssEntity> findAll(Specification<TbOsAdrssEntity> speci, Pageable page)
	{
		return tbOsAdrsDao.findAll(speci, page).getContent();
	}
	
	
	//count record
	public Long count(Specification<TbOsAdrssEntity> speci)
	{
		return tbOsAdrsDao.count(speci);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
