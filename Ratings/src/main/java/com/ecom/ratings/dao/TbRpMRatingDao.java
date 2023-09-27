package com.ecom.ratings.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ecom.ratings.entities.TbRpMRatingEntity;

@Repository
public interface TbRpMRatingDao extends JpaSpecificationExecutor<TbRpMRatingEntity>, JpaRepository<TbRpMRatingEntity, Long> {

}
