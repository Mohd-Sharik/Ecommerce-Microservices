package com.ecom.users.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.users.Dao.TbOsPostalDao;
import com.ecom.users.entites.TbOsPostalEntity;

@Component
@Transactional(readOnly = true)
public class TbOsPostalPersistance {
	
	
	@Autowired
	private TbOsPostalDao tbOsPostalDao;
	
	
	
	
			//geet by id
			public Optional<TbOsPostalEntity> findById(Long id)
			{
				return tbOsPostalDao.findById(id);
			}
			
			//save 
				@Transactional
				public TbOsPostalEntity save(TbOsPostalEntity entity)
				{
					return tbOsPostalDao.save(entity);
				}
				
				//get List
				public List<TbOsPostalEntity> findAll()
				{
					return tbOsPostalDao.findAll();
				}
				
				//find All by Pagination
				public List<TbOsPostalEntity> findAll(Specification<TbOsPostalEntity> speci, Pageable page)
				{
					return tbOsPostalDao.findAll(speci, page).getContent();
				}
				
				
				//count record
				public Long count(Specification<TbOsPostalEntity> speci)
				{
					return tbOsPostalDao.count(speci);
				}


}
