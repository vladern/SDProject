package com.autentia.rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.File;

public class Slave extends UnicastRemoteObject implements SlaveServices 
{
	private String rmiName;
	private File dir = new File(System.getProperty("user.home"), "Desktop");

	protected Slave(String rmiName) throws RemoteException
	{
		super();
		this.rmiName = rmiName;
	}
	public String getVolumen()
	{
		Reader read = new Reader();
		try
		{
			String path = dir.getAbsolutePath();
			path+=File.separator+"bdJava";
			String []datos = read.leerTXT(path).split("@");
			return datos[0];
		}catch(FileNotFoundException e)
		{
			System.out.println("no puedo encontrar la ruta o el archivo");
			return null;
		}catch(IOException ex)
		{
			return null;
		}
	}
	public String getFecha()
	{
		return getDateTime();
	}
	public String ultimaFecha()
	{
		Reader read = new Reader();
		try
		{
			String path = dir.getAbsolutePath();
			path+=File.separator+"bdJava";
			String []datos = read.leerTXT(path).split("@");
			return datos[1];

		}catch(FileNotFoundException e)
		{
			System.out.println("no puedo encontrar la ruta o el archivo");
			return null;
		}catch(IOException ex)
		{
			return null;
		}
	}
	public String getColor()
	{
		Reader read = new Reader();
		try
		{
			String path = dir.getAbsolutePath();
			path+=File.separator+"bdJava";
			String []datos = read.leerTXT(path).split("@");
			return datos[2];
		}catch(FileNotFoundException e)
		{
			System.out.println("no puedo encontrar la ruta o el archivo");
			return null;
		}catch(IOException ex)
		{
			return null;
		}
	}
	public String sayHelloWorld() throws RemoteException 
	{
		return "I'm the slave " + getRmiName() + ", and I say: Hellow world !!!";
	}

	public String getRmiName() throws RemoteException 
	{
		return rmiName;
	}
	public boolean setColor(String aEscibir)
	{
		String path = dir.getAbsolutePath();
		path+=File.separator+"bdJava";
		Reader datos = new Reader();
		if(datos.escribirTXT(path))
		{
			return true;
		}else
		{
			return false;
		}
	}
	private String getDateTime() 
	{
        DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
