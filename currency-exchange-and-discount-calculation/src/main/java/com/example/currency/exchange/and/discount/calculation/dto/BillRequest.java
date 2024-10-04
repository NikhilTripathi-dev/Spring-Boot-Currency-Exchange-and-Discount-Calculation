package com.example.currency.exchange.and.discount.calculation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class BillRequest {
	
	private double totalAmount;
	private String userType;
	private boolean isGrocery;
	private int customerTenure;
	private String originalCurrency;
	private String targetCurrency;

}
