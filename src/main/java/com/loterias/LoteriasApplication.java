package com.loterias;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LoteriasApplication implements CommandLineRunner{

	//private static final Logger log = LoggerFactory.getLogger(LoteriasApplication.class);
	/*
	@Autowired
	private DataFromWeb dataFromWeb;
	@Autowired
	private EuromillonRepository euromillonRepository;
*/
	public static void main(String[] args) {
		SpringApplication.run(LoteriasApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		//log.info("updating...");
		//dataFromWeb.updateResultCode();
		//dataFromWeb.updateResult();
		/*List<String> list = dataFromWeb.getAllDrawDates();
		for (String temp : list) {
			Date date = dataFromWeb.getDate(temp);
			
			EuromillonResult result = new EuromillonResult(date);
			if ( euromillonRepository.findByDate(date) == null ){
				log.info("date-> " + date);
				euromillonRepository.save(result);
			}
				
		}*/
	}
}
