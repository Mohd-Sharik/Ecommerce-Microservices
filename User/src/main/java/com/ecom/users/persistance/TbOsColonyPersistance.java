package com.ecom.users.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.users.Dao.TbOsColonyDao;
import com.ecom.users.entites.TbOsColonyEntity;

@Component
@Transactional(readOnly = true)
public class TbOsColonyPersistance {
	
	
	@Autowired
	private TbOsColonyDao tbOsColonyDao;
	
	
	
	
	//geet by id
		public Optional<TbOsColonyEntity> findById(Long id)
		{
			return tbOsColonyDao.findById(id);
		}
		
		//save 
			@Transactional
			public TbOsColonyEntity save(TbOsColonyEntity entity)
			{
				return tbOsColonyDao.save(entity);
			}
			
			//get List
			public List<TbOsColonyEntity> findAll()
			{
				return tbOsColonyDao.findAll();
			}
			
			//find All by Pagination
			public List<TbOsColonyEntity> findAll(Specification<TbOsColonyEntity> speci, Pageable page)
			{
				return tbOsColonyDao.findAll(speci, page).getContent();
			}
			
			
			//count record
			public Long count(Specification<TbOsColonyEntity> speci)
			{
				return tbOsColonyDao.count(speci);
			}


}
