package pedagogy.restapi;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import pedagogy.restapi.model.Weather;
import pedagogy.restapi.service.WeatherService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class WeatherControllerTest {

	@Mock
	private WeatherService weatherService;

	@Autowired
	MockMvc mockMvc;

	@Test
	public void getWeatherByDate() throws Exception {

		Date date = new SimpleDateFormat("yyyyMMdd-00:00").parse("20100105-00:00");
		when(weatherService.getWeatherByDate(date)).thenReturn(new Weather());

		mockMvc.perform(get("/api/weather-report/date/20100105-00:00")).andExpect(status().isOk());

		verify(weatherService, times(1)).getWeatherByDate(date);
	}

}
