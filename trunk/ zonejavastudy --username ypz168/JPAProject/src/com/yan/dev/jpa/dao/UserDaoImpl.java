/**
 *  Copyright(c) 2010-2011 Yan.Dev. All Rights Reserved.
 */
package com.yan.dev.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.yan.dev.jpa.entity.User;

/**
 * Comment for UserDaoImpl.java
 * 
 * @author <a href="mailto:yan.dev@hotmail.com">yan.dev</a>
 * 
 * @blog:<a href="http://yan-dev.javaeye.com"><b>yan.dev's Blog</b></a>
 * @version 1.0
 * @time 2011-3-24 ÏÂÎç05:07:34
 */
public class UserDaoImpl implements IUserDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yan.dao.IUserDao#save(com.yan.entity.User)
	 */
	public void save(User user) throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("FirstJPA");
		EntityManager em = factory.createEntityManager(); 
		EntityTransaction t = em.getTransaction();
		t.begin();
		try {
			em.persist(user);
			t.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			t.rollback();
			throw e;
		} finally { 
			em.close();
			factory.close();
		}
	}

}
