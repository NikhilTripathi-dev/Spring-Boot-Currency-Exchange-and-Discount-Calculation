package com.example.currency.exchange.and.discount.calculation.service;

import com.example.currency.exchange.and.discount.calculation.service.impl.DiscountServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountServiceImplTest {

	private DiscountService discountService;

	@BeforeEach
	public void setUp() {
		discountService = new DiscountServiceImpl();
	}

	@Test
	public void calculateDiscount_ShouldApplyEmployeeDiscount() {

		double totalAmount = 200.0;
		String userType = "EMPLOYEE";
		boolean isGrocery = false;
		int customerTenure = 1;

		double result = discountService.calculateDiscount(totalAmount, userType, isGrocery, customerTenure);

		assertEquals(135.0, result);
	}

	@Test
	public void calculateDiscount_ShouldApplyAffiliateDiscount() {

		double totalAmount = 200.0;
		String userType = "AFFILIATE";
		boolean isGrocery = false;
		int customerTenure = 1;

		double result = discountService.calculateDiscount(totalAmount, userType, isGrocery, customerTenure);

		assertEquals(145.0, result);
	}

	@Test
	public void calculateDiscount_ShouldApplyLoyalCustomerDiscount() {

		double totalAmount = 200.0;
		String userType = "LOYAL_CUSTOMER";
		boolean isGrocery = false;
		int customerTenure = 3;

		double result = discountService.calculateDiscount(totalAmount, userType, isGrocery, customerTenure);

		assertEquals(175.0, result);
	}

	@Test
	public void calculateDiscount_ShouldNotApplyDiscountForGrocery() {

		double totalAmount = 200.0;
		String userType = "EMPLOYEE";
		boolean isGrocery = true;
		int customerTenure = 1;

		double result = discountService.calculateDiscount(totalAmount, userType, isGrocery, customerTenure);

		assertEquals(200.0, result);
	}

	@Test
	public void calculateDiscount_ShouldApplyFlatDiscount() {

		double totalAmount = 250.0;
		String userType = "EMPLOYEE";
		boolean isGrocery = false;
		int customerTenure = 1;

		double result = discountService.calculateDiscount(totalAmount, userType, isGrocery, customerTenure);

		assertEquals(165.0, result);
	}

	@Test
	public void calculateDiscount_ShouldHandleZeroAmount() {

		double totalAmount = 0.0;
		String userType = "EMPLOYEE";
		boolean isGrocery = false;
		int customerTenure = 1;

		double result = discountService.calculateDiscount(totalAmount, userType, isGrocery, customerTenure);

		assertEquals(0.0, result);
	}

}
