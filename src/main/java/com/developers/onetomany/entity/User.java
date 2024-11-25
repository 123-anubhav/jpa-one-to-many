package com.developers.onetomany.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	private String name;
	private String phNo;

	/*
	 * // orphanRemoval USE FOR IF CHILD DOES NOT HAS PARENT THEN DELETE CHILD DATA
	 * 
	 * @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch =
	 * FetchType.EAGER) //@JsonManagedReference private List<Address> addr = new
	 * ArrayList<>();
	 */
	
	@OneToMany(targetEntity = Address.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="fk",referencedColumnName = "userId")
	private List<Address> addr;
}
