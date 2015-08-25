/**
 *  Copyright(c) 2010-2011 Yan.Dev. All Rights Reserved.
 */
package com.yan.dev.jpa.dao;

import com.yan.dev.jpa.entity.User;

/**
 * Comment for IUserDao.java
 *
 * @author <a href="mailto:yan.dev@hotmail.com">yan.dev</a>
 * 
 * @blog:<a href="http://yan-dev.javaeye.com"><b>yan.dev's Blog</b></a>
 * @version 1.0
 * @time 2011-3-24 обнГ05:06:31
 */
public interface IUserDao {
	public void save(User user) throws Exception;

}
