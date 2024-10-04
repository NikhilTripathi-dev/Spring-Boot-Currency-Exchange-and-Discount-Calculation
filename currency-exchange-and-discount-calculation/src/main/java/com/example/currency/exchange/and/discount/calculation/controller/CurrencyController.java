package com.example.currency.exchange.and.discount.calculation.controller;

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
	public ResponseEntity<Double> calculate(@RequestBody BillRequest request) {
		double discountTotal = discountService.calculateDiscount(request.getTotalAmount(), request.getUserType(),
				request.isGrocery(), request.getCustomerTenure());
		double exchangeRate = currencyService.getExchangeRate(request.getOriginalCurrency(),
				request.getTargetCurrency());
		double payableAmount = discountTotal * exchangeRate;

		return ResponseEntity.ok(payableAmount);
	}

}
