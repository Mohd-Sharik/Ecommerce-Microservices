package com.ecom.users.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ecom.users.entites.TbOsAdrssEntity;

@Repository
public interface TbOsAdrsDao extends JpaSpecificationExecutor<TbOsAdrssEntity>, JpaRepository<TbOsAdrssEntity, Long> {

}
