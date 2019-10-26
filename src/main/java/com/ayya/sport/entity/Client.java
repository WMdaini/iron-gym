package com.ayya.sport.entity;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
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

	private File photo;

	@DateTimeFormat(iso = ISO.DATE)
	private Date birthDay;

	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	private List<Subscription> subscriptions = new ArrayList<Subscription>();

	@ManyToOne()
	@JoinColumn(name = "idCategory")
	private Category category;

	public Client() {
		super();
	}

	public Client(String nom, String prenom, File photo, Date birthDay, Category category) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.photo = photo;
		this.birthDay = birthDay;
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

	public File getPhoto() {
		return this.photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
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


	public void setIdCient(Long idClient) {
		this.idclient = idClient;
	}

	public String getMatricul() {
		return this.matricul;
	}

	public void setMatricul(String matricul) {
		this.matricul = matricul;
	}

	public Long getIdclient() {
		return idclient;
	}

	public void setIdclient(Long idclient) {
		this.idclient = idclient;
	}

	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
	

}