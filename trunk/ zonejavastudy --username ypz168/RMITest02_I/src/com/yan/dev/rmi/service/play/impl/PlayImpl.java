/**
 *  Copyright(c) 2010-2011 Yan.Dev. All Rights Reserved.
 */
package com.yan.dev.rmi.service.task.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.yan.dev.rmi.service.play.IPlay;
import com.yan.dev.rmi.service.task.ITask;

/**
 * Comment for PlayImpl.java
 * 
 * @author <a href="mailto:yan.dev@hotmail.com">yan.dev</a>
 * 
 * @blog:<a href="http://yan-dev.javaeye.com"><b>yan.dev's Blog</b></a>
 * @version 1.0
 * @time 2011-3-23 上午09:40:52
 */
public class PlayImpl  extends UnicastRemoteObject implements IPlay {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5384012885072746420L;

	/**
	 * @throws RemoteException
	 */
	public PlayImpl() throws RemoteException {
		super(); 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yan.dev.rmi.intf.IPlay#play(com.yan.dev.rmi.intf.ITask)
	 */
	@Override
	public Object play(ITask task) throws RemoteException {
		System.out.println("Server::PlayImple.paly开始被远程调用!");
		Object obj = task.doTask();
		System.out.println("Server::服务器远程响应=" + obj.toString());
		return obj;
	}

}
