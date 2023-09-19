package com.ecom.users.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.users.Dao.TbOsErrDao;
import com.ecom.users.entites.TbOsDbErrEntity;

@Component
@Transactional(readOnly = true)
public class TbOsErrPersistance {
	
	
	@Autowired
	private TbOsErrDao tbOsErrDao;
	
	
	
	//geet by id
			public Optional<TbOsDbErrEntity> findById(Long id)
			{
				return tbOsErrDao.findById(id);
			}
			
			//save 
				@Transactional
				public TbOsDbErrEntity save(TbOsDbErrEntity entity)
				{
					return tbOsErrDao.save(entity);
				}
				
				//get List
				public List<TbOsDbErrEntity> findAll()
				{
					return tbOsErrDao.findAll();
				}
				
				//find All by Pagination
				public List<TbOsDbErrEntity> findAll(Specification<TbOsDbErrEntity> speci, Pageable page)
				{
					return tbOsErrDao.findAll(speci, page).getContent();
				}
				
				
				//count record
				public Long count(Specification<TbOsDbErrEntity> speci)
				{
					return tbOsErrDao.count(speci);
				}


}
