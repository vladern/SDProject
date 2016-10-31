package com.autentia.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SlaveMain {

	public static void main(String[] args) throws Exception {
		final String remoteHost = args[0];
		final String slaveRmiName = args[1];
		
		final Registry registry = LocateRegistry.getRegistry(remoteHost, Registry.REGISTRY_PORT);
		final Slave slave = new Slave(slaveRmiName);

		System.out.println("Register " + slave.getRmiName() + " through the Master.");
		final MasterServices master = (MasterServices)registry.lookup(Master.RMI_NAME);
		master.registerSlave(slave);
		// Lectura de hasta 10 bytes
		byte [] buffer = new byte[10];
		System.out.println("Enter para parar el esclavo:");
		System.in.read(buffer);
		if(buffer!=null)
		{
			master.unregisterSlave(slave);
			System.exit(0);
		}
	}
}
