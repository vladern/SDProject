import java.io.*;
import java.net.*;
import java.util.concurrent.*;
import HTTPServer.Proceso;

public class MyHTTPServer 
{

	public static void main(String[] args)
	{
		int cola = 5;
		String controlerHost = args[0];
		String controlerPort = args[1];
		String port = args[2];
		try
		{
			System.out.println("El servidor corre con el puerto: "+ port);
			System.out.println("El controler esta en la ip:"+controlerHost);
			ServerSocket serverSocket = new ServerSocket(Integer.parseInt(port)); // se crea el socket para la comunicacion 
			while(true)
			{
				Socket clientSocket = serverSocket.accept(); // se bloquea en este punto hasta que reciba una conexión
				Thread hilo0 = new Proceso(clientSocket,controlerHost,Integer.parseInt(controlerPort));
				System.out.println("El numero de hilos es:"+hilo0.activeCount());
				if(hilo0.activeCount()<=cola)
				{
					hilo0.start(); // lanzamos el hilo
				}else
				{
					clientSocket.close();
				}
				
			}
		}catch(IOException e) // se captura la excepcion del socket 
		{

		}
	}
}