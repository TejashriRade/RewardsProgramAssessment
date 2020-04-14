package com.demo.rewardsprogram.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "customerId", "customerName", "totalTransactionAmount", "totalRewardPoints" })
public class TransactionResponse {

	@JsonProperty("customerId")
	public Long customerId;
	@JsonProperty("customerName")
	public String customerName;
	@JsonProperty("totalTransactionAmount")
	public Long totalTransactionAmount;
	@JsonProperty("totalRewardPoints")
	public Long totalRewardPoints;
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Long getTotalTransactionAmount() {
		return totalTransactionAmount;
	}
	public void setTotalTransactionAmount(Long totalTransactionAmount) {
		this.totalTransactionAmount = totalTransactionAmount;
	}
	public Long getTotalRewardPoints() {
		return totalRewardPoints;
	}
	public void setTotalRewardPoints(Long totalRewardPoints) {
		this.totalRewardPoints = totalRewardPoints;
	}

	
}