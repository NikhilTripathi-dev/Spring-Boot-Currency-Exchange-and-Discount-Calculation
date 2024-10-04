package com.example.currency.exchange.and.discount.calculation.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.example.currency.exchange.and.discount.calculation.dto.BillRequest;
import com.example.currency.exchange.and.discount.calculation.service.CurrencyService;
import com.example.currency.exchange.and.discount.calculation.service.DiscountService;

public class CurrencyControllerTest {

    @InjectMocks
    private CurrencyController currencyController;

    @Mock
    private CurrencyService currencyService;

    @Mock
    private DiscountService discountService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void calculate_ShouldReturnPayableAmount() {
       
        BillRequest request = new BillRequest();
        request.setTotalAmount(100.0);         request.setUserType("EMPLOYEE"); 
        request.setGrocery(false); 
        request.setCustomerTenure(3); 
        request.setOriginalCurrency("USD");
        request.setTargetCurrency("EUR");
        when(discountService.calculateDiscount(100.0, "EMPLOYEE", false, 3)).thenReturn(70.0);
        when(currencyService.getExchangeRate("USD", "EUR")).thenReturn(0.85);

        ResponseEntity<Double> response = currencyController.calculate(request);
        assertEquals(ResponseEntity.ok(59.5), response);
    }
}