package com.example.currency.exchange.and.discount.calculation.service.impl;

import com.example.currency.exchange.and.discount.calculation.service.DiscountService;

public class DiscountServiceImpl implements DiscountService {

	@Override
	public double calculateDiscount(double totalAmount, String userType, boolean isGrocery, int customerTenure) {
		double discount = 0;

		if (!isGrocery) {
			switch (userType) {
			case "EMPLOYEE":
				discount = 0.30;
				break;
			case "AFFILIATE":
				discount = 0.10;
				break;
			case "LOYAL_CUSTOMER":
				if (customerTenure > 2) {
					discount = 0.05;
				}
				break;
			}
		}

		int hundredBlocks = (int) (totalAmount / 100);
		double flatDiscount = hundredBlocks * 5;

		return totalAmount * (1 - discount) - flatDiscount;
	}

}
