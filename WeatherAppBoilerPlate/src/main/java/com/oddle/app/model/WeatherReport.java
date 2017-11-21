package com.oddle.app.model;

import java.util.List;

import com.oddle.app.entity.Weather;

public class WeatherReport {

	private String cityName;

	private List<Weather> weathers;

	public List<Weather> getWeathers() {
		return weathers;
	}

	public void setWeathers(List<Weather> weathers) {
		this.weathers = weathers;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
