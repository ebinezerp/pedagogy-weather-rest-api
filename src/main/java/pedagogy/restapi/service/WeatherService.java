package pedagogy.restapi.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pedagogy.restapi.model.Weather;
import pedagogy.restapi.repository.WeatherRepository;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository weatherRepository;

	public List<Weather> getWeather(String condition) {
		try {
			return weatherRepository.findByConds(condition);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Weather getWeatherByDate(Date date) {
		try {
			return weatherRepository.findByDatetimeUTC(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Weather> getWeatherByMonthAndYear(Integer month, Integer year) {
		try {
			return weatherRepository.getByMonthAndYear(month, year);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
