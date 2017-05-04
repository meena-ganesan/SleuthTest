package com.test.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

/**
 * Model for Exception Response
 * 
 * @author mganes004c
 * @since 2017-01-07
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionResponse {
	private String errorCode;
	private String errorMessage;
	private HttpStatus httpStatus;
	private String path;
	private Long epochTime;

	public ExceptionResponse(String errorCode, String errorMessage, HttpStatus httpStatus, String path, Long epochTime) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.httpStatus = httpStatus;
		this.path = path;
		this.epochTime = epochTime;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Long getEpochTime() {
		return epochTime;
	}

	public void setEpochTime(Long epochTime) {
		this.epochTime = epochTime;
	}

}
