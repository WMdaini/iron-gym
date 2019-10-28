package com.ayya.sport.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SubscriptionType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long subscriptionTypeId;

	private String name;

	private int discount;

	private double amount;

	private Integer period;

	@OneToMany(mappedBy = "subscriptionType", fetch = FetchType.EAGER)
	private List<Subscription> subscriptions;

	public SubscriptionType() {
		super();
	}

	public SubscriptionType(String name, int discount, double amount, Integer period) {
		super();
		this.name = name;
		this.discount = discount;
		this.amount = amount;
		this.period = period;
	}

	public Long getSubscriptionTypeId() {
		return this.subscriptionTypeId;
	}

	public void setSubscriptionTypeId(Long subscriptionTypeId) {
		this.subscriptionTypeId = subscriptionTypeId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDiscount() {
		return this.discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Integer getPeriod() {
		return this.period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	@Override
	public String toString() {
		return "{\"subscriptionTypeId\":\"" + this.subscriptionTypeId + "\", \"name\":\"" + this.name + "\", \"discount\":\"" + this.discount + "\", \"amount\":\"" + this.amount + "\", \"period\":\""
		        + this.period + "\"}";
	}

}
