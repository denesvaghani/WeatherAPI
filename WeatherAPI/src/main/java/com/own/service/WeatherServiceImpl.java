package com.own.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.own.model.Location;
import com.own.model.Weather;

@Service
public class WeatherServiceImpl implements WeatherService {

	private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

	@Value("${WeatherAPI}")
	private String WeatherAPI;

	@Value("${LatitudeParam}")
	private String LatitudeParam;

	@Value("${LongitudeParam}")
	private String LongitudeParam;

	@Value("${Weathertoken}")
	private String Weathertoken;

	@Value("${WeatherAPIKey}")
	private String WeatherAPIKey;

	@Override
	public Weather getWeatherDetails(Location location) {

		logger.info(" Process is now Calculating Weather Details...");

		Weather weather = new Weather();
		RestTemplate restTemplate = new RestTemplate();

		String url  = WeatherAPI + LatitudeParam + location.getLatitude() + LongitudeParam
				+ location.getLongitude() + Weathertoken + WeatherAPIKey;
		String result = restTemplate.getForObject(url, String.class);

		
		logger.info(" Process has Calculated Weather Details");

		JSONObject obj = new JSONObject(result);

		JSONArray weatherArray = obj.getJSONArray("weather");

		JSONObject obj1 = weatherArray.getJSONObject(0);

		weather.setWeatherType(obj1.getString("main"));
		weather.setDetailType(obj1.getString("description"));

		logger.info(" Weather is " + obj1.getString("main") + " Detailed weather is " + obj1.getString("description"));

		JSONObject obj3 = obj.getJSONObject("main");

		weather.setTemp(obj3.getDouble("temp"));

		logger.info(" Temperature is " + obj3.getDouble("temp"));

		return weather;
	}

}
