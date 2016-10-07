package MyHTTPServer;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class ServerResponse
{
	private ServerRequest request;
	private Reader html;

	public ServerResponse(ServerRequest r)
	{
		this.request = r;
	}
	public String doGet()
	{
		try
		{
			return html.leerTXT("home/vladernn/Escritorio/ProyectoSD/project/SDProject/MyHTTPServer/HTML/indice.txt");
		}catch(FileNotFoundException e)
		{
			return"";
		}catch(IOException e)
		{
			return"";
		}
	}
	public String doPost()
	{
		return"";
	}
	public String doPut()
	{
		return"";
	}
	public String doHead()
	{
		return"";
	}
	public String doError()
	{
		try
		{
			return html.leerTXT("home/vladernn/Escritorio/ProyectoSD/project/SDProject/MyHTTPServer/HTML/.txt");
		}catch(FileNotFoundException e)
		{
			return"";
		}catch(IOException e)
		{
			return"";
		}
	}
}