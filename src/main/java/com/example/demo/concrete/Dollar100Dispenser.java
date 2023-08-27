package com.example.demo.concrete;

import com.example.demo.entity.Currency;
import com.example.demo.handler.DispenseChain;

public class Dollar100Dispenser implements DispenseChain {

//	Khai báo Chain
	private DispenseChain chain;
	private static final int AMOUNTDISPENSER = 100;
	
//	Setting Chain tiếp theo
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if(chain.dispensed.size() > 0) {
			chain.dispensed.clear();			
		}
		if(cur.getAmount() >= AMOUNTDISPENSER){
			int num = cur.getAmount()/AMOUNTDISPENSER;
			int remainder = cur.getAmount() % AMOUNTDISPENSER;
			if(cur.getAmount() == 500) {
				num -= 1;
				remainder += AMOUNTDISPENSER;
			}
//			System.out.println("Dispensing "+num+" 50$ note");
			chain.dispensed.put(AMOUNTDISPENSER , num);
//			Nếu như remainder !=0 thì chuyển đến Concrete tiếp theo để quy đổi tiếp
			if(remainder !=0) {
				this.chain.dispense(new Currency(remainder));
			}
		// Nếu số tiền cần quy đổi k phù hợp với Concrete thì chuyển đến Concrete tiếp theo
		}else{
			this.chain.dispense(cur);
		}
	}

}
