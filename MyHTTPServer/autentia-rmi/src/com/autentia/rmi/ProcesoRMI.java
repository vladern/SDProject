package com.autentia.rmi;
import java.io.*;
import java.net.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.lang.ArrayIndexOutOfBoundsException;
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
			boolean encontrarSonda = peticion.toUpperCase().contains("sondas=sondas".toUpperCase());
			if(encontradoSet)
			{
				String[] partes = peticion.split("&");
				String[] apartado = partes[0].split("=");
				String[] direccion = partes[1].split("=");
				System.out.println("apartado:"+apartado[0]+" = "+apartado[1]+" direccion:"+direccion[1]);

				OutputStream aux1 = clientSocket.getOutputStream();
				DataOutputStream flujo1= new DataOutputStream( aux1 );
				System.out.println("a punto de responder");
				flujo1.writeUTF(respuestaRMI(direccion[1],apartado[0],apartado[1]));

			}else if(encontrarSonda)
			{
				
				OutputStream aux1 = clientSocket.getOutputStream();
				DataOutputStream flujo1= new DataOutputStream( aux1 );
				System.out.println("a punto de responder");
				flujo1.writeUTF(listaDeSondas());
			}else
			{
				String[] partes = peticion.replace("?"," ").split(" ");
				String apartado = partes[0];
				String[] direccion = partes[1].split("=");
				System.out.println("apartado:"+apartado+" direccion:"+direccion[1]);

				OutputStream aux1 = clientSocket.getOutputStream();
				DataOutputStream flujo1= new DataOutputStream( aux1 );
				System.out.println("a punto de responder");
				flujo1.writeUTF(respuestaRMI(direccion[1],apartado));
			}
		}catch(IOException e)
		{

		}catch(ArrayIndexOutOfBoundsException ex)
		{
			try
			{
				OutputStream aux1 = clientSocket.getOutputStream();
				DataOutputStream flujo1= new DataOutputStream( aux1 );
				flujo1.writeUTF("Error 409:función no especificada");
			}catch(IOException exx)
			{

			}

		}
	}
	private String listaDeSondas()
	{
		try
		{
			System.out.println("Entro en la listaDeSondas");
			Registry registry = LocateRegistry.getRegistry(remoteHost, Registry.REGISTRY_PORT);
			String[] remoteObjNames = registry.list();
			String devolver="<body>";
			for(String nombres : remoteObjNames)
			{
				devolver+=nombres+" ";
			}
			return devolver+="</body>";
		}catch(RemoteException e)
		{
			return "RemoteException";
		}

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
	                System.out.println("el nombre del server es:"+server.getRmiName());
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
	                	return "<h1 style=\"text-align:center\">Error 409 no existe dicha peticion</h1>";
	                }
	            }
	        }
			return "<h1 style=\"text-align:center\">Error 409 no existe dicha sonda</h1>";
		}catch(RemoteException e)
		{
			return "<h1 style=\"text-align:center\">Error 409</h1>";			
		}catch(NotBoundException ex)
		{
			return "NotBoundException";
		}
	}
	private String respuestaRMI(String nombreEsclavo,String peticion,String aEscribir)
	{
		try
		{
			System.out.println("Entro al set respuestaRMI");
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
	                	System.out.println("el nombre del server es:"+server.getRmiName()+"con la peticion "+peticion);
	                	if(peticion.equals("?setluz"))
	                	{
	                		return "Se ha escrito el color?: "+server.setColor(aEscribir);
	                	}
	                	return "<h1 style=\"text-align:center\">Error 409:no existe dicha variable</h1>";
	                }
	            }
	        }
			return "<h1 style=\"text-align:center\">Error 409:no existe dicha sonda</h1>";
		}catch(RemoteException e)
		{
			return "<h1 style=\"text-align:center\">Error 409</h1>";			
		}catch(NotBoundException ex)
		{
			return "NotBoundException";
		}
	}
}