package com.example.currency.exchange.and.discount.calculation.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.example.currency.exchange.and.discount.calculation.dto.BillRequest;
import com.example.currency.exchange.and.discount.calculation.dto.Product;
import com.example.currency.exchange.and.discount.calculation.dto.User;
import com.example.currency.exchange.and.discount.calculation.service.impl.DiscountServiceImpl;

public class DiscountServiceImplTest {

	@InjectMocks
	private DiscountServiceImpl discountService;

	@BeforeEach
	public void setUp() {
		discountService = new DiscountServiceImpl();
	}

	@Test
	public void testCalculateTotalBill_withEmployeeDiscount() {

		User user = new User();
		user.setEmployee(true);
		user.setRegistrationDate(LocalDate.now().minusYears(3));

		Product product1 = new Product("Laptop", 300.0, false);
		Product product2 = new Product("Charger", 20.0, false);

		List<Product> productList = Arrays.asList(product1, product2);
		BillRequest billRequest = new BillRequest(user, productList, "USD", "EUR");

		double exchangeRate = 0.85;

		double finalAmount = discountService.calculateTotalBill(billRequest, exchangeRate);

		double nonGroceryTotal = product1.getPrice() + product2.getPrice();
		double discountedTotal = nonGroceryTotal * 0.7;
		discountedTotal = applyFlatDiscount(discountedTotal);
		double expectedTotal = discountedTotal * exchangeRate;

		assertEquals(expectedTotal, finalAmount, 0.001);
	}

	@Test
	public void testCalculateTotalBill_withAffiliateDiscount() {

		User user = new User();
		user.setAffiliate(true);

		Product product1 = new Product("TV", 400.0, false);
		Product product2 = new Product("Sofa", 600.0, false);

		List<Product> productList = Arrays.asList(product1, product2);
		BillRequest billRequest = new BillRequest(user, productList, "USD", "EUR");

		double exchangeRate = 0.85;

		double finalAmount = discountService.calculateTotalBill(billRequest, exchangeRate);

		double expectedTotal = (400.0 + 600.0) * 0.9;
		expectedTotal = applyFlatDiscount(expectedTotal);
		expectedTotal *= exchangeRate;

		assertEquals(expectedTotal, finalAmount, 0.001);
	}

	@Test
	public void testCalculateTotalBill_withLoyalCustomerDiscount() {

		User user = new User();
		user.setRegistrationDate(LocalDate.now().minusYears(3));

		Product product1 = new Product("Microwave", 150.0, false);

		List<Product> productList = Arrays.asList(product1);
		BillRequest billRequest = new BillRequest(user, productList, "USD", "EUR");

		double exchangeRate = 0.85;

		double finalAmount = discountService.calculateTotalBill(billRequest, exchangeRate);

		double expectedTotal = 150.0 * 0.95;
		expectedTotal = applyFlatDiscount(expectedTotal);
		expectedTotal *= exchangeRate;

		assertEquals(expectedTotal, finalAmount, 0.001);
	}

	@Test
	public void testCalculateTotalBill_withNoDiscount() {

		User user = new User();

		Product product1 = new Product("Bread", 10.0, true);
		Product product2 = new Product("Milk", 5.0, true);

		List<Product> productList = Arrays.asList(product1, product2);
		BillRequest billRequest = new BillRequest(user, productList, "USD", "EUR");

		double exchangeRate = 0.85;

		double finalAmount = discountService.calculateTotalBill(billRequest, exchangeRate);

		double expectedTotal = 10.0 + 5.0;
		expectedTotal = applyFlatDiscount(expectedTotal);
		expectedTotal *= exchangeRate;

		assertEquals(expectedTotal, finalAmount, 0.001);
	}

	private double applyFlatDiscount(double total) {
		int discountUnits = (int) (total / 100);
		return total - (discountUnits * 5);
	}
}
