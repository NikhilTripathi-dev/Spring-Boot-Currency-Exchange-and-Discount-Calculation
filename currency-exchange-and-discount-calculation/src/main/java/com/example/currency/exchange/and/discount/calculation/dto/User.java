package com.example.currency.exchange.and.discount.calculation.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private int id;
	private String name;
	private boolean isEmployee;
	private boolean isAffiliate;
	private LocalDate registrationDate;

}
