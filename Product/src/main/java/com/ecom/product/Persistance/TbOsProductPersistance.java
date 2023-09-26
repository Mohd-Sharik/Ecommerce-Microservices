package com.ecom.product.Persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.product.dao.TbOsProductDao;
import com.ecom.product.entities.TbOsProductEntity;

@Component
@Transactional(readOnly = true)
public class TbOsProductPersistance {
	
	
	@Autowired
	private TbOsProductDao tbOsProductDao;
	
	
	//find By Id
	public Optional<TbOsProductEntity> findbyId(Long id)
	{
		return tbOsProductDao.findById(id);
	}
	//save
	@Transactional
	public TbOsProductEntity save(TbOsProductEntity entity)
	{
		return tbOsProductDao.save(entity);
	}
	//count
	public Long Count(Specification<TbOsProductEntity> speci)
	{
		return tbOsProductDao.count(speci);
	}
	//get All record by Pagination
	public List<TbOsProductEntity> findAll(Specification<TbOsProductEntity> speci, Pageable page)
	{
		return tbOsProductDao.findAll(speci, page).getContent();
	}
	//get All Record
	public List<TbOsProductEntity> findAll()
	{
		return tbOsProductDao.findAll();
	}

}
