package Server;
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
				String s;
				s = in.readLine(); //usar split()
				String [] partes = s.split("/");
				this.method = partes[0];
				this.resource = partes[1];
				this.version = partes[2];
				this.headboard = partes[3];
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