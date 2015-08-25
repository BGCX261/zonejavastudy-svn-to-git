/**
 *  Copyright(c) 2010-2011 Yan.Dev. All Rights Reserved.
 */
package com.yan.dev.jpa.service;

import com.yan.dev.jpa.dao.IUserDao;
import com.yan.dev.jpa.dao.UserDaoImpl;
import com.yan.dev.jpa.entity.User;

/**
 * Comment for UserServiceImpl.java
 * 
 * @author <a href="mailto:yan.dev@hotmail.com">yan.dev</a>
 * 
 * @blog:<a href="http://yan-dev.javaeye.com"><b>yan.dev's Blog</b></a>
 * @version 1.0
 * @time 2011-3-24 ÏÂÎç05:52:11
 */
public class UserServiceImpl implements IUserService {
	private IUserDao dao;

	public UserServiceImpl() {
		dao = new UserDaoImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yan.service.IUserService#save(com.yan.entity.User)
	 */
	public boolean save(User user) {
		try {
			dao.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
