/**
 *  Copyright(c) 2010-2011 Yan.Dev. All Rights Reserved.
 */
package com.yan.dev.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.yan.dev.rmi.service.play.IPlay;
import com.yan.dev.rmi.service.task.ITask;
import com.yan.dev.rmi.service.task.impl.TaskImpl;

/**
 * Comment for Client.java
 * 
 * @author <a href="mailto:yan.dev@hotmail.com">yan.dev</a>
 * 
 * @blog:<a href="http://yan-dev.javaeye.com"><b>yan.dev's Blog</b></a>
 * @version 1.0
 * @time 2011-3-23 上午09:27:25
 */
public class ClientTest {
	public static void main(String[] args) {
		int port = 1234;
		String ip = "localhost";
		IPlay obj;
		System.setProperty("java.security.policy","d:\\swo.policy");
		try {
			obj = (IPlay) Naming.lookup("rmi://" + ip + ":" + port + "/play");

			ITask task = new TaskImpl();
			Object result = obj.play(task);
			System.out.println("client::客户端执行结果="+result.toString());
		} catch (MalformedURLException e) { 
			e.printStackTrace();
		} catch (RemoteException e) { 
			e.printStackTrace();
		} catch (NotBoundException e) { 
			e.printStackTrace();
		}
	}
}
