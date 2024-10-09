package com.example.currency.exchange.and.discount.calculation.controller;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.currency.exchange.and.discount.calculation.service.CurrencyService;
import com.example.currency.exchange.and.discount.calculation.service.DiscountService;

@SpringBootTest 
@AutoConfigureMockMvc
public class CurrencyControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Mock
    private CurrencyService currencyService;

    @Mock
    private DiscountService discountService;

    @BeforeEach
    public void setUp() {
    	 MockitoAnnotations.openMocks(this);
         when(discountService.calculateDiscount(150.0, "EMPLOYEE", false, 3)).thenReturn(135.0);
         when(currencyService.getExchangeRate("USD", "EUR")).thenReturn(0.85);
    }

    @Test
    public void testCalculatePayableAmount() throws Exception {
        String requestBody = "{\"totalAmount\": 150.0, \"userType\": \"EMPLOYEE\", \"isGrocery\": false, \"customerTenure\": 3, \"originalCurrency\": \"USD\", \"targetCurrency\": \"EUR\"}";

        mockMvc.perform(post("/api/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
        )
        .andExpect(status().isOk());
    }
}
