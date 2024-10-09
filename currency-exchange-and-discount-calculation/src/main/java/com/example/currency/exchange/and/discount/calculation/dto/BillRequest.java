package com.example.currency.exchange.and.discount.calculation.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillRequest {

	private double totalAmount;
	private List<Product> products;
	private User user;
	private String originalCurrency;
	private String targetCurrency;
	
	 public BillRequest(User user, List<Product> products, String originalCurrency, String targetCurrency) {
	        this.user = user;
	        this.products = products;
	        this.originalCurrency = originalCurrency;
	        this.targetCurrency = targetCurrency;
	    }

}
