package com.example.demo.concrete;

import com.example.demo.entity.Currency;
import com.example.demo.handler.DispenseChain;

public class Dollar50Dispenser implements DispenseChain {

	private DispenseChain chain;
	private static final int AMOUNTDISPENSER = 50;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if(cur.getAmount() >= AMOUNTDISPENSER){
			int num = cur.getAmount()/AMOUNTDISPENSER;
			int remainder = cur.getAmount() % AMOUNTDISPENSER;
			if(cur.getAmount() == 100) {
				num -= 1;
				remainder += AMOUNTDISPENSER;
			}
//			System.out.println("Dispensing "+num+" 50$ note");
			chain.dispensed.put(AMOUNTDISPENSER , num);
			if(remainder !=0) {
				this.chain.dispense(new Currency(remainder));
			}
		}else{
			this.chain.dispense(cur);
		}
	}

}
