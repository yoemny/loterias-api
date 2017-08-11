package com.loterias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loterias.model.EuromillonResult;
import com.loterias.model.Update;
import com.loterias.repository.EuromillonRepository;

@RestController
@RequestMapping("/euromillon")
public class EuroMillonController {

	@Autowired
	private EuromillonRepository euromillonRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<EuromillonResult> findAll(){
		List<EuromillonResult> results = euromillonRepository.findAll();
		return results;
	}
	
	@GetMapping("/update")
	public Update updateResults(){
		return new Update("20/01/2017");
		
	}
}
