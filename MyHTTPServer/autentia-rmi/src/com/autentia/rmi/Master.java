package com.autentia.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.rmi.AccessException;

public class Master extends UnicastRemoteObject implements MasterServices {

	private static final long serialVersionUID = 1L;

	static final String RMI_NAME = Master.class.getSimpleName();

	private final Registry registry;

	protected Master(Registry registry) throws RemoteException {
		super();
		this.registry = registry;
	}

	public void registerSlave(SlaveServices slave) throws RemoteException 
	{
		String rmiName;
		try {
			rmiName = slave.getRmiName();
			registry.rebind(rmiName, slave);
		} catch (RemoteException e) {
			e.printStackTrace();
			throw e;
		}
		System.out.println("Registered: " + rmiName);
	}
	public void unregisterSlave(SlaveServices slave)throws RemoteException
	{
		String rmiName="";
		try {
			rmiName = slave.getRmiName();
			registry.unbind(rmiName);
		} catch (RemoteException e) {
			e.printStackTrace();
		}catch(NotBoundException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("Unregistered: " + rmiName);
	}

	public void sayHelloWorld() throws RemoteException {
		System.out.println("I'm de Master, and I'm unique !!!");
	}
}
