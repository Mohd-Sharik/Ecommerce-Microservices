package com.ecom.users.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.users.Dao.TbOsCountryDao;
import com.ecom.users.entites.TbOsCountryEntity;

@Component
@Transactional(readOnly = true)
public class TbOsCountryPersistance {
	
	
	@Autowired
	private TbOsCountryDao tbOsCountryDao;
	
	
	
	
	
	//geet by id
			public Optional<TbOsCountryEntity> findById(Long id)
			{
				return tbOsCountryDao.findById(id);
			}
			
			//save 
				@Transactional
				public TbOsCountryEntity save(TbOsCountryEntity entity)
				{
					return tbOsCountryDao.save(entity);
				}
				
				//get List
				public List<TbOsCountryEntity> findAll()
				{
					return tbOsCountryDao.findAll();
				}
				
				//find All by Pagination
				public List<TbOsCountryEntity> findAll(Specification<TbOsCountryEntity> speci, Pageable page)
				{
					return tbOsCountryDao.findAll(speci, page).getContent();
				}
				
				
				//count record
				public Long count(Specification<TbOsCountryEntity> speci)
				{
					return tbOsCountryDao.count(speci);
				}


}
