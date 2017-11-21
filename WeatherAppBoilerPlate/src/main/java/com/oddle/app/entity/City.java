package com.oddle.app.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City implements BaseEntity {

	private static final long serialVersionUID = 7347844908104592136L;

	private String uid;
	private String cityName;
	private Long cityId;

	private Set<Weather> weathers;

	public City() {
		weathers = new HashSet<Weather>(0);
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
	public Set<Weather> getWeathers() {
		return weathers;
	}

	public void setWeathers(Set<Weather> weathers) {
		this.weathers = weathers;
	}

	@Column(name="city_id",nullable = true)
	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	@Id
	@Column(name = "uid", length = 36, unique = true, nullable = false)
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "city_name", nullable = false)
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
