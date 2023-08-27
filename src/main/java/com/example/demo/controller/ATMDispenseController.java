package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.ATMDispenseChain;
import com.example.demo.entity.Currency;

@RestController
public class ATMDispenseController {
	@Autowired
	private ATMDispenseChain atmDispenseChain;
	
	@GetMapping("/dispense/{amount}")
	public Map<Integer, Integer> dispense(@PathVariable("amount") int amount) {
		if(amount % 10 != 0) {
			Map<Integer, Integer> map = new HashMap<>();
			map.put(0, 0);
			return map;
		} else {
			atmDispenseChain.c1.dispense(new Currency(amount));
			return atmDispenseChain.c1.dispensed;
		}
	}
}
