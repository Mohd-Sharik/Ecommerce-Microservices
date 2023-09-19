package com.ecom.users.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.users.Dao.TbOsStateDao;
import com.ecom.users.entites.TbOsStateEntity;

@Component
@Transactional(readOnly = true)
public class TbOsStatePersistance {
	
	
	@Autowired
	private TbOsStateDao tbOsStateDao;
	
	
	
	
	
				//geet by id
				public Optional<TbOsStateEntity> findById(Long id)
				{
					return tbOsStateDao.findById(id);
				}
			
				//save 
				@Transactional
				public TbOsStateEntity save(TbOsStateEntity entity)
				{
					return tbOsStateDao.save(entity);
				}
				
				//get List
				public List<TbOsStateEntity> findAll()
				{
					return tbOsStateDao.findAll();
				}
				
				//find All by Pagination
				public List<TbOsStateEntity> findAll(Specification<TbOsStateEntity> speci, Pageable page)
				{
					return tbOsStateDao.findAll(speci, page).getContent();
				}
				
				
				//count record
				public Long count(Specification<TbOsStateEntity> speci)
				{
					return tbOsStateDao.count(speci);
				}


}
