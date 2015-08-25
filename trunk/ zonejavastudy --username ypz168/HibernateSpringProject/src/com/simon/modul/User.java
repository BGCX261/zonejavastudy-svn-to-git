package com.simon.modul;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User extends AbstractUser implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String username, String password, String firstName,
			String lastName, Long dateCreated) {
		super(username, password, firstName, lastName, dateCreated);
	}

}
