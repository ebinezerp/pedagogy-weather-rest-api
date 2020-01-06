package pedagogy.restapi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pedagogy.restapi.exceptions.DateFormatException;
import pedagogy.restapi.model.Weather;
import pedagogy.restapi.service.WeatherService;
import pedagogy.restapi.util.FormDate;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/weather-report")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@Autowired
	private FormDate formDate;

	@GetMapping("/condition/{condition}")
	public ResponseEntity<List<Weather>> getWeatherByCondition(
			@PathVariable("condition") String condition) {
		return new ResponseEntity<List<Weather>>(weatherService.getWeather(condition),
				HttpStatus.OK);
	}

	@GetMapping("/{month}/{year}")
	public ResponseEntity<List<Weather>> getWeatherByMonthAndYear(
			@PathVariable("month") Integer month, @PathVariable("year") Integer year) {
		return new ResponseEntity<List<Weather>>(
				weatherService.getWeatherByMonthAndYear(month, year), HttpStatus.OK);
	}

	@GetMapping("/date/{date}")
	public ResponseEntity<Weather> getWeatherByDate(@PathVariable("date") String date) {
		try {
			return new ResponseEntity<Weather>(
					weatherService.getWeatherByDate(formDate.parse(date)), HttpStatus.OK);
		} catch (ParseException e) {
			throw new DateFormatException(date);
		}

	}

}
