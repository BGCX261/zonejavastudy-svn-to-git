/**
 *  Copyright(c) 2010-2011 Yan.Dev. All Rights Reserved.
 */
package com.yan.dev.rmi.service.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.yan.dev.rmi.service.task.ITask;

/**
 * Comment for TaskImpl.java
 * 
 * @author <a href="mailto:yan.dev@hotmail.com">yan.dev</a>
 * 
 * @blog:<a href="http://yan-dev.javaeye.com"><b>yan.dev's Blog</b></a>
 * @version 1.0
 * @time 2011-3-23 ����09:31:14
 */
public class TaskImpl implements ITask {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7370580208112892017L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yan.dev.rmi.intf.ITask#doClientTask()
	 */
	@Override
	public Object doTask() {
		String ip = "Unknown";
		System.out.println("Server::TaskImpl.doTask()��ǰ����������Զ�̵�����");
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 
		try {
			Runtime.getRuntime().exec("C:\\Program Files\\Windows Media Player\\wmplayer E:\\mp3\\����\\����-��ظ�ԭ.mp3");

			System.out.println("Server::TaskImpl.doTask()���ڲ�������");
		} catch (IOException e) { 
			e.printStackTrace();
		}
		return "�ͻ��˶�̬���ض���ķ���ֵΪServer��ip=" + ip;
	}

}
