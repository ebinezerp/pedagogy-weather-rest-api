package pedagogy.restapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import pedagogy.restapi.model.Weather;
import pedagogy.restapi.repository.WeatherRepository;
import pedagogy.restapi.service.WeatherService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class WeatherServiceTest {

	@Mock
	private WeatherRepository weatherRepository;

	@InjectMocks
	private WeatherService weatherService;

	@Test
	public void testGetWeatherByDate() throws ParseException {

		Date date = new SimpleDateFormat("yyyyMMdd-hh:mm").parse("20100105-00:00");

		when(weatherRepository.findByDatetimeUTC(date)).thenReturn(new Weather(date, 0, 1));
		Weather weather = weatherService.getWeatherByDate(date);
		assertEquals(2010, weather.getDatetime_utc().getYear() + 1900);
		assertEquals(05, weather.getDatetime_utc().getDate());
		assertEquals(1, weather.getRain());

		verify(weatherRepository, times(1)).findByDatetimeUTC(date);

	}

	@Test
	public void testGetWeatherByDateFailure() throws ParseException {

		Date date = new SimpleDateFormat("yyyyMMdd-hh:mm").parse("20101005-00:00");

		when(weatherRepository.findByDatetimeUTC(date)).thenReturn(null);
		Weather weather = weatherService.getWeatherByDate(date);

		assertNull(weather);

		verify(weatherRepository, times(1)).findByDatetimeUTC(date);

	}

	
	@Test
	public void testGetWeatherByMonthAndYear() {		

		when(weatherRepository.getByMonthAndYear(10, 2010)).thenReturn(new ArrayList<Weather>());
		assertNotNull(weatherService.getWeatherByMonthAndYear(10, 2010));
		verify(weatherRepository, times(1)).getByMonthAndYear(10, 2010);

	}
}
