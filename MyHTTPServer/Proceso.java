import java.io.*;
import java.net.*;
//package MyHTTPServer;

public class Proceso extends Thread
{
	public Proceso(String msg)
	{
		super(msg);
	}
	public void run()
	{
		int port = 8080;
		System.out.println("Se esta ejecutando: " + this.getName());
		
		System.err.println("El servidor corre con el puerto: "+ port);
		try
		{
		ServerSocket serverSocket = new ServerSocket(port);
			while(true)
			{
				// se bloquea en este punto hasta que reciba una conexión
				Socket clientSocket = serverSocket.accept();
				System.err.println("Un nuevo cliente se ha conectado");

				// flujo de conversación 
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

				String s;
				s = in.readLine();
				while(s != null)
				{
				System.out.println(s);

					if(s.isEmpty())
					{
						break;
					}
					break;
				}
		
				out.write("HTTP/1.0 200 OK\r\n");
				// Header...
				out.write("Last-modified: Fri, 09 Aug 2016 14:21:40 GMT\r\n");
				out.write("\r\n"); // The content starts afters this empty line
				out.write("<TITLE>GACCLM</TITLE>\r\n");

				MyHTTPServer server = new MyHTTPServer();
				out.write(server.DefaultPage());

				//al ternimar el flujo
				System.err.println("Conexión ha terminado");
				out.close();
				in.close();
				clientSocket.close();
			}
		}catch(IOException e){};
	}
}