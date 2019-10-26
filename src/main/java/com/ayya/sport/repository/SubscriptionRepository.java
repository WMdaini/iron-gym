package com.ayya.sport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayya.sport.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
	public Subscription findByIdSubscription(Long idSubscription);
	List<Subscription> findByIsActiveTrue();

	List<Subscription> findByIsActiveFalse();
}
