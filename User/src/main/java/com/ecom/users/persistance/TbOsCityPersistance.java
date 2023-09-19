package com.ecom.users.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.users.Dao.TbOsCityDao;
import com.ecom.users.entites.TbOsCityEntity;

@Component
@Transactional(readOnly = true)
public class TbOsCityPersistance {
	
	
	@Autowired
	private TbOsCityDao tbOsCityDao;
	
	//geet by id
	public Optional<TbOsCityEntity> findById(Long id)
	{
		return tbOsCityDao.findById(id);
	}
	
	//save 
		@Transactional
		public TbOsCityEntity save(TbOsCityEntity entity)
		{
			return tbOsCityDao.save(entity);
		}
		
		//get List
		public List<TbOsCityEntity> findAll()
		{
			return tbOsCityDao.findAll();
		}
		
		//find All by Pagination
		public List<TbOsCityEntity> findAll(Specification<TbOsCityEntity> speci, Pageable page)
		{
			return tbOsCityDao.findAll(speci, page).getContent();
		}
		
		
		//count record
		public Long count(Specification<TbOsCityEntity> speci)
		{
			return tbOsCityDao.count(speci);
		}
		

}
