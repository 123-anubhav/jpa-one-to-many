package com.developers.onetomany.entity.bidirectional;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
public class AddressBidirectional {

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
	
	// Bi-directional mapping with User entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) // Foreign key column
    @JsonBackReference // Prevents infinite recursion
    private UserBidirectional user;
	
}
