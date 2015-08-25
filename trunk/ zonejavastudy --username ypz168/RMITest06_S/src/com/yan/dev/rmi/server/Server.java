/**
 *  Copyright(c) 2010-2011 Yan.Dev. All Rights Reserved.
 */
package com.yan.dev.rmi.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.yan.dev.rmi.server.service.IHello;
import com.yan.dev.rmi.server.service.impl.HelloImpl;

/**
 * Comment for Server.java
 * 
 * @author <a href="mailto:yan.dev@hotmail.com">yan.dev</a>
 * 
 * @blog:<a href="http://yan-dev.javaeye.com"><b>yan.dev's Blog</b></a>
 * @version 1.0
 * @time 2011-3-21 下午04:11:34
 */
public class Server {
	public static void main(String[] args) {
		int port =1234;
		try {
//			LocateRegistry.createRegistry(port);
			// 创建一个远程对象
			IHello hello = new HelloImpl();
			Naming.bind("//localhost:"+port+"/hello", hello);
//			Naming.rebind("rmi://localhost:"+port+"/hello", hello);
			
			System.out.println("Server start succeed, listening...");
		} catch (RemoteException e) { 
			e.printStackTrace();
		} catch (MalformedURLException e) { 
			e.printStackTrace();
		} catch (AlreadyBoundException e) { 
			e.printStackTrace();
		}
	}
}
