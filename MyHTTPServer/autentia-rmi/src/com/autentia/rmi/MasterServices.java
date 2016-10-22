package com.autentia.rmi;

import java.rmi.RemoteException;
import java.rmi.Remote;

/**
 * Define que pueden hacer los nodos Maseter.
 */
public interface MasterServices extends Remote
{	

	public void registerSlave(SlaveServices slave) throws RemoteException;
}
