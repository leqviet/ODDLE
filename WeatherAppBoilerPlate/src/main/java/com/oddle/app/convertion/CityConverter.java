package com.oddle.app.convertion;

import java.util.ArrayList;
import java.util.List;

import com.oddle.app.entity.City;
import com.oddle.app.model.CityModel;

public class CityConverter {

	public static List<CityModel> convertEntitiesToModel(List<City> entities) {
		if (entities == null) {
			return null;
		}

		List<CityModel> models = new ArrayList<CityModel>();
		for (City c : entities) {
			models.add(CityConverter.convertEntityToModel(c));
		}
		return models;

	}

	public static CityModel convertEntityToModel(City entity) {
		if (entity == null) {
			return null;
		}
		CityModel model = new CityModel();
		model.setUid(entity.getUid());
		model.setCityName(entity.getCityName());
		return model;

	}
}
