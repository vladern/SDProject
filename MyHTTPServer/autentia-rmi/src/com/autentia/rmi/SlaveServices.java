package com.autentia.rmi;

import java.rmi.RemoteException;
/**
 * Define que pueden hacer los nodos Slave.
 */
public interface SlaveServices extends ServerServices 
{
	public String getRmiName() throws RemoteException;
	public String getVolumen() throws RemoteException;
	public String getFecha() throws RemoteException;
	public String getColor()throws RemoteException;
	public boolean setColor(String aEscribir)throws RemoteException;
	public String ultimaFecha() throws RemoteException;
}
