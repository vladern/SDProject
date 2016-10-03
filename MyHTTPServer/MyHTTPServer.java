import java.io.*;
import java.net.*;
//package MyHTTPServer;

public class MyHTTPServer 
{

	public static void main(String[] args)
	{
		// creación del socket

			MyHTTPServer server = new MyHTTPServer();
			server.DefaultConection();
	}
	public static String DefaultPage()
	{
				return "<h1 style=\"text-align:center;\">Sistemas tecnologicos para todos !!</h1> " +
				"<p style=\"text-align:center;\">Gerstion de aparcamientos CC La Marina :)</p>";
	}
	public void DefaultConection()
	{
			int cola = 4;
			int port = 8080;
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
					System.out.println("Un nuevo cliente se ha conectado");
				}
			}catch(IOException e){}

	}

	public String leerArchivo(String archivo) throws FileNotFoundException, IOException 
	{
	      String cadena ="";
	      FileReader f = new FileReader(archivo);
	      BufferedReader b = new BufferedReader(f);
	      while(b.readLine()!=null) {
	          cadena = cadena + b.readLine();
	      }
	      b.close();
	      return cadena;
	}
}