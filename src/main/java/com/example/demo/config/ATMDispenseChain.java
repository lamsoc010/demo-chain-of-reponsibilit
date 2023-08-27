package com.example.demo.config;

import java.util.HashMap;
import java.util.Scanner;

import org.springframework.context.annotation.Configuration;

import com.example.demo.concrete.Dollar100Dispenser;
import com.example.demo.concrete.Dollar10Dispenser;
import com.example.demo.concrete.Dollar20Dispenser;
import com.example.demo.concrete.Dollar50Dispenser;
import com.example.demo.entity.Currency;
import com.example.demo.handler.DispenseChain;

@Configuration
public class ATMDispenseChain {
	public DispenseChain c1;

	public ATMDispenseChain() {
//		Khai báo các Concrete 
//		Cho biết Concrete nào là Concrete đầu tiên khi có request
		this.c1 = new Dollar100Dispenser();
		DispenseChain c2 = new Dollar50Dispenser();
		DispenseChain c3 = new Dollar20Dispenser();
		DispenseChain c4 = new Dollar10Dispenser();

//		Set thứ tự các Chain 
		c1.setNextChain(c2);
		c2.setNextChain(c3);
		c3.setNextChain(c4);
	}

}
