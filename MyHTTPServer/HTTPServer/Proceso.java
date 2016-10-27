package HTTPServer;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Proceso extends Thread
{
	private Socket skCliente;
	private String controlerHost;
	private int controlerPort;		
	public Proceso(Socket psCliente,String controlerHost,int controlerPort)
	{
		super();
		this.skCliente = psCliente;
		this.controlerHost= controlerHost;
		this.controlerPort=controlerPort;
	}
	public void run()
	{
		try
		{

			while(true)
			{

				BufferedReader in = new BufferedReader(new InputStreamReader(this.skCliente.getInputStream())); //buffer de entrada
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(this.skCliente.getOutputStream()));//buffer de salida

				ServerRequest peticion = new ServerRequest(in); //instanciar el ServerRequest
				ServerResponse respuesta = new ServerResponse(peticion); //instanciar el ServerResponse
				System.out.println("----"+peticion.getMethod()+"----");
				if(peticion.getMethod().equals("GET "))
				{
					out.write(respuesta.doGet(controlerHost,controlerPort));//mando la respuesta del get
				}else
				{
					out.write(respuesta.doError()); // mando un html de un error
				}
				System.out.println("Conexión ha terminado");//al ternimar el flujo cierro todos los flujos
				out.close();
				in.close();
				this.skCliente.close();
			}
		}catch(IOException e)
		{
		//	System.out.println("Error 403");
		//	System.out.println(e.toString());
		}
	}
}