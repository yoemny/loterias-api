package com.loterias.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(method = RequestMethod.POST)
	public String findNewResults(){
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = formatter.parse("fdfd");
			return "OK";
		} catch (ParseException e) {
			return "NO";
		}
	}
}
