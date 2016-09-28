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

			 Thread hilo = new Proceso("proceso 1");
			 Thread hilo2 = new Proceso("proceso 2");

			 hilo.start();
			 hilo2.start();
	}
}