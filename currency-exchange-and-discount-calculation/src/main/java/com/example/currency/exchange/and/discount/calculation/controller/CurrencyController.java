package com.example.currency.exchange.and.discount.calculation.controller;

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
	public double calculate(@RequestBody BillRequest billRequest) {
		double exchangeRate = currencyService.getExchangeRate(billRequest.getOriginalCurrency(), billRequest.getTargetCurrency());
        return discountService.calculateTotalBill(billRequest, exchangeRate);
	}

}
