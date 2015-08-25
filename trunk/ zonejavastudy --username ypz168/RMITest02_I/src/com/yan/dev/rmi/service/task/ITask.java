/**
 *  Copyright(c) 2010-2011 Yan.Dev. All Rights Reserved.
 */
package com.yan.dev.rmi.common.intf;

import java.io.Serializable;

/**
 * Comment for ITask.java
 *
 * @author <a href="mailto:yan.dev@hotmail.com">yan.dev</a>
 * 
 * @blog:<a href="http://yan-dev.javaeye.com"><b>yan.dev's Blog</b></a>
 * @version 1.0
 * @time 2011-3-23 ионГ09:30:05
 */
public interface ITask  extends Serializable{
	public Object doTask();
}
