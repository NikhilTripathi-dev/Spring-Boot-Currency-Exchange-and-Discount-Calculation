package com.example.currency.exchange.and.discount.calculation.service;

import org.springframework.stereotype.Service;

@Service
public interface DiscountService {

	public double calculateDiscount(double totalAmount, String userType, boolean isGrocery, int customerTenure);

}
