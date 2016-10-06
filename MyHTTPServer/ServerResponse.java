package Server;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class ServerResponse
{
	private ServerRequest request;

	public ServerResponse(ServerRequest r)
	{
		this.request = r;
	}
	public String doGet()
	{
		return "";
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
		return"";
	}
}