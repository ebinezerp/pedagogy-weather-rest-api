package pedagogy.restapi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class FormDate {

	public Date parse(String date) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-hh:mm");
		return simpleDateFormat.parse(date);
	}

}
