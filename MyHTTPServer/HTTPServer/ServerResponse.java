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
			if(request.getResource().equals(" HTTP"))
			{
				String text = "HTTP/1.0 200 OK\r\n";
				text = text + "Last-modified: Fri, 09 Aug 2016 14:21:40 GMT\r\n";
				text = text + "\r\n";
				text = text + html.leerTXT("HTML/indice.html");
				return text;
			}else
			{	
				if(request.getResource().equals("controladorSD"))
				{
					Cliente cliente = new Cliente();
					String[] parte = request.getVersion().split(" ");
					System.out.println("--"+parte[0]+"--");
					return cliente.getInfo(parte[0]);
				}else
				{
					System.out.println("--"+request.getResource()+"--");
					return html.leerTXT("HTML/"+request.getResource());
				}
			} 
			
		}catch(FileNotFoundException e)
		{
			return null;
		}catch(IOException e)
		{
			return null;
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
			return html.leerTXT("HTML/error.html");	
		}catch(FileNotFoundException e)
		{
			return"";
		}catch(IOException e)
		{
			return"";
		}
	}
}