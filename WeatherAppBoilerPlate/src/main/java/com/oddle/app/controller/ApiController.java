package com.oddle.app.controller;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oddle.app.convertion.CityConverter;
import com.oddle.app.entity.City;
import com.oddle.app.entity.Weather;
import com.oddle.app.model.CityModel;
import com.oddle.app.service.CityService;
import com.oddle.app.service.WeatherService;

@RestController
@RequestMapping("/api")
public class ApiController {

	public static final Logger logger = LoggerFactory.getLogger(ApiController.class);

	@Autowired
	private WeatherService weatherService;
	
	@Autowired
	private CityService cityService;
	
    /**
     * This api is used to load current weathers of city by name.
     * 
     * @param name The name of city.
     * @return Boolean.
     */
	@RequestMapping(value = "/weather/current")
    public Boolean getCurrentWeatherAndStoreDatabase(@RequestParam(value="n")String cityName){
		if(!StringUtils.isEmpty(cityName)){
			Boolean value = weatherService.getCurrentWeatherByCityAndStoreIntoDatabase(cityName.trim());
			return value;
		}
        return false;
    }
	
    /**
     * This api is used to add new city.
     * 
     * @param name The name of city.
     * @return Boolean.
     */	
	@RequestMapping("/city/add")
	private Boolean addCity(CityModel model){
		if(model!=null && !StringUtils.isEmpty(model.getCityName())){
			City city = new City();
			city.setUid(UUID.randomUUID().toString());
			city.setCityName(model.getCityName());
			cityService.save(city);
			return true;
		}
		return false;
	}
	
    /**
     * This api is used to load all city.
     * 
     * @return List city.
     */
	@RequestMapping(value = "/cities/")
	@ResponseBody
    public List<CityModel> loadAllCities(){
		return CityConverter.convertEntitiesToModel(cityService.loadAll());
    }
	
    /**
     * This api is used to delete city.
     * 
     * @param uid The uid of city.
     * @return Boolean.
     */
	@RequestMapping("/city/delete")
	public Boolean deleteCity(@RequestParam("uid") String uid){
		City city = cityService.loadOne(uid);
		if(city != null){
			cityService.delete(city);
			return true;
		}
		return false;
	}	
	
    /**
     * This api is used to delete weather.
     * 
     * @param uid The uid of weather.
     * @return Boolean.
     */
	@RequestMapping("/weather/delete")
	public Boolean deleteWeather(@RequestParam("uid") String uid){
		Weather weather = weatherService.loadOne(uid);
		if(weather != null){
			weatherService.delete(weather);
			return true;
		}
		return false;
	}
}