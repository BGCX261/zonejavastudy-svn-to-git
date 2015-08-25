/**
 *  Copyright(c) 2010-2011 Yan.Dev. All Rights Reserved.
 */
package com.yan.dev.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.yan.dev.rmi.server.service.IHello;

/**
 * Comment for Client.java
 *
 * @author <a href="mailto:yan.dev@hotmail.com">yan.dev</a>
 * 
 * @blog:<a href="http://yan-dev.javaeye.com"><b>yan.dev's Blog</b></a>
 * @version 1.0
 * @time 2011-3-21 ÏÂÎç04:17:12
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		try {
			IHello hello = (IHello) Naming.lookup("rmi://localhost:1234/hello");
			hello.sayHello();
		} catch (MalformedURLException e) { 
			e.printStackTrace();
		} catch (RemoteException e) { 
			e.printStackTrace();
		} catch (NotBoundException e) { 
			e.printStackTrace();
		}
	}

}
