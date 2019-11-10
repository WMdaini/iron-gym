package com.ayya.sport.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="CATEGORY")
public class Category implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_category")
	private Long idCategory;

	private String name;
	
	private boolean status ; 
	
	private String description;

	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private List<Subscription> subscriptions = new ArrayList<>();

	public Category() {
		super();
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

	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "{\"idCategory\":\"" + this.idCategory + "\", \"name\":\"" + this.name + "\", \"description\":\"" + this.description + "\"}";
	}

}
