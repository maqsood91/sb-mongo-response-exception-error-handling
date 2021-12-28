package com.maqcoding.sbmongoresponseexceptionerrorhandling.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity studentNotfoundException(StudentNotFoundException ex){
		
		ApiResponse apiResponse=new ApiResponse();
		apiResponse.setStatus(ex.getErrorCode());
		apiResponse.setData("");
		apiResponse.setError(ex.getErrorMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
	}
	
	
	
	
	 @Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		    ApiResponse apiResponse=new ApiResponse();
			apiResponse.setStatus(450);
			apiResponse.setData("");
			apiResponse.setError(ex.getMessage());
			
			return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(apiResponse);
	}
	 
	 @ExceptionHandler(Exception.class)
		public ResponseEntity globalException(Exception ex){
			
			ApiResponse apiResponse=new ApiResponse();
			apiResponse.setStatus(400);
			apiResponse.setData("");
			apiResponse.setError(ex.getMessage());
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
		}
		
	
}
