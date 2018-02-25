package com.loterias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loterias.model.Stadistic;
import com.loterias.repository.StadisticRepository;

@RestController
@RequestMapping("/stadistic")
public class StadisticController {
	
	@Autowired
	private StadisticRepository stadisticRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Stadistic> findAll(){
		List<Stadistic> results = stadisticRepository.findAll();
		return results;
	}
	
}
