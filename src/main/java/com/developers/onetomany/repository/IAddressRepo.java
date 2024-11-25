package com.developers.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developers.onetomany.entity.Address;

public interface IAddressRepo  extends JpaRepository<Address, Integer>{

}
