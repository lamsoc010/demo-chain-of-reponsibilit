package com.example.demo.concrete;

import java.util.HashMap;

import com.example.demo.entity.Currency;
import com.example.demo.handler.DispenseChain;

public class Dollar10Dispenser implements DispenseChain {

	private DispenseChain chain;
	private static final int AMOUNTDISPENSER = 10;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if(cur.getAmount() >= AMOUNTDISPENSER){
			int num = cur.getAmount()/AMOUNTDISPENSER;
			int remainder = cur.getAmount() % AMOUNTDISPENSER;
//			System.out.println("Dispensing "+num+" 10$ note");
			chain.dispensed.put(AMOUNTDISPENSER , num);
			if(remainder !=0) {
				this.chain.dispense(new Currency(remainder));
			}
		} else {
			this.chain.dispense(cur);
		}
	}

}
