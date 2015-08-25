/**
 *  Copyright(c) 2010-2011 Yan.Dev. All Rights Reserved.
 */
package com.yan.dev.rmi.server;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.apache.xmlbeans.XmlException;

import com.yan.dev.rmi.service.impl.RMIServerImpl;
import com.yan.dev.rmi.service.play.IPlay;
import com.yan.dev.rmi.service.play.impl.PlayImpl;
import com.yan.dev.rmi.service.xsd.ComponentDocument;
import com.yan.dev.rmi.service.xsd.ImplementationDocument;
import com.yan.dev.rmi.service.xsd.PropertyDocument;
import com.yan.dev.rmi.service.xsd.ProvideDocument;
import com.yan.dev.rmi.service.xsd.ServiceDocument;

/**
 * Comment for Server.java
 * 
 * @author <a href="mailto:yan.dev@hotmail.com">yan.dev</a>
 * 
 * @blog:<a href="http://yan-dev.javaeye.com"><b>yan.dev's Blog</b></a>
 * @version 1.0
 * @time 2011-3-23 上午09:27:40
 */
public class ServerTest {
	public static void main(String[] args) {
		RMIServerImpl rmi=new RMIServerImpl();
		
//		rmi.bind(serviceName, obj)
//		testService();
//		createRMIServer();
	}

	public static void createRMIServer() {
		int port = 1234;
		String ip = "localhost";
		System.setProperty("java.security.policy", "d:\\swo.policy");
		try {
			System.out.println("Server::开始注册。。。");
			LocateRegistry.createRegistry(port);
			System.out.println("Server::注册成功！");
			IPlay play = new PlayImpl();
			System.out.println("Server::开始绑定。。。");
			Naming.rebind("//" + ip + ":" + port + "/play", play);
			System.out.println("Server::绑定成功，服务器启动成功，等待客户调用。。。");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static void testService() {
		try {
			File xmlfile = new File("..\\RMITest02_I\\services\\play.xml");
			ComponentDocument doc = ComponentDocument.Factory.parse(xmlfile);
			ComponentDocument.Component comp = doc.getComponent();
			System.out.println(comp.getName());

			PropertyDocument.Property[] prop = comp.getPropertyArray();
			for (int i=0;i<prop.length;i++) {				
				System.out.println("Prop["+i+"].name="+prop[i].getName());
				System.out.println("Prop["+i+"].type="+prop[i].getType());
				System.out.println("Prop["+i+"].value="+prop[i].getValue());
			}
			ServiceDocument.Service service = comp.getService();
			ProvideDocument.Provide prov = service
					.getProvide();
			System.out.println(prov.getInterface());

			ImplementationDocument.Implementation impl = comp.getImplementation();
					
			System.out.println(impl.getClass1());

		} catch (XmlException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
