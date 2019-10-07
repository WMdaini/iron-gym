package com.ayya.sport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_subscription")
	private Long idSubscription;

	private String name;

	private Integer period;

	public Subscription() {
		super();
	}

	public Subscription(String name, Integer period) {
		super();
		this.name = name;
		this.period = period;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPeriod() {
		return this.period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Long getIdSubscription() {
		return this.idSubscription;
	}

	public void setIdSubscription(Long idSubscription) {
		this.idSubscription = idSubscription;
	}

}
