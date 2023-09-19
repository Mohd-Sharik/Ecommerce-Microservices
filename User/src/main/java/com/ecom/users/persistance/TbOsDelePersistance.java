package com.ecom.users.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.users.Dao.TbOsDeleDao;
import com.ecom.users.entites.TbOsDelegEntity;

@Component
@Transactional(readOnly = true)
public class TbOsDelePersistance {
	
	
	@Autowired
	private TbOsDeleDao tbOsDeleDao;
	
	
	
	
	
			//geet by id
			public Optional<TbOsDelegEntity> findById(Long id)
			{
				return tbOsDeleDao.findById(id);
			}
			
			//save 
				@Transactional
				public TbOsDelegEntity save(TbOsDelegEntity entity)
				{
					return tbOsDeleDao.save(entity);
				}
				
				//get List
				public List<TbOsDelegEntity> findAll()
				{
					return tbOsDeleDao.findAll();
				}
				
				//find All by Pagination
				public List<TbOsDelegEntity> findAll(Specification<TbOsDelegEntity> speci, Pageable page)
				{
					return tbOsDeleDao.findAll(speci, page).getContent();
				}
				
				
				//count record
				public Long count(Specification<TbOsDelegEntity> speci)
				{
					return tbOsDeleDao.count(speci);
				}

	
	
	
	
	
	
	

}
