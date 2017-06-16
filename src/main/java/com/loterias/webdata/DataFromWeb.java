package com.loterias.webdata;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loterias.LoteriasApplication;
import com.loterias.model.EuromillonResult;
import com.loterias.repository.EuromillonRepository;

@Service
public class DataFromWeb {

	private static final Logger log = LoggerFactory.getLogger(DataFromWeb.class);
	
	private EuromillonRepository euromillonRepository;

	private Map<String, String> months;
	
	@Autowired
	public DataFromWeb(EuromillonRepository euromillonRepository) {
		months = new HashMap<>();
		months.put("ene", "01");
		months.put("feb", "02");
		months.put("mar", "03");
		months.put("abr", "04");
		months.put("may", "05");
		months.put("jun", "06");
		months.put("jul", "07");
		months.put("ago", "08");
		months.put("sep", "09");
		months.put("oct", "10");
		months.put("nov", "11");
		months.put("dic", "12");
		
		this.euromillonRepository = euromillonRepository;
		
	}
	
	public Date getDate(String td) throws ParseException{
		String month = td.substring(7, 10);
		String day = td.substring(4,6);
		String year = td.substring(11,15);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String dateInString =  day + "-" + months.get(month) + "-" + year;
		return formatter.parse(dateInString);
	}
	
	public List<String> getAllDrawDates() throws IOException{
		
		List<String> list = new ArrayList<>();
		
		LocalDateTime now = LocalDateTime.now();
		int actualYear = now.getYear();
		
		for (int y=actualYear ; y>=2004 ; y--){
			String url = "https://www.euromillones.com/resultados-euromillones.asp?y="+y;
			Document doc = Jsoup.connect(url).get();
			Elements tableElements = doc.getElementsByClass("tbl no-responsive ee hover no-back");
			for (Element te : tableElements) {
				Elements elementsTable = te.children();   
				Element  elementTBody = elementsTable.get(0);
				Elements elementsTR = elementTBody.children();
				for (Element eTR : elementsTR) {
					Element elementDate = eTR.getElementsByClass("d hide-phone").first();
					list.add(elementDate.text());
				}
			}

		}
		
		return list;
		
		
	}
	
	public void updateResultCode(){
		List<EuromillonResult>  resultList = euromillonRepository.findByPageCode("NoCode");
		for (EuromillonResult result : resultList) {
			Date date = result.getDate();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String s = formatter.format(date);
			String code = searchCode(s);
			if ( code!=null ){
				result.setPageCode(code);
				log.info(result.getPageCode());
				euromillonRepository.save(result);
			}
				
		}
	}
	
	private String searchCode(String strDate){
		String url = "http://www.loteriasyapuestas.es/es/buscador?startDate="+strDate+"&gameId=02&type=search&endDate="+strDate;
		try {
			Document doc = Jsoup.connect(url).get();
			
			Element regionDerechaElement = doc.getElementsByClass("cuerpoRegionDerecha").first();
			Element aElement = regionDerechaElement.getElementsByTag("a").first();
			 
			String codeUrl = aElement.attr("abs:href");
			String code = extractCode(codeUrl);
			return code;
		} catch (IOException e) {
			return null;		}
		
	}
	
	private String extractCode(String url){
		return url.substring(56, url.length());
	}
	
	public void updateResult(){
		List<EuromillonResult>  resultList = euromillonRepository.findByPageCodeNotAndDrawNumber("NoCode", -1);
		for (EuromillonResult result : resultList) {
			log.info(result.getPageCode());
			euromillonRepository.save(extractData(result));
			
		}
	}
	
	private EuromillonResult extractData(EuromillonResult result){
		String url = "http://www.loteriasyapuestas.es/es/euromillones/sorteos/"+result.getPageCode();
		
		try {
			Document doc = Jsoup.connect(url).get();
			
			//numeros afortunados
			Element ulNumbresElement = doc.getElementById("actMainNumbers");
			Elements numbersElements = ulNumbresElement.children();

			Element ulStarsElement = doc.getElementById("actStars");
			Elements startsElements = ulStarsElement.children();
			
			if (numbersElements.size() != 0){
				result.setSorted(false);
				result = updateNumbers(result, numbersElements);
				result = updateStars(result, startsElements);
			}else{
				result.setSorted(true);
				ulNumbresElement = doc.getElementById("mainNumbers");
				numbersElements = ulNumbresElement.children();
				result = updateNumbers(result, numbersElements);
				ulStarsElement = doc.getElementById("stars");
				startsElements = ulStarsElement.children();
				result = updateStars(result, startsElements);
			}
			result.setDrawNumber(0);
			return result;
		} catch (IOException e) {
			return result;
		}
		
	}
	
	private EuromillonResult updateNumbers(EuromillonResult result,Elements numbersElements){
		result.setNumber1(new Integer(numbersElements.get(0).text()));
		result.setNumber2(new Integer(numbersElements.get(1).text()));
		result.setNumber3(new Integer(numbersElements.get(2).text()));
		result.setNumber4(new Integer(numbersElements.get(3).text()));
		result.setNumber5(new Integer(numbersElements.get(4).text()));
		return result;
	}

	private EuromillonResult updateStars(EuromillonResult result,Elements startsElements){
		result.setStar1(new Integer(startsElements.get(0).text()));
		result.setStar2(new Integer(startsElements.get(1).text()));
		
		return result;
	}

}
