package com.autentia.rmi;
import java.io.*;
import java.net.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientMain 
{

	public static void main(String[] args) throws Exception 
	{
		final int cola = 5;
		final int port = 8081;
		final String remoteHost = args[0];
		try
		{
			System.out.println("El servidor corre con el puerto: "+ port);
			ServerSocket serverSocket = new ServerSocket(port); // se crea el socket para la comunicacion 
			while(true)
			{
				Socket clientSocket = serverSocket.accept(); // se bloquea en este punto hasta que reciba una conexión
				Thread hilo0 = new ProcesoRMI(clientSocket,remoteHost);
				System.out.println("El numero de hilos es:"+hilo0.activeCount());
				if(hilo0.activeCount()<=cola)
				{
					hilo0.start(); // lanzamos el hilo
				}else
				{
					clientSocket.close(); //si  hay mas numero de hilos permitidos cerramos la conexion
				}
				
			}			
		}catch(IOException e)
		{

		}
	}
}
