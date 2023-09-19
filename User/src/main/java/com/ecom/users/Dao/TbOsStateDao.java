package com.ecom.users.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ecom.users.entites.TbOsStateEntity;

@Repository
public interface TbOsStateDao extends JpaSpecificationExecutor<TbOsStateEntity> , JpaRepository<TbOsStateEntity, Long> {

}
