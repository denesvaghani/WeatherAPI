package com.own.service;

import com.own.model.Location;
import com.own.model.Weather;

public interface WeatherService {
	public Weather getWeatherDetails(Location location);
}
