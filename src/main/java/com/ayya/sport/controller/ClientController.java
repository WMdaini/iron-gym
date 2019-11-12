package com.ayya.sport.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayya.sport.entity.Category;
import com.ayya.sport.entity.Client;
import com.ayya.sport.entity.Subscription;
import com.ayya.sport.repository.CategoryRepository;
import com.ayya.sport.repository.ClientRepository;
import com.ayya.sport.repository.SubscriptionRepository;

@RestController
@RequestMapping(value = "/client")
@CrossOrigin("*")
public class ClientController {

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	SubscriptionRepository subscriptionRepository;

	@PersistenceContext
	EntityManager em;
	
	@RequestMapping(value = "/list-clients", method = RequestMethod.GET)
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}
	
	
//	@RequestMapping(value = "/clients-filter/{status}/{category}/{gender}/{startdate/{enddate}/", method = RequestMethod.GET)
//	public List<Client> getFiltredClients(@PathVariable("status") String status,@PathVariable("gender")String gender
//			,@PathVariable("startdate") Date startdate,@PathVariable("enddate") Date edndate,@PathVariable("category") String category) {
//		System.out.println(category);
//		return clientRepository.findAll();
//	}
//	
	@RequestMapping(value = "/clients-filter/{status}/{gender}", method = RequestMethod.PUT)
	public List<Client> getFiltredClients(@RequestBody Category category,@PathVariable("status")String status,@PathVariable("gender")String gender) {
		System.out.println(category);
		String query = "select DISTINCT c from ";
		String tables = "Client c ";
		String conditions= "where 1=1 ";
		if(status!=null && !status.equals("undefined") && !status.equals("") && !status.equals("tous")) {
			tables+=",Subscription s  ";
			conditions += "and c.idclient = s.client ";
			if(status.equals("active")) {
				conditions += "and s.isActive = true ";
			}else {
				conditions += "and s.isActive = false ";
			}
		}
		
		if(gender!=null && !gender.equals("undefined") && !gender.equals("") && !gender.equals("tous")) {
			if(gender.equals("male")) {
				conditions += "and c.gender = 'male' ";
			}else {
				conditions += "and c.gender = 'female' ";
			}
		}
		
		if(category!=null && category.getIdCategory() != null) {
			if(!tables.contains("Subscription")) {
				tables+=",Subscription s  ";
			}
			conditions += "and c.idclient = s.client and s.category ="+category.getIdCategory()+" ";
			
		}
			query += tables+conditions;
			Query myQuery = em.createQuery(query);
			List<Client> clients = myQuery.getResultList();
		return clients;
	}
	
	
//	@RequestMapping(value = "/refresh_clients", method = RequestMethod.GET)
//	public List<Client> refreshClients(@RequestParam Map<String, String> allParams) {
//		String type = allParams.get("typeClients");
//		List<Client> clients = new ArrayList<Client>();
//		type = "all";
//		if (type != null) {
//			if (type.equals("all")) {
//				clients = this.clientRepository.findAll();
//			} else if (type.equals("active")) {
//				clients = this.clientRepository.getActiveClientList();
//			} else {
//				clients = this.clientRepository.getInactiveClientList();
//		}
//		}
//
//		System.out.println(clients);
//
//		return clients;
//	}
//	
//	
//	
//	
//	@RequestMapping(value = "/delete-clients", method = RequestMethod.POST)
//	public Boolean deleteClient(@RequestParam Map<String, String> allParams) {
//		this.clientRepository.delete(this.clientRepository.findByIdclient(Long.parseLong(allParams.get("idclienttodelete"))));
//		return true;
//	}
//
//	@RequestMapping(value = "/edit-clients", method = RequestMethod.POST)
//	public Client editClients(@RequestParam Map<String, String> allParams, Model model) throws ParseException {
//		String message = "Modifié";
//		Client client = this.clientRepository.findByIdclient(Long.parseLong(allParams.get("idclient")));
//		if (client != null) {
//			client.setNom(allParams.get("nom"));
//			client.setPrenom(allParams.get("prenom"));
//			if (allParams.get("birthday") != null && !allParams.get("birthday").equals("")) {
//				Date birthday = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(allParams.get("startDate"));
//				client.setBirthDay(birthday);
//			}
//
//			Category caltegory = this.categoryRepository.findByIdCategory(Long.parseLong(allParams.get("category")));
//			client.setCategory(caltegory);
//			Subscription subscription = this.subscriptionRepository.findByIdSubscription(Long.parseLong(allParams.get("subscription")));
//			// client.setSubscription(subscription);
//		}
//		else {
//			message = "Utilisateur introuvable (Problème systéme , contacter l'administrateur) !";
//		}
//		System.out.println(allParams.get("idclient"));
//
//		return client;
//	}
//
//	// public T<T> toJson(T t) {
//	//
//	// return t;
//	// }
}
