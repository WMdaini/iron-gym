package com.ayya.sport.entity;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "client")
public class Client implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_client")
	private Long idclient;

	@Column(unique = true)
	private String matricul;

	private String nom;

	private String prenom;

	@DateTimeFormat(iso = ISO.DATE)
	private Date startDate;

	private File photo;

	@DateTimeFormat(iso = ISO.DATE)
	private Date birthDay;

	private boolean isActive;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idSubscription")
	// @JsonBackReference
	private Subscription subscription;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCategory")
	// @JsonBackReference
	private Category category;

	public Client() {
		super();
	}

	public Client(String nom, String prenom, Date startDate, File photo, Date birthDay, boolean isActive, Subscription subscription, Category category) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.startDate = startDate;
		this.photo = photo;
		this.birthDay = birthDay;
		this.isActive = isActive;
		this.subscription = subscription;
		this.category = category;
	}

	public Long getIdClient() {
		return this.idclient;
	}

	public void setIdClient(Long idCient) {
		this.idclient = idCient;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public File getPhoto() {
		return this.photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public Subscription getSubscription() {
		return this.subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public boolean isActive() {
		return this.isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setIdCient(Long idClient) {
		this.idclient = idClient;
	}

	public String getMatricul() {
		return this.matricul;
	}

	public void setMatricul(String matricul) {
		this.matricul = matricul;
	}

}