package com.oddle.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oddle.app.entity.City;
import com.oddle.app.entity.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, String> {

	public List<Weather> findByCity(City city);
}
