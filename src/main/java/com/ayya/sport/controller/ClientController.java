package com.ayya.sport.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		model.addAttribute("client", new Client());
		model.addAttribute("clients", this.clientRepository.findByIsActiveFalse());
		model.addAttribute("categorys", this.categoryRepository.findAll());
		model.addAttribute("subscriptions", this.subscriptionRepository.findAll());
		return "/pages/clientsList";
	}

	@RequestMapping(value = "/list-inactive-clients", method = RequestMethod.GET)
	public String getInactiveClients(Model model) {
		model.addAttribute("client", new Client());
		model.addAttribute("clients", this.clientRepository.findByIsActiveFalse());
		model.addAttribute("categorys", this.categoryRepository.findAll());
		model.addAttribute("subscriptions", this.subscriptionRepository.findAll());
		return "/pages/clientsList";
	}

	@RequestMapping(value = "/list-clients", method = RequestMethod.GET)
	public String getAllClients(Model model) {
		model.addAttribute("client", new Client());
		model.addAttribute("clients", this.clientRepository.findAll());
		model.addAttribute("categorys", this.categoryRepository.findAll());
		model.addAttribute("subscriptions", this.subscriptionRepository.findAll());
		return "/pages/clientsList";
	}

	@RequestMapping(value = "/edit-inactive-clients", method = RequestMethod.POST)
	public String editClients(@RequestParam Map<String, String> allParams, Model model) {
		// this.clientRepository.saveAndFlush(newClient);

		System.out.println(allParams.get("idclient"));

		return getInactiveClients(model);
	}

	@RequestMapping(value = "/delete-clients", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Boolean deleteClient(@RequestParam Map<String, String> allParams) {

		System.out.println(allParams.get("idclienttodelete"));
		this.clientRepository.delete(this.clientRepository.findByIdclient(Long.parseLong(allParams.get("idclienttodelete"))));

		return true;
	}

	@RequestMapping(value = "/refresh_clients", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Client> refreshClients(@RequestParam Map<String, String> allParams) {
		String type = allParams.get("typeClients");
		List<Client> clients = new ArrayList<Client>();

		if (type != null) {
			if (type.equals("all")) {
				clients = this.clientRepository.findAll();
			} else if (type.equals("active")) {
				clients = this.clientRepository.findByIsActiveTrue();
			} else {
				clients = this.clientRepository.findByIsActiveFalse();
			}
		}

		System.out.println(clients);

		return clients;
	}
}
