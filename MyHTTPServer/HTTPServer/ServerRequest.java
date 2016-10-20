package HTTPServer;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class ServerRequest
{
	private String method;
	private String resource;
	private String version;
	private String headboard;

	public ServerRequest(BufferedReader in)
	{
		try{
				String s;
				s = in.readLine(); //usar split()
				System.out.println("--"+s+"--");
				String [] partes = s.split("/");
				this.method = partes[0];
				this.resource = partes[1];
				this.version = partes[2];
			}catch(IOException e)
			{
				System.out.println("Unable to read request");
			}
	}
	public String getHeader()
	{
		return "";
	}
	public String getBody()
	{
		return "";
	}
	public String getMethod()
	{
		return this.method;
	}
	public String getResource()
	{
		return this.resource;
	}
	public String getVersion()
	{
		return this.version;
	}
	public String getHeadboard()
	{
		return this.headboard;
	}

}