package com.ayya.sport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayya.sport.entity.SubscriptionType;

public interface SusbscriptionTypeRepository extends JpaRepository<SubscriptionType, Long> {
 public SubscriptionType findBySubscriptionTypeId(Long subscriptionTypeId);
}
