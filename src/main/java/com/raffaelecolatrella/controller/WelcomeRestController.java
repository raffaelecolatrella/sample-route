package com.raffaelecolatrella.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raffaelecolatrella.services.CountriesCurrService;

@RestController
public class WelcomeRestController {

	private static final Logger logger = Logger.getLogger(WelcomeRestController.class);

	@Autowired
	private CountriesCurrService ccs;

	@RequestMapping(value = "/api", method = RequestMethod.GET, produces = "application/json")
	public String getWelcomeApi(Model model) {
		logger.info("call rest service");
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString=null;
		try {
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this.ccs.getAll());
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return jsonInString;
	}

}