import java.io.*;
import java.net.*;

public class MyHTTPServer 
{

	public static void main(String[] args)
	{
		// creación del socket
		int port = 8080;

			MyHTTPServer server = new MyHTTPServer();
			server.DefaultConection(port);
	}
	public static String DefaultPage()
	{
				return " ";
	}
	public void DefaultConection(int port)
	{
		try
		{
			ServerSocket serverSocket = new ServerSocket(port);
			System.err.println("El servidor corre con el puerto: "+ port);

			// espera las conexiones de clientes 
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
				out.write("Last-modified: Fri, 09 Aug 1996 14:21:40 GMT\r\n");
				out.write("\r\n"); // The content starts afters this empty line
				out.write("<TITLE>Hello!</TITLE>\r\n");
				out.write("<h1>Hola mundo !!!! </h1>");

				//al ternimar el flujo
				System.err.println("Conexión ha terminado");
				out.close();
				in.close();
				clientSocket.close();
			}
		}catch(IOException e){};
	}
}