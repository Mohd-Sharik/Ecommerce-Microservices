package com.ecom.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ecom.product.entities.TbOsCatagoryEntity;

@Repository
public interface TbOsCatagoryDao extends JpaSpecificationExecutor<TbOsCatagoryEntity> , JpaRepository<TbOsCatagoryEntity, Long> {

}
