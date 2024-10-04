package com.example.currency.exchange.and.discount.calculation.service.impl;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.currency.exchange.and.discount.calculation.dto.ExchangeRateResponse;
import com.example.currency.exchange.and.discount.calculation.service.CurrencyService;

public class CurrencyServiceImpl implements CurrencyService {

	private final String API_KEY = "your-api-key";
	private final String BASE_URL = "https://open.er-api.com/v6/latest/";

	@Override
	public double getExchangeRate(String baseCurrency, String targetCurrency) {
		String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + baseCurrency).queryParam("apikey", API_KEY)
				.toUriString();
		RestTemplate restTemplate = new RestTemplate();
		ExchangeRateResponse response = restTemplate.getForObject(url, ExchangeRateResponse.class);
		if (response != null && response.getRates() != null && response.getRates().containsKey(targetCurrency)) {
			return response.getRates().get(targetCurrency);
		} else {
			throw new RuntimeException("Failed to fetch exchange rate for " + targetCurrency);
		}
	}
}
