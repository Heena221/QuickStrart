package com.example.demo.entity;

public class Fee {
	private int id;
	private String branch;
	private String year;
	private double amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Fee(int id, String branch, String year, double amount) {
		super();
		this.id = id;
		this.branch = branch;
		this.year = year;
		this.amount = amount;
	}
	public Fee() {
		super();
	}

}
