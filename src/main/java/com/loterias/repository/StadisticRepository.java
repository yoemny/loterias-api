package com.loterias.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.loterias.model.Stadistic;

public interface StadisticRepository extends CrudRepository<Stadistic, Long>{

	public List<Stadistic> findAll();
	
}
