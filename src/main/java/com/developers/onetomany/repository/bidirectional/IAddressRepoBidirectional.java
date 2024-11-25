package com.developers.onetomany.repository.bidirectional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developers.onetomany.entity.Address;
import com.developers.onetomany.entity.bidirectional.AddressBidirectional;

public interface IAddressRepoBidirectional  extends JpaRepository<AddressBidirectional, Integer>{

}
