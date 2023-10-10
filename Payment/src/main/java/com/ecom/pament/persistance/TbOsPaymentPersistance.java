package com.ecom.pament.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.pament.dao.TbOsPaymentDao;
import com.ecom.pament.entities.TbOsPaymentEntity;

//import com.ecom.payments.entities.TbOsPaymentsEntity;

@Component
@Transactional(readOnly = true)
public class TbOsPaymentPersistance {
	
	@Autowired
	private TbOsPaymentDao tbOsPaymentDao;
	
	
	//find By Id
		public Optional<TbOsPaymentEntity> findById(Long id)
		{
			return tbOsPaymentDao.findById(id);
		}
		
		//find by order id
//		public Optional<TbOsPaymentEntity> findByOrderId(Long orderId)
//		{
//			return tbOsPaymentDao.findByOrderId(orderId);
//		}
		
		//save
		@Transactional
		public TbOsPaymentEntity save(TbOsPaymentEntity entity)
		{
			return tbOsPaymentDao.save(entity);
		}
		//count
		public Long count(Specification<TbOsPaymentEntity> speci)
		{
			return tbOsPaymentDao.count(speci);
		}
		
		//findAll by page
		public List<TbOsPaymentEntity> findAll(Specification<TbOsPaymentEntity> speci, Pageable page)
		{
			return tbOsPaymentDao.findAll(speci, page).getContent();
		}
		//find All
		public List<TbOsPaymentEntity> findAll()
		{
			return tbOsPaymentDao.findAll();
		}


}
