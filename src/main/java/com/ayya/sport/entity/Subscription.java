package com.ayya.sport.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;
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
	
	@ManyToOne
	@JoinColumn(name = "idclient")
	private Client client;
	
	@ManyToOne()
	@JoinColumn(name = "subscriptionTypeId")
	private SubscriptionType subscriptionType;
	
	public Subscription() {
		super();
	}

	
	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public SubscriptionType getSubscriptionType() {
		return subscriptionType;
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
		return startDate;
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

}
