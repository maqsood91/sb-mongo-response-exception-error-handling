package com.maqcoding.sbmongoresponseexceptionerrorhandling.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentNotFoundException extends RuntimeException{

	private int errorCode;
	private String errorMessage;
	

	
}
