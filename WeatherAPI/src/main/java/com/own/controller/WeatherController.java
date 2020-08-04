package com.own.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.own.model.Location;
import com.own.model.Weather;
import com.own.service.IPServiceImpl;
import com.own.service.LocationServiceImpl;
import com.own.service.WeatherServiceImpl;

@RestController
public class WeatherController {

	@Autowired
	private IPServiceImpl iPServiceImpl;

	@Autowired
	private LocationServiceImpl locationServiceImpl;

	@Autowired
	private WeatherServiceImpl weatherServiceImpl;

	@GetMapping("/weatherView")
	public Weather calculateWeather() {
		Weather weather = null;
		try {
			String ipAddress = iPServiceImpl.getIpOfDevice();
			Location location = locationServiceImpl.findLocation(ipAddress);
			weather = weatherServiceImpl.getWeatherDetails(location);

		} catch (Exception e) {
			System.out.println("Exception occured : " + e);
		}
		return weather;

	}

}
