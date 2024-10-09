package com.example.currency.exchange.and.discount.calculation.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.example.currency.exchange.and.discount.calculation.dto.BillRequest;
import com.example.currency.exchange.and.discount.calculation.dto.Product;
import com.example.currency.exchange.and.discount.calculation.dto.User;
import com.example.currency.exchange.and.discount.calculation.service.DiscountService;

public class DiscountServiceImpl implements DiscountService {

	@Override
	public double calculateTotalBill(BillRequest billRequest, double exchangeRate) {
		double groceryTotal = calculateGroceryTotal(billRequest.getProducts());
		double nonGroceryTotal = calculateNonGroceryTotal(billRequest.getProducts());
		double discountedNonGroceryTotal = applyPercentageDiscount(billRequest.getUser(), nonGroceryTotal);
		double totalBeforeFlatDiscount = groceryTotal + discountedNonGroceryTotal;
		double finalTotal = applyFlatDiscount(totalBeforeFlatDiscount);
		return finalTotal * exchangeRate;
	}

	private double applyFlatDiscount(double total) {
		int discountUnits = (int) (total / 100);
		return total - (discountUnits * 5);
	}

	private double applyPercentageDiscount(User user, double total) {
		if (user.isEmployee()) {
			return total * 0.7;
		} else if (user.isAffiliate()) {
			return total * 0.9;
		} else if (customerTenure(user)) {
			return total * 0.95;
		}
		return total;
	}

	private boolean customerTenure(User user) {
		// based on unique id get user getRegistrationDate details from database
		if (user.getRegistrationDate() == null) {
			return false;
		}
		return ChronoUnit.YEARS.between(user.getRegistrationDate(), LocalDate.now()) > 2;
	}

	private double calculateNonGroceryTotal(List<Product> products) {
		return products.stream().filter(product -> !product.isGrocery()).mapToDouble(Product::getPrice).sum();
	}

	private double calculateGroceryTotal(List<Product> products) {
		return products.stream().filter(Product::isGrocery).mapToDouble(Product::getPrice).sum();
	}

}
