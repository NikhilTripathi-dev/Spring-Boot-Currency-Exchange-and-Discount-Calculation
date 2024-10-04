package com.example.currency.exchange.and.discount.calculation.service;

import com.example.currency.exchange.and.discount.calculation.dto.ExchangeRateResponse;
import com.example.currency.exchange.and.discount.calculation.service.impl.CurrencyServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Map;

public class CurrencyServiceImplTest {

	@InjectMocks
	private CurrencyServiceImpl currencyService;

	@Mock
	private RestTemplate restTemplate;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void getExchangeRate_ShouldReturnCorrectRate() {

		String baseCurrency = "USD";
		String targetCurrency = "EUR";
		double expectedRate = 0.85;

		ExchangeRateResponse response = new ExchangeRateResponse();
		response.setRates(Map.of(targetCurrency, expectedRate));

		when(restTemplate.getForObject(any(String.class), any(Class.class))).thenReturn(response);

		double actualRate = currencyService.getExchangeRate(baseCurrency, targetCurrency);

		assertEquals(expectedRate, actualRate);
	}

	@Test
	public void getExchangeRate_ShouldThrowException_WhenResponseIsNull() {

		String baseCurrency = "USD";
		String targetCurrency = "EUR";

		when(restTemplate.getForObject(any(String.class), any(Class.class))).thenReturn(null);

		RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
			currencyService.getExchangeRate(baseCurrency, targetCurrency);
		});

		assertEquals("Failed to fetch exchange rate for " + targetCurrency, thrown.getMessage());
	}

	@Test
	public void getExchangeRate_ShouldThrowException_WhenRatesAreNull() {

		String baseCurrency = "USD";
		String targetCurrency = "EUR";

		ExchangeRateResponse response = new ExchangeRateResponse();
		response.setRates(null);

		when(restTemplate.getForObject(any(String.class), any(Class.class))).thenReturn(response);

		RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
			currencyService.getExchangeRate(baseCurrency, targetCurrency);
		});

		assertEquals("Failed to fetch exchange rate for " + targetCurrency, thrown.getMessage());
	}

	@Test
	public void getExchangeRate_ShouldThrowException_WhenTargetCurrencyNotInRates() {

		String baseCurrency = "USD";
		String targetCurrency = "EUR";

		ExchangeRateResponse response = new ExchangeRateResponse();
		response.setRates(Map.of("GBP", 0.75));

		when(restTemplate.getForObject(any(String.class), any(Class.class))).thenReturn(response);

		RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
			currencyService.getExchangeRate(baseCurrency, targetCurrency);
		});

		assertEquals("Failed to fetch exchange rate for " + targetCurrency, thrown.getMessage());
	}
}
