package pedagogy.restapi.exceptions;

import java.text.ParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value= {ParseException.class})
	public ResponseEntity<String> dateFormatException(DateFormatException dateFormatException){
		return new ResponseEntity<String>(dateFormatException.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
}
