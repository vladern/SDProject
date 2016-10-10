package HTTPServer;
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

				BufferedReader in = new BufferedReader(new InputStreamReader(this.skCliente.getInputStream())); //buffer de entrada
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(this.skCliente.getOutputStream()));//buffer de salida

//				String s;
//				s = in.readLine(); //usar split()

//				String[] partes = s.split("/");

				ServerRequest peticion = new ServerRequest(in); //instanciar el ServerRequest
				ServerResponse respuesta = new ServerResponse(peticion); //instanciar el ServerResponse


				out.write("HTTP/1.0 200 OK\r\n");
				out.write("Last-modified: Fri, 09 Aug 2016 14:21:40 GMT\r\n");
				out.write("\r\n"); // The content starts afters this empty readLine
				if(peticion.getMethod().equals("GET "))
				{
					out.write(respuesta.doGet()); //mando la respuesta del get
				}else
				{
					out.write(respuesta.doError()); // mando un html de un error
				}
				System.err.println("Conexión ha terminado");//al ternimar el flujo cierro todos los flujos
				out.close();
				in.close();
				//this.skCliente.close();
			}
		}catch(IOException e)
		{
		//	System.out.println("Error 403");
		//	System.out.println(e.toString());
		}/*catch(InterruptedException e) // se captura la excepcion de los semaforos
		{
			System.out.println("Error 404");
		}*/
	}
}