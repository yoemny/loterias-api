package com.loterias.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loterias.model.EuromillonResult;
import com.loterias.model.Update;
import com.loterias.repository.EuromillonRepository;
import com.loterias.webdata.DataFromWeb;

@RestController
@RequestMapping("/euromillon")
public class EuroMillonController {

	@Autowired
	private EuromillonRepository euromillonRepository;
	@Autowired
	private DataFromWeb dataFromWeb;

	@RequestMapping(method = RequestMethod.GET)
	public List<EuromillonResult> findAll(){
		List<EuromillonResult> results = euromillonRepository.findAll();
		return results;
	}
	
	@GetMapping("/lastUpdate")
	public String updateResults(){
		return "";
		
	}
	
	@GetMapping("/isupdated")
	public Update isUpdateAvailable() throws IOException, ParseException{
		String strLastDate = dataFromWeb.getLastResultDate();
		Date date = dataFromWeb.getDate(strLastDate);
		Update update = new Update(false, date.toString());
		if ( euromillonRepository.findByDate(date) != null ){
			List<EuromillonResult>  resultsToUpdate = euromillonRepository.findByDrawNumber(-1);
			if (resultsToUpdate.isEmpty())
				update.setIsUpdated(true);
		}
		
		return update;
		
	}
	
	@GetMapping("/update")
	public Update update() throws IOException, ParseException{

		dataFromWeb.getAllNewDrawDates();
		dataFromWeb.updateResultCode();
		dataFromWeb.updateResult();
		Date date = dataFromWeb.getDate(dataFromWeb.getLastResultDate());
		return new Update(true, date.toString());
	}
	
	
	
	
}
