package com.oddle.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "weather")
public class Weather implements BaseEntity {

	private static final long serialVersionUID = 8408589639722253829L;
	private String uid;
	private double pressure; 
	private double humidity;
	private double minimumTemperature;
	private double maximumTemperature;
	private Date date;
	private double speed;
	private String description;
	private String icon;
	private double percentCloud;
	
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "city_uid", nullable = false)
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Column(name = "percent_cloud")
	public double getPercentCloud() {
		return percentCloud;
	}

	public void setPercentCloud(double percentCloud) {
		this.percentCloud = percentCloud;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public double getHumidity() {
		return humidity;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "min_temp")
	public double getMinimumTemperature() {
		return minimumTemperature;
	}

	public void setMinimumTemperature(double minimumTemperature) {
		this.minimumTemperature = minimumTemperature;
	}

	@Column(name = "max_temp")
	public double getMaximumTemperature() {
		return maximumTemperature;
	}

	public void setMaximumTemperature(double maximumTemperature) {
		this.maximumTemperature = maximumTemperature;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}



	@Id
	@Column(name = "uid", length = 36, unique = true, nullable = false)
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}
