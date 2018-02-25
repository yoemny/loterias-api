package com.loterias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loterias.model.StadisticGroup;
import com.loterias.repository.StadisticGroupRepository;

@RestController
@RequestMapping("/statistic")
public class StatisticController {
	
	@Autowired
	private StadisticGroupRepository stadisticGroupRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<StadisticGroup> findAll(){
		List<StadisticGroup> results = stadisticGroupRepository.findAll();
		return results;
	}
	
}
