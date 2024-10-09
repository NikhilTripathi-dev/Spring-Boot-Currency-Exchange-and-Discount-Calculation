package com.example.currency.exchange.and.discount.calculation.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillRequest {

	private int billId;
	private List<Product> products;
	private User user;
	private String originalCurrency;
	private String targetCurrency;
	
	public BillRequest(int billId, List<Product> asList, User user2, Object originalCurrency2,
			Object targetCurrency2) {
	}
	

}
