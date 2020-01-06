package pedagogy.restapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import pedagogy.restapi.repository.WeatherRepository;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class WeatherRepositoryTest {

	@Autowired
	private WeatherRepository weatherRepository;

	@Test
	public void testGetWeatherByDate() throws ParseException {
		assertNotNull(weatherRepository
				.findByDatetimeUTC(new SimpleDateFormat("yyyyMMdd-hh:mm").parse("20100105-00:00")));
	}

	@Test
	public void testGetWeatherByDateFailure() throws ParseException {
		assertNull(weatherRepository
				.findByDatetimeUTC(new SimpleDateFormat("yyyyMMdd-hh:mm").parse("20101105-00:00")));
	}

	@Test
	public void testGetWeatherByMonthAndYear() {
		assertNotNull(weatherRepository.getByMonthAndYear(01, 2010));
	}

	@Test
	public void testGetWeatherByMonthAndYearFailure() {
		assertEquals(0, weatherRepository.getByMonthAndYear(10, 2010).size());
	}

}
