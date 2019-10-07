package com.ayya.sport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ayya.sport.entity.Client;
import com.ayya.sport.repository.CategoryRepository;
import com.ayya.sport.repository.ClientRepository;
import com.ayya.sport.repository.SubscriptionRepository;

@Controller
public class ClientController {

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	SubscriptionRepository subscriptionRepository;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createClient(Model model) {
		model.addAttribute("client", new Client());
		model.addAttribute("categorys", this.categoryRepository.findAll());
		model.addAttribute("subscriptions", this.subscriptionRepository.findAll());
		return "/pages/createUser";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String test(Model model) {

		return "home";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createClient(@ModelAttribute(name = "client") Client newClient, Model model) {
		Client client = new Client();
		client.setNom(newClient.getNom());
		client.setPrenom(newClient.getPrenom());
		client.setActive(true);
		client.setStartDate(newClient.getStartDate());
		client.setCategory(newClient.getCategory());
		client.setBirthDay(newClient.getBirthDay());
		client.setSubscription(newClient.getSubscription());
		this.clientRepository.saveAndFlush(client);
		model.addAttribute("isCreated", true);
		return createClient(model);
	}

	@RequestMapping(value = "/list-active-clients", method = RequestMethod.GET)
	public String getActiveClients(Model model) {
		model.addAttribute("clients", this.clientRepository.findByIsActiveTrue());
		return "/pages/activeClients";
	}

	@RequestMapping(value = "/list-inactive-clients", method = RequestMethod.GET)
	public String getInactiveClients(Model model) {
		model.addAttribute("client", new Client());
		model.addAttribute("clients", this.clientRepository.findByIsActiveFalse());
		model.addAttribute("categorys", this.categoryRepository.findAll());
		model.addAttribute("subscriptions", this.subscriptionRepository.findAll());
		return "/pages/inactiveClients";
	}

	@RequestMapping(value = "/edit-inactive-clients", method = RequestMethod.POST)
	public String editClients(@ModelAttribute(name = "client") Client newClient, Model model) {
		this.clientRepository.saveAndFlush(newClient);
		return getInactiveClients(model);
	}
}
