package com.yan.dev.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.yan.dev.jpa.entity.User;

/**
 * 
 * @author yan.dev
 * @version 1.0 Create-Time£º2011-2-16 ÏÂÎç20:16:32
 */
public class UserTest {

	public static void main(String[] args) {
		// get Entity Manager
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("MyJPA");
		long startTime = System.currentTimeMillis();
		EntityManager em = factory.createEntityManager();

		// get Transaction and Begin Transaction
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		User user = new User();
		user.setName("yan.dev2");
		user.setLoginId("yan2");
		user.setPassword("dev2");
		user.setAge(99);
		em.persist(user);

		// Commit
		transaction.commit();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		em.close();
	}
}
