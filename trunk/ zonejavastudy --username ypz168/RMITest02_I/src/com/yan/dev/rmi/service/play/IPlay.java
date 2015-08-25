/**
 *  Copyright(c) 2010-2011 Yan.Dev. All Rights Reserved.
 */
package com.yan.dev.rmi.service.task;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.yan.dev.rmi.service.task.ITask;

/**
 * Comment for IPlay.java
 * 
 * @author <a href="mailto:yan.dev@hotmail.com">yan.dev</a>
 * 
 * @blog:<a href="http://yan-dev.javaeye.com"><b>yan.dev's Blog</b></a>
 * @version 1.0
 * @time 2011-3-23 ионГ09:29:10
 */
public interface IPlay extends Remote {
	public Object play(ITask task) throws RemoteException;
}
