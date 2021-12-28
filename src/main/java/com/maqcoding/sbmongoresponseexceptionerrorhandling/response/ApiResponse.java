package com.maqcoding.sbmongoresponseexceptionerrorhandling.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ApiResponse {

	private int status;
	private Object data;
	private Object error;
}
