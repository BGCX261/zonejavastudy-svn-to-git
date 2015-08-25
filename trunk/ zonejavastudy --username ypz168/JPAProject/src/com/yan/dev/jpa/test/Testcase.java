/**
 *  Copyright(c) 2010-2011 Yan.Dev. All Rights Reserved.
 */
package com.yan.dev.jpa.test;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yan.dev.jpa.entity.User;
import com.yan.dev.jpa.service.IUserService;
import com.yan.dev.jpa.service.UserServiceImpl;

/**
 * Comment for Testcase.java
 * 
 * @author <a href="mailto:yan.dev@hotmail.com">yan.dev</a>
 * 
 * @blog:<a href="http://yan-dev.javaeye.com"><b>yan.dev's Blog</b></a>
 * @version 1.0
 * @time 2011-3-24 ÏÂÎç04:52:15
 */
public class Testcase {
	private IUserService service;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		service=new UserServiceImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		service=null;
	}

	@Test
	public void save() {
		User user=new User();
		user.setName("yan.dev2");
		user.setLoginId("yan2");
		user.setPassword("dev2");
		user.setAge(99);
		
		Assert.assertEquals(service.save(user), true);

	}

}
