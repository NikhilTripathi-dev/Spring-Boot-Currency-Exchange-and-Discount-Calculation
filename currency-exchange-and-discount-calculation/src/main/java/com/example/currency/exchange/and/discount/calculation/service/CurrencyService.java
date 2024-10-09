package com.example.currency.exchange.and.discount.calculation.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.currency.exchange.and.discount.calculation.dto.ExchangeRateResponse;

@Service
public class CurrencyService{

	private final String API_KEY = "your-api-key";
	private final String BASE_URL = "https://open.er-api.com/v6/latest/";
	private final RestTemplate restTemplate;

	public CurrencyService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}


	@Cacheable(value = "exchangeRates", key = "#request.baseCurrency + '_' + #request.targetCurrency")
	public double getExchangeRate(String baseCurrency, String targetCurrency) {
		String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + baseCurrency).queryParam("apikey", API_KEY)
				.toUriString();
		ExchangeRateResponse response = restTemplate.getForObject(url, ExchangeRateResponse.class);
		if (response != null && response.getRates() != null && response.getRates().containsKey(targetCurrency)) {
			return response.getRates().get(targetCurrency);
		} else {
			throw new RuntimeException("Failed to fetch exchange rate for " + targetCurrency);
		}
	}
}
