package pedagogy.restapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather {

	@Id
	private Date datetime_utc;
	private Integer conds;
	private Integer dewptm;
	private Integer fog;
	private Integer hail;
	private Integer hum;
	private Integer precipm;
	private Integer pressurem;
	private Integer rain;
	private Integer snow;
	private Integer tempm;
	private Integer thunder;
	private Integer tornado;
	private Integer wdire;
	private String city;
	
	
	public Weather(Date datetime_utc,Integer conds,Integer rain) {
		this.datetime_utc = datetime_utc;
		this.conds = conds;
		this.rain = rain;
	}
	

}
