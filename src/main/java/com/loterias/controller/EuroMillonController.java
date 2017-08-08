package com.loterias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loterias.model.EuromillonResult;
import com.loterias.repository.EuromillonRepository;

@RestController
@RequestMapping("/euromillon")
public class EuroMillonController {

	@Autowired
	private EuromillonRepository euromillonRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<EuromillonResult> findAll(){
		return euromillonRepository.findAll();
	}
	
	@PostMapping("/update")
	public String updateResults(){
		return "NO";
		
	}
}
