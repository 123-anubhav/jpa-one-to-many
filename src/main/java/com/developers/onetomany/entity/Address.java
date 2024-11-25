package com.developers.onetomany.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addrId;

	private String houseNumber;
	private Long pinCode;
	private String city;
	private String state;
	private String type;

	/*
	 * // IF WE NOT MENTION @JOINCOLUMN THEN BYDEFAULT NAME IT WILL TAKE SO FOR
	 * GIVING // OUR NAME WE USE @JOINCOLUMN
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "user_id") //@JsonBackReference
	 * //@JsonIgnoreProperties("addr") // Prevent infinite recursion private User
	 * user;
	 */
	
}
