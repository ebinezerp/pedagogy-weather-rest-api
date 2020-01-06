package pedagogy.restapi.exceptions;

public class DateFormatException extends RuntimeException {

	private String date;

	public DateFormatException(String date) {
		this.date = date;
	}

	@Override
	public String getMessage() {
		return "Date format should be 'yyyyMMdd-hh:mm' not " + date;
	}
}
