package com.example.currency.exchange.and.discount.calculation.controller;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import com.example.currency.exchange.and.discount.calculation.dto.BillRequest;
import com.example.currency.exchange.and.discount.calculation.service.CurrencyService;
import com.example.currency.exchange.and.discount.calculation.service.DiscountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrencyControllerTest {

    @Mock
    private CurrencyService currencyService;

    @Mock
    private DiscountService discountService;

    @InjectMocks
    private CurrencyController currencyController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateBill() {
        
        BillRequest billRequest = new BillRequest();
        billRequest.setOriginalCurrency("USD");
        billRequest.setTargetCurrency("EUR");
        
        when(currencyService.getExchangeRate("USD", "EUR")).thenReturn(0.85);  
        when(discountService.calculateTotalBill(any(BillRequest.class), any(Double.class))).thenReturn(85.0);  

        double result = currencyController.calculate(billRequest);

        assertEquals(85.0, result); 
    }
}
