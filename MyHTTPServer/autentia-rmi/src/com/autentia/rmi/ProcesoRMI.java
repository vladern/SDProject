package com.autentia.rmi;
import java.io.*;
import java.net.*;

public class ProcesoRMI extends Thread 
{
	private String remoteHost;
	private Socket clientSocket;
	public ProcesoRMI(Socket clientSocket,String remoteHost)
	{
		super();
		this.clientSocket=clientSocket;
		this.remoteHost=remoteHost;
	}
	public void run()
	{
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream())); //buffer de entrada
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(this.clientSocket.getOutputStream()));//buffer de salida
			String peticion = in.readLine();
			System.out.println("++"+peticion+"++");
		/*	Registry registry = LocateRegistry.getRegistry(remoteHost, Registry.REGISTRY_PORT);
			String[] remoteObjNames = registry.list();
			for (String remoteObjName : remoteObjNames)
			{
				Object obj = registry.lookup(remoteObjName);
				if (obj instanceof ServerServices) 
				{
					System.out.println("Calling remote object: " + remoteObjName);
					final ServerServices server = (ServerServices)obj;
					System.out.println(server.sayHelloWorld());
				}
			}
		*/
		}catch(IOException e)
		{

		}
	}
}