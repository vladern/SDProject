package com.autentia.rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;

public class Slave extends UnicastRemoteObject implements SlaveServices 
{
	private String rmiName;
	private String volumen;
	private String fecha;
	private String color;

	protected Slave(String rmiName) throws RemoteException
	{
		super();
		this.rmiName = rmiName;
		Reader read = new Reader();
		try
		{
			String [] datos = read.leerTXT("../../../../../TextoEsclavo/info.txt").split(" ");
			this.volumen=datos[0];
			this.fecha=datos[1];
			this.color=datos[2];
		}catch(FileNotFoundException e)
		{

		}catch(IOException ex)
		{

		}

	}
	public String getVolumen()
	{
		return volumen;
	}
	public String getFecha()
	{
		return fecha;
	}
	public String getColor()
	{
		return color;
	}
	public String sayHelloWorld() throws RemoteException 
	{
		return "I'm the slave " + getRmiName() + ", and I say: Hellow world !!!";
	}

	public String getRmiName() throws RemoteException 
	{
		return rmiName;
	}
	public boolean setColor()
	{
		return true;
	}
}
