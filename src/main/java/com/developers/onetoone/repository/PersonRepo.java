package com.developers.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developers.onetoone.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}
