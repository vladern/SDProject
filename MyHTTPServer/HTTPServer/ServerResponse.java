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
				String s = request.getResource();
				String[] partes = s.split(" ");
				String[] tipo = partes[0].replace("."," ").split(" ");
				System.out.println(partes[0]+","+partes[1]);
				System.out.println("-"+tipo[1]+"-");
				if(partes[0].equals("favicon.ico"))
				{
					String img = "Content-Type: image/pjpeg; name=\"favicon.ico\"\r\n";
					img = img + "Content-Transfer-Encoding: base64\r\n";
					img = img + "\r\n";
					img = img + html.leerJPG("HTML/favicon.ico");
					return img;
				}else if(tipo[1].equals("jpg"))
				{
					String img = "Content-Type: image/pjpeg; name=\"nivelGay.jpg\"\r\n";
					img = img + "Content-Transfer-Encoding: base64\r\n";
					img = img + "\r\n";
					img = img + html.leerJPG("HTML/"+partes[0]);
					img = img + "\r\n";
					img = img + "\r\n";
					img = img + "----8CFDA75A284D5A8033E016C87CBCE897--";
					return img;
				}else
				{
					return html.leerTXT("HTML/"+partes[0]);
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