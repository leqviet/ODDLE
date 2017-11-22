package com.oddle.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oddle.app.model.WeatherReport;
import com.oddle.app.service.WeatherService;

@Controller
public class HomeController {

	@Autowired
	private WeatherService weatherService;

    /**
     * Load home page.
     */
	@RequestMapping("/")
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("index");
		return mv;
	}

    /**
     * Load list page.
     */
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mv) {
		mv.setViewName("index");
		return mv;
	}

    /**
     * Load city page.
     */
	@RequestMapping(value = "/city", method = RequestMethod.GET)
	public ModelAndView myPage(ModelAndView mv) {
		mv.setViewName("city");
		return mv;
	}

	@RequestMapping("/weather/list")
	public ModelAndView loadAllWeathers(ModelAndView mv, @RequestParam(value = "n", required = false) String name) {
		List<WeatherReport> weatherReports = null;
		if (StringUtils.isEmpty(name)) {
			weatherReports = weatherService.loadAllWeathers();
		} else {
			weatherReports = weatherService.loadAllWeathersByCityName(name);
		}
		mv.addObject("weatherReports", weatherReports);
		mv.setViewName("list");
		return mv;
	}
}
