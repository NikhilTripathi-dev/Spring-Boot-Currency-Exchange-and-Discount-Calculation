package com.example.currency.exchange.and.discount.calculation.service;

import org.springframework.stereotype.Service;

import com.example.currency.exchange.and.discount.calculation.dto.BillRequest;

@Service
public interface DiscountService {

	public double calculateTotalBill(BillRequest billRequest, double exchangeRate);
		

}
