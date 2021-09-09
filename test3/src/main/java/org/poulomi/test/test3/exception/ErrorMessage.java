package org.poulomi.test.test3.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

	int errorCode;
	String errorMessage;
	String description;
	
	public ErrorMessage() {
		
	}

	public ErrorMessage(int errorCode, String errorMessage, String description) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.description = description;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
