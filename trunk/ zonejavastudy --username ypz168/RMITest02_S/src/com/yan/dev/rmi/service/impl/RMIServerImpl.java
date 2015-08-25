/**
 *  Copyright(c) 2010-2011 Yan.Dev. All Rights Reserved.
 */
package com.yan.dev.rmi.service.impl;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.apache.xmlbeans.XmlException;

import com.yan.dev.rmi.conf.xsd.RmiconfDocument;
import com.yan.dev.rmi.server.common.Constants;
import com.yan.dev.rmi.service.IRMIServer;

/**
 * Comment for RMIServer.java
 * 
 * @author <a href="mailto:yan.dev@hotmail.com">yan.dev</a>
 * 
 * @blog:<a href="http://yan-dev.javaeye.com"><b>yan.dev's Blog</b></a>
 * @version 1.0
 * @time 2011-3-24 ÉÏÎç10:22:32
 */
public class RMIServerImpl implements IRMIServer {
	private String ip = Constants.RMI_DEFAULT_IP;
	private int port = Constants.RMI_DEFAULT_PORT;

	public RMIServerImpl() {
		getConf();
		try {
			registry();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void getConf() {
		File file = new File(Constants.RMI_CONF_FILE);
		try {
			RmiconfDocument doc = RmiconfDocument.Factory.parse(file);
			RmiconfDocument.Rmiconf conf = doc.getRmiconf();
			this.port = Integer.parseInt(conf.getPort().toString());
			this.ip = conf.getIp().toString();
			// System.out.println(port+":"+ip);
			conf = null;
			doc = null;
		} catch (XmlException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void registry() throws RemoteException {
		LocateRegistry.createRegistry(this.port);
	}

	public void bind(String sName, Remote obj) throws RemoteException {
		bind(this.ip, this.port, sName, obj);
	}

	public void bind(String ip, String sName, Remote obj)
			throws RemoteException {
		bind(ip, this.port, sName, obj);
	}

	public void bind(String ip, int port, String sName, Remote obj)
			throws RemoteException {
		try {
			Naming.rebind("rmi://" + ip + ":" + port + "/" + sName, obj);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yan.dev.rmi.server.IRMIServer#unbind(java.lang.String)
	 */
	@Override
	public void unbind(String sName) throws RemoteException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yan.dev.rmi.server.IRMIServer#bind(int, java.lang.String,
	 * java.rmi.Remote)
	 */
	@Override
	public void bind(int port, String sName, Remote obj) throws RemoteException {
		bind(this.ip, port, sName, obj);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yan.dev.rmi.server.IRMIServer#unbind(int, java.lang.String)
	 */
	@Override
	public void unbind(int port, String sName) throws RemoteException {
		unbind(this.ip, port, sName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yan.dev.rmi.server.IRMIServer#unbind(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void unbind(String ip, String sName) throws RemoteException {
		unbind(ip, this.port, sName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yan.dev.rmi.server.IRMIServer#unbind(java.lang.String, int,
	 * java.lang.String)
	 */
	@Override
	public void unbind(String ip, int port, String sName)
			throws RemoteException {
		try {
			Naming.unbind("rmi://" + ip + ":" + port + "/" + sName);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

}
