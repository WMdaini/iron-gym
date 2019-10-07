package com.ayya.sport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayya.sport.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
