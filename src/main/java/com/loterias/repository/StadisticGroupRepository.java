package com.loterias.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.loterias.model.StadisticGroup;

public interface StadisticGroupRepository extends CrudRepository<StadisticGroup, Long>{
	
	public List<StadisticGroup> findAll();

}
