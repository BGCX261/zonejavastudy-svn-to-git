/**
 *  Copyright(c) 2010-2011 Yan.Dev. All Rights Reserved.
 */
package com.yan.dev.jpa.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

;

/**
 * Comment for User.java
 * 
 * @author <a href="mailto:yan.dev@hotmail.com">yan.dev</a>
 * 
 * @blog:<a href="http://yan-dev.javaeye.com"><b>yan.dev's Blog</b></a>
 * @version 1.0
 * @time 2011-3-25 ÉÏÎç11:37:12
 */
@Entity
@Table(name = "yan_dev")
public class User {
	private int id;
	private String name;

	public User() {

	}

	public User(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
