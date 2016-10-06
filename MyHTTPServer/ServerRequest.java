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
	private BufferedReader in;

	public ServerRequest(BufferedReader in)
	{
		this.in = in;
	}
	public String getHeader()
	{
		return "";
	}
	public String getMethod()
	{
		return "";
	}
	public String getResource()
	{
		return "";
	}
	public String getVersion()
	{
		return "";
	}
	public String getHeadboard()
	{
		return "";
	}

}