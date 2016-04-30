package br.com.eshopper.ecommerce.controllers.integrations;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.eshopper.ecommerce.daos.SummaryDataDAO;
import br.com.eshopper.ecommerce.daos.SummaryUserDAO;
import br.com.eshopper.ecommerce.models.EmptyJsonResponse;
import br.com.eshopper.ecommerce.models.SummaryData;
import br.com.eshopper.ecommerce.models.SummaryUser;

@RestController
@RequestMapping("v1/summary")
public class SummaryRestController {

	@Autowired
	private SummaryUserDAO summaryUserDao;

	@Autowired
	private SummaryDataDAO summaryDataDao;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public SummaryUser getSummaryUserInfo() {
		return summaryUserDao.find();
	}

	@RequestMapping(value = "/data", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@Autowired
	public ResponseEntity<?> getSummaryDataInfo(@RequestParam(required = false) final Optional month,
			@RequestParam(required = false) final Optional year, SummaryData summaryData) {
		
		checkParameters(month, year, summaryData);
		SummaryData found = summaryDataDao.find(summaryData.getPeriod());
		if(found == null) 
			return new ResponseEntity<EmptyJsonResponse>(new EmptyJsonResponse(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<SummaryData>(found, HttpStatus.OK);
	}

	private void checkParameters(Optional month, Optional year, SummaryData summaryData) {
		if (month.isPresent() && year.isPresent())
			summaryData.setPeriod(Integer.parseInt(month.get().toString()), Integer.parseInt(year.get().toString()));
		else if (month.isPresent())
			summaryData.setMonth(Integer.parseInt(month.get().toString()));
		else if (year.isPresent()) {
			summaryData.setYear(Integer.parseInt(year.get().toString()));
		}
	}

}
