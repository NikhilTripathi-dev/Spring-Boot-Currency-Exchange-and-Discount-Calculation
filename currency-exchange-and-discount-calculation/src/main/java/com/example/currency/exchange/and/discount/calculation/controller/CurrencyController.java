package com.example.currency.exchange.and.discount.calculation.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.currency.exchange.and.discount.calculation.dto.BillRequest;
import com.example.currency.exchange.and.discount.calculation.service.CurrencyService;
import com.example.currency.exchange.and.discount.calculation.service.DiscountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;
    private final DiscountService discountService;

	@PostMapping("/calculate")
	public ResponseEntity<Map<String, Double>>  calculate(@RequestBody BillRequest billRequest) {
		double discountTotal = discountService.calculateDiscount(billRequest);
		double exchangeRate = currencyService.getExchangeRate(billRequest.getOriginalCurrency(), billRequest.getTargetCurrency());
		double total = discountTotal * exchangeRate;
		Map<String, Double> response = new HashMap<>();
	    response.put("total", total);
	    return ResponseEntity.ok(response);
	}

}
