import java.io.*;
import java.net.*;
import java.util.concurrent.*;
//package MyHTTPServer;

public class Proceso extends Thread
{
	private Socket skCliente;		
	public Proceso(Socket psCliente)
	{
		this.skCliente = psCliente;
	}
	public void run()
	{
		try
		{

			while(true)
			{
				Semaphore semaforo = new Semaphore(1);//defino el semaforo

				semaforo.acquire();//parada del semaforo


				BufferedReader in = new BufferedReader(new InputStreamReader(this.skCliente.getInputStream())); //buffer de entrada
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(this.skCliente.getOutputStream()));//buffer de salida

				String s;
				s = in.readLine(); //usar split()
				System.out.println(s);//saco por pantalla la petición del cliente
				String[] partes = s.split("/");
				System.out.println(partes[0]);
				System.out.println(partes[1]);
				System.out.println(partes[2]);


				MyHTTPServer archivoHTML = new MyHTTPServer(); //instanciar el server
				String archivo="";
				if(partes[0]=="GET" && partes[1]==" HTTP" && partes[2]=="1.1")
				{
					archivo = archivoHTML.leerArchivo("/home/vladernn/Escritorio/ProyectoSD/project/SDProject/MyHTTPServer/indice.txt");//leo el archivo del html
				}else if(partes[0]=="GET" && partes[1]=="favicon.ico HTTP" && partes[2]=="1.1")
				{
					
				}else
				{
					archivo = archivoHTML.leerArchivo("/home/vladernn/Escritorio/ProyectoSD/project/SDProject/MyHTTPServer/error.txt");
				}
				

				out.write("HTTP/1.0 200 OK\r\n");
//				out.write("Last-modified: Fri, 09 Aug 2016 14:21:40 GMT\r\n");
				out.write("\r\n"); // The content starts afters this empty line
				out.write(archivo);

				
				System.err.println("Conexión ha terminado");//al ternimar el flujo cierro todos los flujos
				out.close();
				in.close();
				this.skCliente.close();

				semaforo.release();
			}
		}catch(IOException e)
		{
		//	System.out.println("Error 403");
		//	System.out.println(e.toString());
		}catch(InterruptedException e) // se captura la excepcion de los semaforos
		{
			System.out.println("Error 404");
		}
	}
}