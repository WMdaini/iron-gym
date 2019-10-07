package com.ayya.sport.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_category")
	private Long idCategory;

	private String name;

	private String description;

	@OneToMany(mappedBy = "category")
	private List<Client> clients;

	public Category() {
		super();
	}

	public Category(String name, String description, List<Client> clients) {
		super();
		this.name = name;
		this.description = description;
		this.clients = clients;
	}

	public Long getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

}
