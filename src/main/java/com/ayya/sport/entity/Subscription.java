package com.ayya.sport.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Subscription implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_subscription")
	private Long idSubscription;

	@DateTimeFormat(iso = ISO.DATE)
	private Date startDate;

	@DateTimeFormat(iso = ISO.DATE)
	private Date endDate;

	private boolean isActive;

	private double payedAmount;

	private double restAmount;

	@ManyToOne
	@JoinColumn(name = "idclient")
	private Client client;

	@ManyToOne()
	@JoinColumn(name = "subscriptionTypeId")
	private SubscriptionType subscriptionType;

	@ManyToOne()
	@JoinColumn(name = "idCategory")
	private Category category;
	
	public Subscription() {
		super();
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public SubscriptionType getSubscriptionType() {
		return this.subscriptionType;
	}

	public void setSubscriptionType(SubscriptionType subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public Long getIdSubscription() {
		return this.idSubscription;
	}

	public void setIdSubscription(Long idSubscription) {
		this.idSubscription = idSubscription;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public boolean isActive() {
		return this.isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "{\"idSubscription\":\"" + this.idSubscription + "\", \"startDate\":\"" + this.startDate + "\", \"endDate\":\"" + this.endDate + "\", \"isActive\":\"" + this.isActive
		        + "\", \"client\":" + this.client
		        + ", \"subscriptionType\":" + this.subscriptionType + ""
		        + ",\"payedAmount\":\"" + this.payedAmount + "\""
		        + ",\"restAmount\":\"" + this.restAmount + "\""
		        + ",\"category\":" + this.category + ""
		        + "}";
	}

	public double getPayedAmount() {
		return this.payedAmount;
	}

	public void setPayedAmount(double payedAmount) {
		this.payedAmount = payedAmount;
	}

	public double getRestAmount() {
		return this.restAmount;
	}

	public void setRestAmount(double restAmount) {
		this.restAmount = restAmount;
	}

}
