package com.ecom.payments.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.payments.dao.TbOsPaymentsDao;
import com.ecom.payments.entities.TbOsPaymentsEntity;

@Component
@Transactional(readOnly = true)
public class TbOsPaymentsPersistance {
	
	
	@Autowired
	private TbOsPaymentsDao tbOsPaymentsDao;
	
	
	//find By Id
	public Optional<TbOsPaymentsEntity> findById(Long id)
	{
		return tbOsPaymentsDao.findById(id);
	}
	
	//find by order id
	public Optional<TbOsPaymentsEntity> findByOrderId(Long orderId)
	{
		return tbOsPaymentsDao.findByOrderId(orderId);
	}
	
	//save
	@Transactional
	public TbOsPaymentsEntity save(TbOsPaymentsEntity entity)
	{
		return tbOsPaymentsDao.save(entity);
	}
	//count
	public Long count(Specification<TbOsPaymentsEntity> speci)
	{
		return tbOsPaymentsDao.count(speci);
	}
	
	//findAll by page
	public List<TbOsPaymentsEntity> findAll(Specification<TbOsPaymentsEntity> speci, Pageable page)
	{
		return tbOsPaymentsDao.findAll(speci, page).getContent();
	}
	//find All
	public List<TbOsPaymentsEntity> findAll()
	{
		return tbOsPaymentsDao.findAll();
	}

}
