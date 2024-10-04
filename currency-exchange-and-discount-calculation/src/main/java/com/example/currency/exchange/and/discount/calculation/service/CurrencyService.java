package com.example.currency.exchange.and.discount.calculation.service;

import org.springframework.stereotype.Service;

@Service
public interface CurrencyService {

	public double getExchangeRate(String baseCurrency, String targetCurrency);
}
