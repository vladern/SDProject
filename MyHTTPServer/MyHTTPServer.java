import java.io.*;
import java.net.*;
import java.util.concurrent.*;
//package MyHTTPServer;

public class MyHTTPServer 
{

	public static void main(String[] args)
	{
		// creación del socket

			MyHTTPServer server = new MyHTTPServer();
			server.DefaultConection();
	}
	public void DefaultConection()
	{
			int cola = 4;
			int port = 8080;
			Semaphore semaforo = new Semaphore (cola);
			try
			{
				System.out.println("El servidor corre con el puerto: "+ port);
				// se bloquea en este punto hasta que reciba una conexión
				ServerSocket serverSocket = new ServerSocket(port);
				while(true)
				{
					Socket clientSocket = serverSocket.accept();
					Thread hilo0 = new Proceso(clientSocket);
					hilo0.start();
					semaforo.release();
					System.out.println("Un nuevo cliente se ha conectado");	
					semaforo.acquire();
				}
			}catch(IOException e)
			{

			}catch(InterruptedException e){

			}
	}

	public String leerArchivo(String archivo) throws FileNotFoundException, IOException 
	{
        String cadena;
        String aux="";
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
        //    System.out.println(cadena);
            aux=aux+cadena;
        }
        b.close();
        return aux;
	}
}