package com.raffaelecolatrella.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonReader {

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONArray list = new JSONArray(jsonText);
			//JSONObject json = new JSONObject(jsonText);
			return list;
		} finally {
			is.close();
		}
	}

	public static void main(String[] args) throws IOException, JSONException {
		JSONArray jsonList = readJsonFromUrl("https://restcountries.eu/rest/v2/all");
		
		for (Object item:jsonList) {
			JSONObject json=(JSONObject)item;
			JSONArray currencies = json.optJSONArray("currencies");
			System.out.print(json.get("name"));
			System.out.print("-"+json.get("numericCode")+"#");
			for (Object curr:currencies) {
				JSONObject c=(JSONObject)curr;
				System.out.print(", "+c.get("code"));
			}
			System.out.println("");
		}
		
	}
}

