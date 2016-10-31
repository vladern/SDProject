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
	public String cabecera(String cuerpo)
	{
		String text = "HTTP/1.0 200 OK\r\n";
		text = text + "Last-modified: Fri, 09 Aug 2016 14:21:40 GMT\r\n";
		text = text + "Cnection: close\r\n";
		text = text + "Content-Type: text/html; charset=ISO-8859-1\r\n";
		text = text + "Server: myHttpServer\r\n";
		text = text + "Content-Lenght: 8000\r\n";
		text = text + "\r\n";
		text = text + cuerpo;
		return text;
	}
	public String doGet(String controlerHost,int controlerPort)
	{
		try
		{
			if(request.getResource().equals(" HTTP"))
			{
				return cabecera(html.leerTXT("HTML/indice.html"));
			}else if(request.getResource().equals("favicon.ico HTTP"))
			{
				return "";
			}else
			{	
				System.out.println("++"+request.getVersion()+"++");
				if(request.getVersion().equals("controladorSD"))
				{
					Cliente cliente = new Cliente(controlerHost,controlerPort);
					String[] parte = request.getHeadboard().split(" ");
					System.out.println("--"+parte[0]+"--");
					return cabecera(cliente.getInfo(parte[0]));
				}else if(!request.getVersion().equals(" HTTP"))
				{
					System.out.println("respuesta");
					return cabecera("<h1>Error recurso mal especificado</h1>");
				}else
				{
					System.out.println("--"+request.getResource()+"--");
					return cabecera(html.leerTXT("HTML/"+request.getResource()));
				}
			} 
			
		}catch(FileNotFoundException e)
		{
			System.out.println("Excepion de fichero no encontrado");
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
			return cabecera(html.leerTXT("HTML/error.html"));	
		}catch(FileNotFoundException e)
		{
			return"";
		}catch(IOException e)
		{
			return"";
		}
	}
}