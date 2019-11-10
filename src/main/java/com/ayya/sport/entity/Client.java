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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	private String gender;
	
	@Temporal(TemporalType.DATE)
	private Date birthDay;

	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private List<Subscription> subscriptions = new ArrayList<Subscription>();

	public Client() {
		super();
	}

	public Client(String nom, String prenom, File photo, Date birthDay) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.photo = photo;
		this.birthDay = birthDay;
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
		return this.idclient;
	}

	public void setIdclient(Long idclient) {
		this.idclient = idclient;
	}

//	public List<Subscription> getSubscriptions() {
//		return this.subscriptions;
//	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	@Override
	public String toString() {
		return "{\"idclient\":\"" + this.idclient + "\", \"matricul\":\"" + this.matricul + "\", \"nom\":\"" + this.nom + "\", \"prenom\":\"" + this.prenom + "\", \"photo\":\"" + this.photo
		        + "\", \"birthDay\":\"" + this.birthDay + "\"}";
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}