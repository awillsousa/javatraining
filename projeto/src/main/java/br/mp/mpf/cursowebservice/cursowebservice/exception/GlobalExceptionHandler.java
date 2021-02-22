package br.mp.mpf.cursowebservice.cursowebservice.exception;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.mp.mpf.cursowebservice.cursowebservice.model.ApiErrors;

@ControllerAdvice
//@Profile("hml")
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	//@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errorsMessages = new ArrayList<>();

		BindingResult bindingResult = ex.getBindingResult();
		bindingResult.getAllErrors().forEach(objectError -> errorsMessages.add(objectError.getDefaultMessage()));

		ApiErrors apiErrors = ApiErrors.builder()
				.code(status.toString())
				.messages(errorsMessages)
				.timestamp(Instant.now())
				.errorCount(ex.getErrorCount())
				.build();

		return new ResponseEntity(apiErrors, status);
	}

}
