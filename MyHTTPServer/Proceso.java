import java.io.*;
import java.net.*;
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
				// flujo de conversación 
				BufferedReader in = new BufferedReader(new InputStreamReader(this.skCliente.getInputStream()));
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(this.skCliente.getOutputStream()));
				String s;
				s = in.readLine();
//				System.out.println("Estoy dentro!");

				MyHTTPServer archivoHTML = new MyHTTPServer();
				String archivo = archivoHTML.leerArchivo("/home/vladernn/Escritorio/ProyectoSD/project/SDProject/MyHTTPServer/indice.txt");
//				System.out.println(archivo);
				out.write("HTTP/1.0 200 OK\r\n");
				// Header...
				out.write("Last-modified: Fri, 09 Aug 2016 14:21:40 GMT\r\n");
				out.write("\r\n"); // The content starts afters this empty line
			
				MyHTTPServer server = new MyHTTPServer();
				out.write(archivo);
				//al ternimar el flujo
				System.err.println("Conexión ha terminado");

				out.close();
				in.close();
				this.skCliente.close();
			}
		}catch(IOException e){};
	}
	public int concurencia()
	{
		return 1;
	}
}