package com.example.currency.exchange.and.discount.calculation.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class DiscountServiceTest {

	@InjectMocks
    private DiscountService discountService;

    @BeforeEach
    public void setUp() {
        discountService = new DiscountService(); 
    }

    @Test
    public void testCalculateDiscount_Employee() {
        double totalAmount = 200.0;
        String userType = "EMPLOYEE";
        boolean isGrocery = false;
        int customerTenure = 1;

        double expectedAmount = totalAmount * (1 - 0.30) - (2 * 5); 
        double actualAmount = discountService.calculateDiscount(totalAmount, userType, isGrocery, customerTenure);

        assertEquals(expectedAmount, actualAmount, 0.01);
    }

    @Test
    public void testCalculateDiscount_Affiliate() {
        double totalAmount = 150.0;
        String userType = "AFFILIATE";
        boolean isGrocery = false;
        int customerTenure = 1; 

        double expectedAmount = totalAmount * (1 - 0.10) - (1 * 5); 
        double actualAmount = discountService.calculateDiscount(totalAmount, userType, isGrocery, customerTenure);

        assertEquals(expectedAmount, actualAmount, 0.01);
    }

    @Test
    public void testCalculateDiscount_LoyalCustomer_Eligible() {
        double totalAmount = 300.0;
        String userType = "LOYAL_CUSTOMER";
        boolean isGrocery = false;
        int customerTenure = 3;

        double expectedAmount = totalAmount * (1 - 0.05) - (3 * 5); 
        double actualAmount = discountService.calculateDiscount(totalAmount, userType, isGrocery, customerTenure);

        assertEquals(expectedAmount, actualAmount, 0.01);
    }

    @Test
    public void testCalculateDiscount_LoyalCustomer_NotEligible() {
        double totalAmount = 300.0;
        String userType = "LOYAL_CUSTOMER";
        boolean isGrocery = false;
        int customerTenure = 2; 

        double expectedAmount = totalAmount - (3 * 5); 
        double actualAmount = discountService.calculateDiscount(totalAmount, userType, isGrocery, customerTenure);

        assertEquals(expectedAmount, actualAmount, 0.01);
    }

    @Test
    public void testCalculateDiscount_Grocery() {
        double totalAmount = 150.0;
        String userType = "EMPLOYEE";
        boolean isGrocery = true;
        int customerTenure = 1;

        double expectedAmount = totalAmount; 
        double actualAmount = discountService.calculateDiscount(totalAmount, userType, isGrocery, customerTenure);

        assertEquals(expectedAmount, actualAmount, 0.01);
    }
}
