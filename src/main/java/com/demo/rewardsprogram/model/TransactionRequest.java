package com.demo.rewardsprogram.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "customerId","itemName", "itemCost" })
public class TransactionRequest {

	@JsonProperty("customerId")
	private Long customerId;
	@JsonProperty("itemName")
	private String itemName;
	@JsonProperty("itemCost")
	private Long itemCost;
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Long getItemCost() {
		return itemCost;
	}
	public void setItemCost(Long itemCost) {
		this.itemCost = itemCost;
	}

	
}