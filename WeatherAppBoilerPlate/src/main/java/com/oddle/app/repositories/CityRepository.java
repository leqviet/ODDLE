package com.oddle.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oddle.app.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, String> {

	public City findByCityId(Long cityId);

	public List<City> findByCityNameLike(String name);

}
