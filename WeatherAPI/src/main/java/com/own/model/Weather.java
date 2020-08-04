package com.own.model;

public class Weather {
	private String weatherType;
	private String detailType;
	private double temp;

	/**
	 * @return the weatherType
	 */
	public String getWeatherType() {
		return weatherType;
	}

	/**
	 * @return the detailType
	 */
	public String getDetailType() {
		return detailType;
	}

	/**
	 * @return the temp
	 */
	public double getTemp() {
		return Math.round(temp-273);
	}

	/**
	 * @param weatherType the weatherType to set
	 */
	public void setWeatherType(String weatherType) {
		this.weatherType = weatherType;
	}

	/**
	 * @param detailType the detailType to set
	 */
	public void setDetailType(String detailType) {
		this.detailType = detailType;
	}

	/**
	 * @param temp the temp to set
	 */
	public void setTemp(double temp) {
		this.temp = temp;
	}

	@Override
	public String toString() {
		return "Weather [weatherType=" + weatherType + ", detailType=" + detailType + ", temp=" + temp + "]";
	}
}
