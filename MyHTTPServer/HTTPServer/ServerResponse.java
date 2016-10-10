package HTTPServer;
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
		this.html = new Reader();
	}
	public String doGet()
	{
		try
		{
			return html.leerTXT("HTML/indice.txt");
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
			return html.leerTXT("HTML/.txt");
		}catch(FileNotFoundException e)
		{
			return"";
		}catch(IOException e)
		{
			return"";
		}
	}
}