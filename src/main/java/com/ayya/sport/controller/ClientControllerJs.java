package com.ayya.sport.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
public class ClientControllerJs {

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	SubscriptionRepository subscriptionRepository;

	@RequestMapping(value = "/refresh_clients", method = RequestMethod.POST)
	public List<Client> refreshClients(@RequestParam Map<String, String> allParams) {
		String type = allParams.get("typeClients");
		List<Client> clients = new ArrayList<Client>();

		if (type != null) {
			if (type.equals("all")) {
				clients = this.clientRepository.findAll();
			} else if (type.equals("active")) {
				clients = this.clientRepository.getActiveClientList();
			} else {
				clients = this.clientRepository.getInactiveClientList();
			}
		}

		System.out.println(clients);

		return clients;
	}

	@RequestMapping(value = "/delete-clients", method = RequestMethod.POST)
	public Boolean deleteClient(@RequestParam Map<String, String> allParams) {
		this.clientRepository.delete(this.clientRepository.findByIdclient(Long.parseLong(allParams.get("idclienttodelete"))));
		return true;
	}

	@RequestMapping(value = "/edit-clients", method = RequestMethod.POST)
	public Client editClients(@RequestParam Map<String, String> allParams, Model model) throws ParseException {
		String message = "Modifié";
		Client client = this.clientRepository.findByIdclient(Long.parseLong(allParams.get("idclient")));
		if (client != null) {
			client.setNom(allParams.get("nom"));
			client.setPrenom(allParams.get("prenom"));
			if (allParams.get("birthday") != null && !allParams.get("birthday").equals("")) {
				Date birthday = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(allParams.get("startDate"));
				client.setBirthDay(birthday);
			}

			Category caltegory = this.categoryRepository.findByIdCategory(Long.parseLong(allParams.get("category")));
			client.setCategory(caltegory);
			Subscription subscription = this.subscriptionRepository.findByIdSubscription(Long.parseLong(allParams.get("subscription")));
			// client.setSubscription(subscription);
		}
		else {
			message = "Utilisateur introuvable (Problème systéme , contacter l'administrateur) !";
		}
		System.out.println(allParams.get("idclient"));

		return client;
	}

	// public T<T> toJson(T t) {
	//
	// return t;
	// }
}
