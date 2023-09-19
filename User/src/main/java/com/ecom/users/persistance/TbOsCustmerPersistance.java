package com.ecom.users.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.users.Dao.TbOsCustomerDao;
import com.ecom.users.entites.TbOsCustomerEntity;

@Component
@Transactional(readOnly = true)
public class TbOsCustmerPersistance {
	
	
	
	@Autowired
	private TbOsCustomerDao tbOsCustomerDao;
	
	
	
	
	
			//geet by id
			public Optional<TbOsCustomerEntity> findById(Long id)
			{
				return tbOsCustomerDao.findById(id);
			}
			
			//save 
				@Transactional
				public TbOsCustomerEntity save(TbOsCustomerEntity entity)
				{
					return tbOsCustomerDao.save(entity);
				}
				
				//get List
				public List<TbOsCustomerEntity> findAll()
				{
					return tbOsCustomerDao.findAll();
				}
				
				//find All by Pagination
				public List<TbOsCustomerEntity> findAll(Specification<TbOsCustomerEntity> speci, Pageable page)
				{
					return tbOsCustomerDao.findAll(speci, page).getContent();
				}
				
				
				//count record
				public Long count(Specification<TbOsCustomerEntity> speci)
				{
					return tbOsCustomerDao.count(speci);
				}


}
