package com.example.demo.handler;

import java.util.HashMap;
import java.util.Map;


import com.example.demo.entity.Currency;

public interface DispenseChain {
//	Setting Concrete tiếp theo
	void setNextChain(DispenseChain nextChain);
	
//	Xử lý
	void dispense(Currency cur);
	
// 	Lưu trữ kết quả
	public static final Map<Integer, Integer> dispensed = new HashMap<>();
}
