package com.example.currency.exchange.and.discount.calculation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.currency.exchange.and.discount.calculation.service.CurrencyService;
import com.example.currency.exchange.and.discount.calculation.service.DiscountService;

@SpringBootTest
class CurrencyExchangeAndDiscountCalculationApplicationTests {

	@MockBean
	private CurrencyService currencyService;

	@MockBean
	private DiscountService discountService;

	@Test
	void contextLoads() {

	}

}
