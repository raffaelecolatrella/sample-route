package com.raffaelecolatrella.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.raffaelecolatrella.commons.JsonReader;
import com.raffaelecolatrella.models.CountriesCurr;

@Service
public class CountriesCurrServiceImpl implements CountriesCurrService  {
	
	private static final Logger logger = Logger.getLogger(CountriesCurrService.class);
	
	private static final String URL = "https://restcountries.eu/rest/v2/all";

	public List<CountriesCurr> getAll(){

		logger.info("get all country with curriencies");
		
		ArrayList<CountriesCurr> list = new ArrayList<CountriesCurr>();
		try {
			JSONArray jsonList = null;
			jsonList = JsonReader.readJsonFromUrl(URL);

			for (Object item:jsonList) {
				CountriesCurr pojo = new CountriesCurr();
				JSONObject json=(JSONObject)item;
				pojo.setName(json.getString("name"));

				JSONArray currencies = json.optJSONArray("currencies");
				ArrayList<String> listCurr = new ArrayList<String>();
				for (Object curr:currencies) {
					JSONObject c=(JSONObject)curr;
					if (!c.isNull("code")) {
						listCurr.add((String)c.get("code"));
					}
				}
				pojo.setCurr(listCurr);
				list.add(pojo);
			}
		} catch (JSONException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		logger.debug("size when fetch finish: "+list.size());
		List<CountriesCurr> result = list;
		return result;
	}
}
