package com.task;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculatorSoap proxy=new Calculator().getCalculatorSoap();
		System.out.println("add result "+proxy.add(3, 5)); 
		System.out.println("Sub result "+proxy.subtract(4, 2)); 
		System.out.println("Multiplication result "+proxy.multiply(4, 4)); 

	}

}
