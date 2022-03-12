package com.contact.spring.jwt.mongodb.dto;
/**
 * The Class BaseResponse.
 *
 * @author ronnie.george
 */
public class BaseResponse {

	/** The data. */
	private Object data;
	
	/** The status. */
	private int status;
	
	/** The message. */
	private String message;
	
	/** The error code. */
	private Integer errorCode;
	
	/** The error message. */
	private String errorMessage;

	/**
	 * Instantiates a new base response.
	 *
	 * @param status the status
	 * @param message the message
	 * @param data the data
	 */
	public BaseResponse(int status, String message, Object data) {
		this.data = data;
		this.message = message;
		this.status = status;
	}

	/**
	 * Instantiates a new base response.
	 *
	 * @param status the status
	 * @param message the message
	 */
	public BaseResponse(int status, String message) {
		this.message = message;
		this.status = status;
	}

	/**
	 * Instantiates a new base response.
	 *
	 * @param status the status
	 * @param errorCode the error code
	 * @param errorMessage the error message
	 */
	public BaseResponse(int status, Integer errorCode, String errorMessage) {
		super();
		this.status = status;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * Instantiates a new base response.
	 */
	public BaseResponse() {

	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public Integer getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the error code.
	 *
	 * @param errorCode the new error code
	 */
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the error message.
	 *
	 * @param errorMessage the new error message
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ResponseObj [data=" + data + ", status=" + status + ", message=" + message + ", errorCode=" + errorCode
				+ ", errorMessage=" + errorMessage + "]";
	}

}
