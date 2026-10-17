package com.security.response;

import org.springframework.http.HttpStatus;

public class ResponseMessage<T> {

    private String messageContent;
    private String statusCode;
    private HttpStatus status;
    private T data;
    
	public ResponseMessage(String messageContent, String statusCode, T data, HttpStatus status) {
		this.messageContent = messageContent;
		this.statusCode = statusCode;
		this.data = data;
		this.status = status;
	}
    
	public ResponseMessage(String messageContent, String statusCode, T data) {
		this.messageContent = messageContent;
		this.statusCode = statusCode;
		this.data = data;
	}
	
    
	public ResponseMessage(String messageContent, String statusCode, HttpStatus status) {
		this.messageContent = messageContent;
		this.statusCode = statusCode;
		this.status = status;
	}
	
	public ResponseMessage(String messageContent, String statusCode) {
		this.messageContent = messageContent;
		this.statusCode = statusCode;
	}
	
	public ResponseMessage(String messageContent, HttpStatus status) {
		this.messageContent = messageContent;
		this.status = status;
	}

	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

}
