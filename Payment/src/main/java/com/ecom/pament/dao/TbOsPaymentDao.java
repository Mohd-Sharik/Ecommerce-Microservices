package com.ecom.pament.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ecom.pament.entities.TbOsPaymentEntity;

@Repository
public interface TbOsPaymentDao extends JpaSpecificationExecutor<TbOsPaymentEntity> , JpaRepository<TbOsPaymentEntity, Long> {

	
	
	//Optional<TbOsPaymentEntity> findByOrderId(Long orderId);
}
