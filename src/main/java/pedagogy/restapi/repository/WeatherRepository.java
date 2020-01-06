package pedagogy.restapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pedagogy.restapi.model.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Date> {

	public List<Weather> findByConds(String condition);

	@Query("select w from Weather w where month(w.datetime_utc)=:month and year(w.datetime_utc)=:year")
	public List<Weather> getByMonthAndYear(@Param("month") Integer month,
			@Param("year") Integer year);

	@Query("select w from Weather w where w.datetime_utc=:date")
	public Weather findByDatetimeUTC(@Param("date") Date date);
}
