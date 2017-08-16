package com.loterias.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.loterias.model.EuromillonResult;

public interface EuromillonRepository extends CrudRepository<EuromillonResult, Long>{

	public List<EuromillonResult> findAll();
	public EuromillonResult findByDate(Date date);
	public List<EuromillonResult> findByPageCode(String pageCode);
	public List<EuromillonResult> findByPageCodeNotAndDrawNumber(String pageCode,Integer drawNumber);
	public List<EuromillonResult> findByDrawNumber(Integer drawNumber);
}
