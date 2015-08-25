/**
 *  Copyright(c) 2010-2011 Yan.Dev. All Rights Reserved.
 */
package com.yan.dev.rmi.server.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Comment for IHello.java
 * 
 * @author <a href="mailto:yan.dev@hotmail.com">yan.dev</a>
 * 
 * @blog:<a href="http://yan-dev.javaeye.com"><b>yan.dev's Blog</b></a>
 * @version 1.0
 * @time 2011-3-21 обнГ04:10:44
 */
public interface IHello extends Remote {
	public void sayHello()throws RemoteException;

}
