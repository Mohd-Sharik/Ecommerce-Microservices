package com.ecom.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ecom.product.entities.TbOSInventoryEntity;

@Repository
public interface TbOsInventoryDao extends JpaSpecificationExecutor<TbOSInventoryEntity>, JpaRepository<TbOSInventoryEntity, Long> {

}
