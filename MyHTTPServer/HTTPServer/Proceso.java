package HTTPServer;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

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



				ServerRequest peticion = new ServerRequest(in); //instanciar el ServerRequest
				ServerResponse respuesta = new ServerResponse(peticion); //instanciar el ServerResponse

				if(peticion.getMethod().equals("GET "))
				{
					//System.out.println("El recurso es:"+peticion.getResource());
					out.write(respuesta.doGet());//mando la respuesta del get
				}else
				{
					out.write(respuesta.doError()); // mando un html de un error
				}
				System.err.println("Conexión ha terminado");//al ternimar el flujo cierro todos los flujos
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