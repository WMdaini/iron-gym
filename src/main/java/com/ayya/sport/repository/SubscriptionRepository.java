package com.ayya.sport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayya.sport.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
