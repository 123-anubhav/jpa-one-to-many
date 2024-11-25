package com.developers.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developers.onetoone.entity.Passport;
import com.developers.onetoone.entity.Person;

public interface PasportRepo extends JpaRepository<Passport, Integer> {

}
