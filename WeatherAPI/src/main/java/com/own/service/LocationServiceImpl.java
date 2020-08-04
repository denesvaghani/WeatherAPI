package com.own.service;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.own.model.Location;

@Service
public class LocationServiceImpl implements LocationService {

	private static final Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);

	@Value("${ipApi}")
	private String serverName;

	@Value("${Iptoken} ")
	private String ipToken;


	@Override
	public Location findLocation(String ipAddress) {

		logger.info(" Process is finding Location from the IP Address... ");

		RestTemplate restTamplete = new RestTemplate();
		Location location = new Location();
		
		String result = restTamplete.getForObject(serverName + ipAddress + ipToken.trim(), String.class);
		
		logger.info(" Process has founded Location from the IP Address " + result);
		
		JSONObject obj = new JSONObject(result);
		
		location.setLongitude(obj.getString("longitude"));
		location.setLatitude(obj.getString("latitude"));
		
		logger.info(" Longitude is : " + obj.getString("longitude"));
		logger.info(" Latitude is : " + obj.getString("latitude"));
		
		return location;
	}

}
