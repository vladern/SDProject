package com.autentia.rmi;
import java.io.*;
import java.net.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
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
			if(encontradoSet)
			{
				String[] partes = peticion.replace("?"," ").split(" ");
				String[] apartado = partes[0].split("=");
				String[] direccion = partes[1].split("=");
				System.out.println("apartado:"+apartado[0]+"="+apartado[1]+"direccion:"+direccion[1]);
			}else
			{
				String[] partes = peticion.replace("?"," ").split(" ");
				String apartado = partes[0];
				String[] direccion = partes[1].split("=");
				System.out.println("apartado:"+apartado+"direccion:"+direccion[1]);

				OutputStream aux1 = clientSocket.getOutputStream();
				DataOutputStream flujo1= new DataOutputStream( aux1 );
				flujo1.writeUTF(respuestaRMI(direccion[1],apartado));
			}
		}catch(IOException e)
		{

		}/*atch(NotBoundException ex)
		{

		}*/
	}
	private String respuestaRMI(String nombreEsclavo,String peticion)
	{
		try
		{
			Registry registry = LocateRegistry.getRegistry(remoteHost, Registry.REGISTRY_PORT);
			String[] remoteObjNames = registry.list();
			for (String remoteObjName : remoteObjNames)
			{
				SlaveServices obj =(SlaveServices)registry.lookup(remoteObjName);
				if (remoteObjName.equals(nombreEsclavo)) 
				{
					/*System.out.println("Calling remote object: " + remoteObjName);
					final ServerServices server = (ServerServices)obj;
					System.out.println(server.sayHelloWorld());*/
					return "he encontrado el esclavo";
				}else
				{
					return "no he encontrado el esclavo";
				}
			}
			return "algo en el for fue mal";
		}catch(RemoteException e)
		{
			return "RemoteException";			
		}catch(NotBoundException ex)
		{
			return "NotBoundException";
		}


	}
}