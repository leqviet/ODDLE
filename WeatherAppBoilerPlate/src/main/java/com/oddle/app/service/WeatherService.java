package com.oddle.app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.oddle.app.entity.City;
import com.oddle.app.entity.Weather;
import com.oddle.app.model.WeatherReport;
import com.oddle.app.repositories.CityRepository;
import com.oddle.app.repositories.WeatherRepository;
import com.oddle.app.utils.ValidationUtils;

import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.CurrentWeather.Main;
import net.aksingh.owmjapis.OpenWeatherMap;

@Service
public class WeatherService{

	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherService.class);
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private WeatherRepository weatherRepository;
	
	@Value("${weather.api.key}")
	private String openWeatherMapApiKey;
	
    private OpenWeatherMap owm;
    
    public Weather loadOne(String uid){
    	return weatherRepository.findOne(uid);
    }
    
    public void delete(Weather entity){
    	weatherRepository.delete(entity);
    }
    
    public List<WeatherReport> loadAllWeathers(){
    	return loadAllWeathersByCityName(null);
    }
    
    public List<WeatherReport> loadAllWeathersByCityName(String name){
    	List<WeatherReport> weatherReports = new ArrayList<WeatherReport>();
    	List<City> cities = null;
    	if(StringUtils.isEmpty(name)){
    		cities = cityRepository.findAll();
    	}else{
    		cities = cityRepository.findByCityNameLike("%"+name+"%");
    	}
    	
		if (cities != null) {
			for (City qc : cities) {
				if (qc != null) {
					WeatherReport wr = new WeatherReport();
					wr.setCityName(qc.getCityName());
					wr.setWeathers(weatherRepository.findByCity(qc));
					weatherReports.add(wr);
				}
			}
		}	
    	return weatherReports;
    }
    
    public Boolean getCurrentWeatherByCityAndStoreIntoDatabase(String name) {
        CurrentWeather cwm;
        owm = new OpenWeatherMap(openWeatherMapApiKey);        
        if(!ValidationUtils.isValidCityName(name)) {
            return false;
        }
        try {
        	cwm = owm.currentWeatherByCityName(name);
			if(ValidationUtils.isValidWeatherResponse(cwm)){
				City city = cityRepository.findByCityId(cwm.getCityCode());
				if(city == null){
					city = new City();
					city.setUid(UUID.randomUUID().toString());
					city.setCityName(cwm.getCityName());
					city.setCityId(cwm.getCityCode());
					cityRepository.save(city);
				}
				
				Weather weather = new Weather();
				weather.setUid(UUID.randomUUID().toString());
				weather.setCity(city);
				
				Main main = cwm.getMainInstance();
				weather.setHumidity(main!=null ? main.getHumidity():0);
				weather.setMaximumTemperature(main!=null ? main.getMaxTemperature():0);
				weather.setMinimumTemperature(main!=null ? main.getMinTemperature():0);
				weather.setPressure(main!=null ? main.getPressure():0);
				
				weather.setSpeed(cwm.getWindInstance().getWindSpeed());
				weather.setDate(cwm.getDateTime());
				weather.setDescription(cwm.getWeatherInstance(0).getWeatherDescription());
				weather.setIcon(cwm.getWeatherInstance(0).getWeatherIconName());
				weather.setPercentCloud(cwm.getCloudsInstance().getPercentageOfClouds());
				weatherRepository.save(weather);
				return true;

			}
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		} catch (JSONException e) {
			LOGGER.error(e.getMessage());;
		}
        return false;
    }
}
