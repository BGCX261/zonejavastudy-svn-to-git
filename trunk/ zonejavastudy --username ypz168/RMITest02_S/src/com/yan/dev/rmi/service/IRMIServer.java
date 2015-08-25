/**
 *  Copyright(c) 2010-2011 Yan.Dev. All Rights Reserved.
 */
package com.yan.dev.rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Comment for IRMIServer.java
 * 
 * @author <a href="mailto:yan.dev@hotmail.com">yan.dev</a>
 * 
 * @blog:<a href="http://yan-dev.javaeye.com"><b>yan.dev's Blog</b></a>
 * @version 1.0
 * @time 2011-3-24 ÉÏÎç11:29:29
 */
public interface IRMIServer {
	public void registry() throws RemoteException;

	public void bind(String sName, Remote obj) throws RemoteException;

	public void bind(int port, String sName, Remote obj) throws RemoteException;

	public void bind(String ip, String sName, Remote obj)
			throws RemoteException;

	public void bind(String ip, int port, String sName, Remote obj)
			throws RemoteException;

	public void unbind(String sName) throws RemoteException;

	public void unbind(int port, String sName) throws RemoteException;

	public void unbind(String ip, String sName) throws RemoteException;

	public void unbind(String ip, int port, String sName)
			throws RemoteException;

}
