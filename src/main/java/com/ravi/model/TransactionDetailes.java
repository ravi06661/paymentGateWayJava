package com.ravi.model;

public class TransactionDetailes {

	private String orderId;
	private String currency;
	private Integer amount;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public TransactionDetailes(String orderId, String currency, Integer amount) {
		super();
		this.orderId = orderId;
		this.currency = currency;
		this.amount = amount;
	}
}
