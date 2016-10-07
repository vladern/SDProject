package MyHTTPServer;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class MyHTTPServer 
{

	public static void main(String[] args)
	{
		int cola = 1;
		int port = 8080;
		try
		{
			System.out.println("El servidor corre con el puerto: "+ port);
			ServerSocket serverSocket = new ServerSocket(port); // se crea el socket para la comunicacion 
			while(true)
			{
				Semaphore semaforo = new Semaphore (cola);
				semaforo.acquire(); //implementamos el semaforo para controlar que son 4 clientes como maximo a la vez
				Socket clientSocket = serverSocket.accept(); // se bloquea en este punto hasta que reciba una conexión
				Thread hilo0 = new Proceso(clientSocket);// se crea el hilo que responderá a la petición del cliente
				hilo0.start(); // lanzamos el hilo
				semaforo.release();// semaforos
			}
		}catch(IOException e) // se captura la excepcion del socket 
		{

		}catch(InterruptedException e) // se captura la excepcion de los semaforos
		{
			System.out.println("Error 404");
		}
	}
}