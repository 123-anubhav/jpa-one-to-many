package com.developers.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developers.onetomany.entity.User;

public interface IUserRepo extends JpaRepository<User, Integer>{

}
