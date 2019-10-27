package com.ayya.sport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ayya.sport.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	@Query(value="select DISTINCT c.* from client c,subscription s where c.id_client = s.idclient " + 
			"and s.is_active = 1",nativeQuery = true)
	public List<Client> getActiveClientList();
	
	@Query(value="select DISTINCT c.* from client c,subscription s where c.id_client = s.idclient " + 
			"and s.is_active = 0",nativeQuery = true)
	public List<Client> getInactiveClientList();
	
	Client findByIdclient(Long idClient);

}
