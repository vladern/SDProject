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
			System.out.println("Estoy en el");
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
				System.out.println("a punto de responder");
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
			System.out.println("Entro al respuestaRMI");
			Registry registry = LocateRegistry.getRegistry(remoteHost, Registry.REGISTRY_PORT);
			String[] remoteObjNames = registry.list();
	        for (String remoteObjName : remoteObjNames) 
	        {
	            Object obj = registry.lookup(remoteObjName);
	            if (obj instanceof SlaveServices) {
	                System.out.println("llamando al Esclavo: " + remoteObjName);
	                final SlaveServices server = (SlaveServices)obj;
	                if(server.getRmiName().equals(nombreEsclavo))
	                {
	                	if(peticion.equals("volumen"))
	                	{
	                		return "volumen="+server.getVolumen();
	                	}else if(peticion.equals("fecha"))
	                	{
	                		return "fecha="+server.getFecha();
	                	}else if(peticion.equals("ultimafecha"))
	                	{
	                		return "ultimafecha="+server.ultimaFecha();
	                	}else if(peticion.equals("luz"))
	                	{
	                		return "color del led es ="+server.getColor();
	                	}
	                	return "he encontrado mi esclavo";
	                }
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