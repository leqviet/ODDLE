package com.oddle.app.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import net.aksingh.owmjapis.CurrentWeather;

public class ValidationUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationUtils.class);

    public static boolean isValidCityName(String cityName) {
    	if(!StringUtils.isEmpty(cityName)){
    		return true;
    	}
    	return false;
    }

    public static boolean isValidWeatherResponse(CurrentWeather cwd) {
        if (!cwd.isValid() || !cwd.hasCityName()
                || !cwd.hasDateTime() || !cwd.hasWeatherInstance()
                || !cwd.hasSysInstance() || !cwd.hasMainInstance()) {
            LOGGER.info("Invalid weather response");
            if (cwd.hasResponseCode()) {
                LOGGER.info("Response code:" + cwd.getResponseCode());
            }
            return false;
        }
        LOGGER.info("Valid weather response received");
        return true;
    }
}
