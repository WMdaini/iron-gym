package com.ayya.sport.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
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

	@OneToMany(mappedBy = "subscription", fetch = FetchType.EAGER)
	@Column(nullable = true)
	// @JsonManagedReference
	private Set<Client> clients;

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
