package com.ayya.sport.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ayya.sport.entity.Client;
import com.ayya.sport.entity.Subscription;
import com.ayya.sport.entity.SubscriptionType;
import com.ayya.sport.repository.CategoryRepository;
import com.ayya.sport.repository.ClientRepository;
import com.ayya.sport.repository.SubscriptionRepository;
import com.ayya.sport.repository.SusbscriptionTypeRepository;
import com.ayya.sport.utils.JsonUtils;

@Controller
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Autowired
	private SusbscriptionTypeRepository susbscriptionTypeRepository;

	@Autowired
	JsonUtils jsonUtils;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createClient(Model model) {
		model.addAttribute("client", new Client());
		model.addAttribute("categorys", this.categoryRepository.findAll());
		model.addAttribute("subscriptions", this.susbscriptionTypeRepository.findAll());
		return "/pages/createUser";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createClient(@ModelAttribute(name = "client") Client newClient, @RequestParam Map<String, String> allParams, Model model) throws ParseException {
		Client client = new Client();
		client.setNom(newClient.getNom());
		client.setPrenom(newClient.getPrenom());
		client.setCategory(newClient.getCategory());
		client.setBirthDay(newClient.getBirthDay());
		System.out.println(allParams.get("subscription"));
		SubscriptionType subscriptionType = this.susbscriptionTypeRepository.findBySubscriptionTypeId(Long.parseLong(allParams.get("subscription")));
		Subscription subscription = new Subscription();
		subscription.setActive(true);

		Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(allParams.get("startDate"));
		subscription.setStartDate(startDate);
		subscription.setSubscriptionType(subscriptionType);

		Calendar myCal = Calendar.getInstance();
		myCal.setTime(startDate);
		myCal.add(Calendar.MONTH, subscriptionType.getPeriod());
		Date endDate = myCal.getTime();
		subscription.setEndDate(endDate);

		client.getSubscriptions().add(subscription);
		this.clientRepository.saveAndFlush(client);

		subscription.setClient(client);
		this.subscriptionRepository.save(subscription);

		// this.subscriptionRepository.saveAndFlush(subscription);

		model.addAttribute("isCreated", true);
		return createClient(model);
	}

	@RequestMapping(value = "/list-clients", method = RequestMethod.GET)
	public String getAllClients(Model model) {
		model.addAttribute("jsonUtils", this.jsonUtils);
		model.addAttribute("client", new Client());
		model.addAttribute("clients", this.clientRepository.findAll());
		model.addAttribute("categorys", this.categoryRepository.findAll());
		model.addAttribute("subscriptions", this.subscriptionRepository.findAll());
		model.addAttribute("showFilter", "true");

		return "/pages/clientsList";
	}

}
