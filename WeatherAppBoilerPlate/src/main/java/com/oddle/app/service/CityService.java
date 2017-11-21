package com.oddle.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oddle.app.entity.City;
import com.oddle.app.repositories.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;
	
	public void save(City entity){
		cityRepository.save(entity);
	}
	
	public List<City> loadAll(){
		return cityRepository.findAll();
	}
	
	public City loadOne(String uid){
		return cityRepository.findOne(uid);
	}
	
	public void delete(City entity){
		entity.getWeathers().clear();
		cityRepository.delete(entity);
	}
}
