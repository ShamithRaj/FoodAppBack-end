package com.cl.foodapp.Exception;


public class ProductNotFound extends RuntimeException {
	String message="Product Not Available";
	@Override
	public String getMessage() {
	
		return message;
	}

}
