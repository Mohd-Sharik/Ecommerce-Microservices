package com.ecom.payments.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ecom.payments.entities.TbOsPaymentsEntity;

@Repository
public interface TbOsPaymentsDao extends JpaSpecificationExecutor<TbOsPaymentsEntity>, JpaRepository<TbOsPaymentsEntity, Long> {

}
