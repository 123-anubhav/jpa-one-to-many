package com.developers.onetomany.repository.bidirectional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developers.onetomany.entity.User;
import com.developers.onetomany.entity.bidirectional.UserBidirectional;

public interface IUserRepoBidirectional extends JpaRepository<UserBidirectional, Integer>{

}
