package com.ayya.sport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayya.sport.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	List<Client> findByIsActiveTrue();

	List<Client> findByIsActiveFalse();

	Client findByIdclient(Long idClient);

}
