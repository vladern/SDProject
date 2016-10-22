package com.autentia.rmi;
import java.io.*;
import java.net.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
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
			InputStream aux = clientSocket.getInputStream();
			DataInputStream flujo = new DataInputStream( aux );
			String peticion = flujo.readUTF();

			String buscado = "setluz";
			System.out.println("++"+peticion+"++");
			boolean encontradoSet = peticion.toUpperCase().contains(buscado.toUpperCase()); // busco si contiene setluz
			Registry registry = LocateRegistry.getRegistry(remoteHost, Registry.REGISTRY_PORT);
			String[] remoteObjNames = registry.list();
			if(encontradoSet)
			{
				String[] partes = peticion.split("?");
				String[] apartado = partes[0].split("=");
				String[] direccion = partes[1].split("=");
				System.out.println("apartado:"+apartado[1]+"direccion:"+direccion[1]);
			}else
			{
				String[] partes = peticion.split("?");
				String apartado = partes[0];
				String[] direccion = partes[1].split("=");
				System.out.println("apartado:"+apartado+"direccion:"+direccion[1]);
			}
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
		}catch(IOException e)
		{

		}catch(NotBoundException ex)
		{

		}
	}
}