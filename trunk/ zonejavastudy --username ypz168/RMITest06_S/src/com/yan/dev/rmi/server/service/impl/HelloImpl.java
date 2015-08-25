/**
 *  Copyright(c) 2010-2011 Yan.Dev. All Rights Reserved.
 */
package com.yan.dev.rmi.server.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.yan.dev.rmi.server.service.IHello;

/**
 * Comment for HelloImpl.java
 * 
 * @author <a href="mailto:yan.dev@hotmail.com">yan.dev</a>
 * 
 * @blog:<a href="http://yan-dev.javaeye.com"><b>yan.dev's Blog</b></a>
 * @version 1.0
 * @time 2011-3-21 обнГ04:13:28
 */
public class HelloImpl extends UnicastRemoteObject implements IHello {
	/**
	 * @throws RemoteException
	 */
	public HelloImpl() throws RemoteException {
		super();
	}

	@Override
	public void sayHello() {
		System.out.println("ok");
	}

}
