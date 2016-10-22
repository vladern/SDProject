package HTTPServer;
import java.io.*;
import java.net.*;


class Cliente
{
	private String controlerHost;
	public Cliente(String controlerHost)
	{
		this.controlerHost=controlerHost;
	}
	public String getInfo(String sol)
	{
		try
		{
			int port=8081;
			System.out.println("Contacto con el controlador con la ip:"+controlerHost);
			Socket skCliente = new Socket(controlerHost,port);
			BufferedReader in = new BufferedReader(new InputStreamReader(skCliente.getInputStream())); //buffer de entrada
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(skCliente.getOutputStream()));//buffer de salida

			out.write(sol);
			String respuesta=in.readLine();
			skCliente.close();
			in.close();
			out.close();
			return respuesta;
		}catch(IOException e)
		{
			return null;
		}
	}
}